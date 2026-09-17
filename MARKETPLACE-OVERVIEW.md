<p align="center">
  <img
    width="640"
    alt="Semantic Programming Language Logo"
    src="https://raw.githubusercontent.com/SemanticProgrammingLanguage/Semantic-Programming-Language-for-JetBrains/main/SemanticLogo.png">
</p>

## Semantic Programming Language

Semantic Programming Language is a universal, matrix-driven programming language and compiler architecture built around canonical **SemanticProgram / Universal Abstract Syntax Tree (UAST)** representations.

The broader Semantic architecture represents programs independently of their original source language. Source code can be lowered into a canonical semantic representation and then processed through shared validation, transformation, transpilation and compiler stages.

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

## JetBrains integration

This plugin brings focused Semantic language support to JetBrains IDEs such as IntelliJ IDEA, GoLand, PyCharm, WebStorm and other IntelliJ Platform-based products.

### Features

- Syntax highlighting for `.se` and `.sp`
- Semantic keywords and constants
- Strings and numeric values
- `%N` value references
- `@N` type/reference identifiers
- `#` line comments
- Semantic operators and delimiters
- JetBrains file-type integration
- Semantic file icon
- Semantic plugin icon

## Example

```text
se 1

# Semantic Programming Language
program Demo
object Main

scope example {
    node item
    relations

    true
    false
    null
    unknown

    %12
    @42

    "Hello Semantic"
    123
}
```

## Semantic representation

The Semantic ecosystem is designed around a shared program representation rather than language-specific compiler pipelines.

A program can be represented canonically as:

```text
P = (V, E, T, A, C)
```

where the representation can preserve information such as:

- program structure
- types and scopes
- semantic relations
- evaluation order
- effects and execution constraints
- references and bindings
- canonical serialization

This shared representation is intended to provide a common foundation for tooling, transformation, transpilation and compilation.

## Publisher

**Tarek Wasfy**

## Website

https://www.semantic-programming-language.com/

## GitHub

JetBrains plugin:

https://github.com/SemanticProgrammingLanguage/Semantic-Programming-Language-for-JetBrains

Semantic Programming Language:

https://github.com/SemanticProgrammingLanguage/Semantic-Programming-Language

## License

MIT License

https://github.com/SemanticProgrammingLanguage/Semantic-Programming-Language-for-JetBrains/blob/main/LICENSE

