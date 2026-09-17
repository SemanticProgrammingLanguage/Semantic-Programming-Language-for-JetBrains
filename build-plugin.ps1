$ErrorActionPreference = "Stop"
Set-Location $PSScriptRoot

$gradleVersion = "9.0.0"
$toolsDir = Join-Path $PSScriptRoot ".tools"
$gradleDir = Join-Path $toolsDir "gradle-$gradleVersion"
$gradleBat = Join-Path $gradleDir "bin\gradle.bat"

function Find-JavaHome {
    if ($env:JAVA_HOME -and (Test-Path (Join-Path $env:JAVA_HOME "bin\java.exe"))) {
        return $env:JAVA_HOME
    }

    $javaCommand = Get-Command java.exe -ErrorAction SilentlyContinue
    if ($javaCommand) {
        return Split-Path (Split-Path $javaCommand.Source -Parent) -Parent
    }

    $patterns = @(
        "C:\Program Files\JetBrains\*\jbr",
        "$env:LOCALAPPDATA\Programs\*\jbr",
        "$env:USERPROFILE\.jdks\*"
    )

    foreach ($pattern in $patterns) {
        $candidate = Get-Item $pattern -ErrorAction SilentlyContinue |
            Where-Object { Test-Path (Join-Path $_.FullName "bin\java.exe") } |
            Sort-Object FullName -Descending |
            Select-Object -First 1

        if ($candidate) {
            return $candidate.FullName
        }
    }

    return $null
}

$javaHome = Find-JavaHome
if (-not $javaHome) {
    throw "No Java/JBR installation found. Install JDK 21 or IntelliJ IDEA 2024.2+."
}

$env:JAVA_HOME = $javaHome
$env:PATH = "$(Join-Path $javaHome 'bin');$env:PATH"

Write-Host "Using Java: $javaHome" -ForegroundColor Cyan
& (Join-Path $javaHome "bin\java.exe") -version

if (-not (Test-Path $gradleBat)) {
    New-Item -ItemType Directory -Force -Path $toolsDir | Out-Null
    $zipPath = Join-Path $toolsDir "gradle-$gradleVersion-bin.zip"

    if (-not (Test-Path $zipPath)) {
        Write-Host "Downloading Gradle $gradleVersion..." -ForegroundColor Cyan
        Invoke-WebRequest `
            -Uri "https://services.gradle.org/distributions/gradle-$gradleVersion-bin.zip" `
            -OutFile $zipPath
    }

    Write-Host "Extracting Gradle..." -ForegroundColor Cyan
    Expand-Archive -Path $zipPath -DestinationPath $toolsDir -Force
}

Write-Host "Building Semantic JetBrains plugin..." -ForegroundColor Cyan
& $gradleBat clean buildPlugin

if ($LASTEXITCODE -ne 0) {
    throw "JetBrains plugin build failed."
}

$packages = Get-ChildItem ".\build\distributions\*.zip" -ErrorAction SilentlyContinue
if (-not $packages) {
    throw "Build succeeded but no plugin ZIP was found under build\distributions."
}

Write-Host ""
Write-Host "Marketplace ZIP:" -ForegroundColor Green
$packages | ForEach-Object {
    Write-Host $_.FullName -ForegroundColor Green
}
