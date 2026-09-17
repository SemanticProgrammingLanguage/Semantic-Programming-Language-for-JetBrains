package com.semanticprogramminglanguage.jetbrains;

import com.intellij.lexer.LexerBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Set;

public final class SemanticLexer extends LexerBase {
    private static final Set<String> KEYWORDS = Set.of(
            "program", "object", "list", "ranges", "types", "type",
            "scopes", "scope", "nodes", "node", "relations"
    );

    private static final Set<String> CONSTANTS = Set.of(
            "true", "false", "null", "unknown"
    );

    private CharSequence buffer = "";
    private int bufferEnd;
    private int tokenStart;
    private int tokenEnd;
    private IElementType tokenType;

    @Override
    public void start(@NotNull CharSequence buffer, int startOffset, int endOffset, int initialState) {
        this.buffer = buffer;
        this.bufferEnd = endOffset;
        this.tokenStart = startOffset;
        locateToken();
    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public @Nullable IElementType getTokenType() {
        return tokenType;
    }

    @Override
    public int getTokenStart() {
        return tokenStart;
    }

    @Override
    public int getTokenEnd() {
        return tokenEnd;
    }

    @Override
    public void advance() {
        tokenStart = tokenEnd;
        locateToken();
    }

    @Override
    public @NotNull CharSequence getBufferSequence() {
        return buffer;
    }

    @Override
    public int getBufferEnd() {
        return bufferEnd;
    }

    private void locateToken() {
        if (tokenStart >= bufferEnd) {
            tokenType = null;
            tokenEnd = bufferEnd;
            return;
        }

        char c = buffer.charAt(tokenStart);

        if (Character.isWhitespace(c)) {
            int i = tokenStart + 1;
            while (i < bufferEnd && Character.isWhitespace(buffer.charAt(i))) {
                i++;
            }
            tokenType = TokenType.WHITE_SPACE;
            tokenEnd = i;
            return;
        }

        if (c == '#') {
            int i = tokenStart + 1;
            while (i < bufferEnd
                    && buffer.charAt(i) != '\n'
                    && buffer.charAt(i) != '\r') {
                i++;
            }
            tokenType = SemanticTokenTypes.COMMENT;
            tokenEnd = i;
            return;
        }

        if (c == '"') {
            int i = tokenStart + 1;
            boolean escaped = false;

            while (i < bufferEnd) {
                char ch = buffer.charAt(i);

                if (ch == '\n' || ch == '\r') {
                    break;
                }

                if (escaped) {
                    escaped = false;
                } else if (ch == '\\') {
                    escaped = true;
                } else if (ch == '"') {
                    i++;
                    break;
                }

                i++;
            }

            tokenType = SemanticTokenTypes.STRING;
            tokenEnd = Math.max(i, tokenStart + 1);
            return;
        }

        if ((c == '%' || c == '@')
                && tokenStart + 1 < bufferEnd
                && Character.isDigit(buffer.charAt(tokenStart + 1))) {

            int i = tokenStart + 2;
            while (i < bufferEnd && Character.isDigit(buffer.charAt(i))) {
                i++;
            }

            tokenType = c == '%'
                    ? SemanticTokenTypes.REFERENCE_PERCENT
                    : SemanticTokenTypes.REFERENCE_AT;
            tokenEnd = i;
            return;
        }

        if (Character.isDigit(c)) {
            int i = tokenStart + 1;

            while (i < bufferEnd) {
                char ch = buffer.charAt(i);

                if (Character.isLetterOrDigit(ch)
                        || ch == '.'
                        || ch == '+'
                        || ch == '-') {
                    i++;
                } else {
                    break;
                }
            }

            tokenType = SemanticTokenTypes.NUMBER;
            tokenEnd = i;
            return;
        }

        if (Character.isLetter(c) || c == '_') {
            int i = tokenStart + 1;

            while (i < bufferEnd) {
                char ch = buffer.charAt(i);

                if (Character.isLetterOrDigit(ch)
                        || ch == '_'
                        || ch == '.'
                        || ch == '-') {
                    i++;
                } else {
                    break;
                }
            }

            String word = buffer.subSequence(tokenStart, i).toString();

            tokenType = KEYWORDS.contains(word)
                    ? SemanticTokenTypes.KEYWORD
                    : CONSTANTS.contains(word)
                    ? SemanticTokenTypes.CONSTANT
                    : SemanticTokenTypes.IDENTIFIER;

            tokenEnd = i;
            return;
        }

        if (c == '-'
                && tokenStart + 1 < bufferEnd
                && buffer.charAt(tokenStart + 1) == '>') {

            tokenType = SemanticTokenTypes.OPERATOR;
            tokenEnd = tokenStart + 2;
            return;
        }

        if (c == '=') {
            tokenType = SemanticTokenTypes.OPERATOR;
            tokenEnd = tokenStart + 1;
            return;
        }

        tokenType = switch (c) {
            case '{' -> SemanticTokenTypes.LBRACE;
            case '}' -> SemanticTokenTypes.RBRACE;
            case '[' -> SemanticTokenTypes.LBRACKET;
            case ']' -> SemanticTokenTypes.RBRACKET;
            case '(' -> SemanticTokenTypes.LPAREN;
            case ')' -> SemanticTokenTypes.RPAREN;
            case ':', ',', ';' -> SemanticTokenTypes.DELIMITER;
            default -> SemanticTokenTypes.IDENTIFIER;
        };

        tokenEnd = tokenStart + 1;
    }
}
