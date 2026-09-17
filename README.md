# Semantic Programming Language — JetBrains Syntax Highlighting

A focused, high-quality JetBrains plugin for Semantic `.se` and `.sp` source files.

## Highlighting

- Semantic headers (`se 1`, `sp 1`)
- keywords
- constants (`true`, `false`, `null`, `unknown`)
- strings with escapes
- integers, decimals, hexadecimal and exponent numbers
- numeric ranges (`1-10`, `20 - 42`)
- value references (`%12`)
- type/node references (`@42`)
- operators (`->`, `=`)
- delimiters and braces
- invalid characters
- `#` line comments

## Editor integration

- `.se` / `.sp` file recognition
- Semantic file icon
- comment/uncomment support
- brace, bracket and parenthesis matching
- **Settings → Editor → Color Scheme → Semantic**
- configurable colors for every Semantic token class

## Build

```powershell
.\build-plugin.ps1
```

The Marketplace ZIP is created under:

```text
build\distributions\
```

## Compatibility

IntelliJ Platform 2024.2+ (build 242+), Java 21.

Website: https://www.semantic-programming-language.com/
