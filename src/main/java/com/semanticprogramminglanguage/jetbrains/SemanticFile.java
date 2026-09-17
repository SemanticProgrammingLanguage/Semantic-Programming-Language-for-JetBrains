package com.semanticprogramminglanguage.jetbrains;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public final class SemanticFile extends PsiFileBase {
    public SemanticFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SemanticLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return SemanticFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Semantic File";
    }
}
