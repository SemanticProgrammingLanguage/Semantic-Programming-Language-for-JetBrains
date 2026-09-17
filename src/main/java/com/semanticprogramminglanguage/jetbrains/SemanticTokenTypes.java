package com.semanticprogramminglanguage.jetbrains;

import com.intellij.psi.tree.IElementType;

public final class SemanticTokenTypes {
    public static final IElementType HEADER = type("HEADER");
    public static final IElementType KEYWORD = type("KEYWORD");
    public static final IElementType CONSTANT = type("CONSTANT");
    public static final IElementType STRING = type("STRING");
    public static final IElementType NUMBER = type("NUMBER");
    public static final IElementType RANGE = type("RANGE");
    public static final IElementType COMMENT = type("COMMENT");
    public static final IElementType REFERENCE_PERCENT = type("REFERENCE_PERCENT");
    public static final IElementType REFERENCE_AT = type("REFERENCE_AT");
    public static final IElementType OPERATOR = type("OPERATOR");
    public static final IElementType IDENTIFIER = type("IDENTIFIER");
    public static final IElementType LBRACE = type("LBRACE");
    public static final IElementType RBRACE = type("RBRACE");
    public static final IElementType LBRACKET = type("LBRACKET");
    public static final IElementType RBRACKET = type("RBRACKET");
    public static final IElementType LPAREN = type("LPAREN");
    public static final IElementType RPAREN = type("RPAREN");
    public static final IElementType DELIMITER = type("DELIMITER");

    private static IElementType type(String name) {
        return new IElementType("SEMANTIC_" + name, SemanticLanguage.INSTANCE);
    }

    private SemanticTokenTypes() {}
}
