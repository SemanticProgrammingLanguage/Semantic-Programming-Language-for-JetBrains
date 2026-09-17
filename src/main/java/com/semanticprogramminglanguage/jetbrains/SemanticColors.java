package com.semanticprogramminglanguage.jetbrains;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

public final class SemanticColors {
    public static final TextAttributesKey HEADER =
            key("SEMANTIC_HEADER", DefaultLanguageHighlighterColors.METADATA);
    public static final TextAttributesKey KEYWORD =
            key("SEMANTIC_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey CONSTANT =
            key("SEMANTIC_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey STRING =
            key("SEMANTIC_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER =
            key("SEMANTIC_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey RANGE =
            key("SEMANTIC_RANGE", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey COMMENT =
            key("SEMANTIC_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey VALUE_REFERENCE =
            key("SEMANTIC_VALUE_REFERENCE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    public static final TextAttributesKey TYPE_REFERENCE =
            key("SEMANTIC_TYPE_REFERENCE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    public static final TextAttributesKey OPERATOR =
            key("SEMANTIC_OPERATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey IDENTIFIER =
            key("SEMANTIC_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey BRACES =
            key("SEMANTIC_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey BRACKETS =
            key("SEMANTIC_BRACKETS", DefaultLanguageHighlighterColors.BRACKETS);
    public static final TextAttributesKey PARENTHESES =
            key("SEMANTIC_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES);
    public static final TextAttributesKey DELIMITER =
            key("SEMANTIC_DELIMITER", DefaultLanguageHighlighterColors.COMMA);
    public static final TextAttributesKey BAD_CHARACTER =
            key("SEMANTIC_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static TextAttributesKey key(String name, TextAttributesKey fallback) {
        return TextAttributesKey.createTextAttributesKey(name, fallback);
    }

    private SemanticColors() {}
}
