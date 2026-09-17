package com.semanticprogramminglanguage.jetbrains;

import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

public final class SemanticSyntaxHighlighter extends SyntaxHighlighterBase {
    private static final TextAttributesKey KEYWORD =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_KEYWORD_SAFE", DefaultLanguageHighlighterColors.KEYWORD);
    private static final TextAttributesKey CONSTANT =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_CONSTANT_SAFE", DefaultLanguageHighlighterColors.CONSTANT);
    private static final TextAttributesKey STRING =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_STRING_SAFE", DefaultLanguageHighlighterColors.STRING);
    private static final TextAttributesKey NUMBER =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_NUMBER_SAFE", DefaultLanguageHighlighterColors.NUMBER);
    private static final TextAttributesKey COMMENT =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_COMMENT_SAFE", DefaultLanguageHighlighterColors.LINE_COMMENT);
    private static final TextAttributesKey REFERENCE =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_REFERENCE_SAFE", DefaultLanguageHighlighterColors.INSTANCE_FIELD);
    private static final TextAttributesKey TYPE_REFERENCE =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_TYPE_REFERENCE_SAFE", DefaultLanguageHighlighterColors.CLASS_REFERENCE);
    private static final TextAttributesKey OPERATOR =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_OPERATOR_SAFE", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    private static final TextAttributesKey BRACES =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_BRACES_SAFE", DefaultLanguageHighlighterColors.BRACES);
    private static final TextAttributesKey BRACKETS =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_BRACKETS_SAFE", DefaultLanguageHighlighterColors.BRACKETS);
    private static final TextAttributesKey PARENTHESES =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_PARENS_SAFE", DefaultLanguageHighlighterColors.PARENTHESES);
    private static final TextAttributesKey DELIMITER =
            TextAttributesKey.createTextAttributesKey("SEMANTIC_DELIMITER_SAFE", DefaultLanguageHighlighterColors.COMMA);

    private static final TextAttributesKey[] EMPTY = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new SemanticLexer();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType type) {
        if (type == SemanticTokenTypes.KEYWORD || type == SemanticTokenTypes.HEADER) return pack(KEYWORD);
        if (type == SemanticTokenTypes.CONSTANT) return pack(CONSTANT);
        if (type == SemanticTokenTypes.STRING) return pack(STRING);
        if (type == SemanticTokenTypes.NUMBER || type == SemanticTokenTypes.RANGE) return pack(NUMBER);
        if (type == SemanticTokenTypes.COMMENT) return pack(COMMENT);
        if (type == SemanticTokenTypes.REFERENCE_PERCENT) return pack(REFERENCE);
        if (type == SemanticTokenTypes.REFERENCE_AT) return pack(TYPE_REFERENCE);
        if (type == SemanticTokenTypes.OPERATOR) return pack(OPERATOR);
        if (type == SemanticTokenTypes.LBRACE || type == SemanticTokenTypes.RBRACE) return pack(BRACES);
        if (type == SemanticTokenTypes.LBRACKET || type == SemanticTokenTypes.RBRACKET) return pack(BRACKETS);
        if (type == SemanticTokenTypes.LPAREN || type == SemanticTokenTypes.RPAREN) return pack(PARENTHESES);
        if (type == SemanticTokenTypes.DELIMITER) return pack(DELIMITER);
        return EMPTY;
    }
}
