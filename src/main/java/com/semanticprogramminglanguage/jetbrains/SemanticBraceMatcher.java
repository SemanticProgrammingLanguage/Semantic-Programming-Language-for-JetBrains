package com.semanticprogramminglanguage.jetbrains;

import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class SemanticBraceMatcher implements PairedBraceMatcher {
    private static final BracePair[] PAIRS = new BracePair[] {
            new BracePair(SemanticTokenTypes.LBRACE, SemanticTokenTypes.RBRACE, true),
            new BracePair(SemanticTokenTypes.LBRACKET, SemanticTokenTypes.RBRACKET, false),
            new BracePair(SemanticTokenTypes.LPAREN, SemanticTokenTypes.RPAREN, false)
    };

    @Override
    public BracePair @NotNull [] getPairs() {
        return PAIRS;
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(
            @NotNull com.intellij.psi.tree.IElementType lbraceType,
            @Nullable com.intellij.psi.tree.IElementType contextType
    ) {
        return true;
    }

    @Override
    public int getCodeConstructStart(@NotNull PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
