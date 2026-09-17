package com.semanticprogramminglanguage.jetbrains;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.Icon;

public final class SemanticFileType extends LanguageFileType {
    public static final SemanticFileType INSTANCE = new SemanticFileType();

    private SemanticFileType() {
        super(SemanticLanguage.INSTANCE);
    }

    @Override
    public @NotNull String getName() {
        return "Semantic";
    }

    @Override
    public @NotNull String getDescription() {
        return "Semantic Programming Language source file";
    }

    @Override
    public @NotNull String getDefaultExtension() {
        return "se";
    }

    @Override
    public @Nullable Icon getIcon() {
        return SemanticIcons.FILE;
    }
}
