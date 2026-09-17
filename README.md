# Semantic Programming Language for JetBrains

Language support for **Semantic Programming Language** in JetBrains IDEs.

This plugin brings focused editor integration for Semantic source files to IntelliJ Platform-based IDEs such as IntelliJ IDEA, GoLand, PyCharm, WebStorm, CLion, Rider and other compatible JetBrains products.

## Overview

Semantic Programming Language is a universal, matrix-driven programming language and compiler architecture built around canonical **SemanticProgram / Universal Abstract Syntax Tree (UAST)** representations. Programs can be lowered into a language-independent semantic model that is designed to support validation, transformation, transpilation and compilation through a shared representation.

The broader Semantic toolchain uses the following conceptual pipeline:

```text
Source code
    ↓
Frontend
    ↓
SemanticProgram / UAST
    ↓
Semantic transformations and contracts
    ↓
Backend / target generation
```

This JetBrains plugin focuses specifically on making Semantic source files pleasant to read and edit inside JetBrains IDEs.

## Features

- Syntax highlighting for `.se` and `.sp` files
- Recognition of Semantic keywords and constants
- Highlighting for strings, numbers and references
- `#` line-comment support
- Semantic operators and delimiters
- JetBrains file-type integration
- Semantic file and plugin icons
- Lightweight language registration for IntelliJ Platform editors

## Highlighted Semantic syntax

The plugin recognizes core Semantic constructs such as:

```text
program
object
list
ranges
types
type
scopes
scope
nodes
node
relations
```

It also highlights:

- constants: `true`, `false`, `null`, `unknown`
- value references such as `%12`
- type/reference identifiers such as `@42`
- strings and numeric values
- operators including `->` and `=`
- structural delimiters and brackets
- comments beginning with `#`

## Semantic file formats

| Extension | Purpose |
|---|---|
| `.se` | Canonical readable Semantic representation |
| `.sp` | Compatibility alias for Semantic source |
| `.spz` | Compressed Semantic transport format; not edited as plain text by this plugin |

## Example

```text
se 1

# Semantic Programming Language example
program Demo
object Main

scope example {
    node item
    relations

    true
    %12
    @42
    "Hello Semantic"
    123
}
```

## About Semantic Programming Language

The Semantic architecture models programs independently of their original source language. The canonical representation is designed to preserve semantic information such as types, scopes, relations, evaluation order, effects and execution constraints while providing one shared representation for tooling and compiler stages.

The wider Semantic ecosystem includes a bootstrap compiler, CLI, GUI, Semantic/UAST processing, transpilation routes and experimental Semantic Modules.

## Links

- **Website:** https://www.semantic-programming-language.com/
- **JetBrains plugin source:** https://github.com/SemanticProgrammingLanguage/Semantic-Programming-Language-for-JetBrains
- **Semantic Programming Language:** https://github.com/SemanticProgrammingLanguage/Semantic-Programming-Language
- **Semantic Programming Language organization:** https://github.com/SemanticProgrammingLanguage

## Publisher

**Tarek Wasfy**

## License

Licensed under the **MIT License**.

https://github.com/SemanticProgrammingLanguage/Semantic-Programming-Language-for-JetBrains/blob/main/LICENSE

Copyright © 2026 Tarek Wasfy
