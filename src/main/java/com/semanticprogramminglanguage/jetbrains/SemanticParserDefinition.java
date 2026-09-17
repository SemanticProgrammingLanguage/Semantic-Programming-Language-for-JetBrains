package com.semanticprogramminglanguage.jetbrains;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

public final class SemanticParserDefinition implements ParserDefinition {
    public static final IFileElementType FILE =
            new IFileElementType(SemanticLanguage.INSTANCE);

    private static final TokenSet WHITE_SPACES =
            TokenSet.create(TokenType.WHITE_SPACE);

    private static final TokenSet COMMENTS =
            TokenSet.create(SemanticTokenTypes.COMMENT);

    private static final TokenSet STRINGS =
            TokenSet.create(SemanticTokenTypes.STRING);

    @Override
    public @NotNull Lexer createLexer(Project project) {
        return new SemanticLexer();
    }

    @Override
    public @NotNull PsiParser createParser(Project project) {
        return new PsiParser() {
            @Override
            public @NotNull ASTNode parse(
                    @NotNull com.intellij.psi.tree.IElementType root,
                    @NotNull PsiBuilder builder
            ) {
                PsiBuilder.Marker marker = builder.mark();

                while (!builder.eof()) {
                    builder.advanceLexer();
                }

                marker.done(root);
                return builder.getTreeBuilt();
            }
        };
    }

    @Override
    public @NotNull IFileElementType getFileNodeType() {
        return FILE;
    }

    @Override
    public @NotNull TokenSet getWhitespaceTokens() {
        return WHITE_SPACES;
    }

    @Override
    public @NotNull TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @Override
    public @NotNull TokenSet getStringLiteralElements() {
        return STRINGS;
    }

    @Override
    public @NotNull PsiElement createElement(ASTNode node) {
        return new ASTWrapperPsiElement(node);
    }

    @Override
    public @NotNull PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new SemanticFile(viewProvider);
    }
}
