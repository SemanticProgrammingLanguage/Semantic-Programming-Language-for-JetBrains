package com.semanticprogramminglanguage.jetbrains;

import com.intellij.lang.Language;

public final class SemanticLanguage extends Language {
    public static final SemanticLanguage INSTANCE = new SemanticLanguage();

    private SemanticLanguage() {
        super("Semantic");
    }
}
