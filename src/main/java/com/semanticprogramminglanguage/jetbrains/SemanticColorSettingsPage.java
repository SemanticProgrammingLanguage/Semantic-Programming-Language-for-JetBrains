package com.semanticprogramminglanguage.jetbrains;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

public final class SemanticColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = {
            new AttributesDescriptor("Header", SemanticColors.HEADER),
            new AttributesDescriptor("Keyword", SemanticColors.KEYWORD),
            new AttributesDescriptor("Constant", SemanticColors.CONSTANT),
            new AttributesDescriptor("String", SemanticColors.STRING),
            new AttributesDescriptor("Number", SemanticColors.NUMBER),
            new AttributesDescriptor("Range", SemanticColors.RANGE),
            new AttributesDescriptor("Comment", SemanticColors.COMMENT),
            new AttributesDescriptor("Value reference (%N)", SemanticColors.VALUE_REFERENCE),
            new AttributesDescriptor("Type reference (@N)", SemanticColors.TYPE_REFERENCE),
            new AttributesDescriptor("Operator", SemanticColors.OPERATOR),
            new AttributesDescriptor("Identifier", SemanticColors.IDENTIFIER),
            new AttributesDescriptor("Braces", SemanticColors.BRACES),
            new AttributesDescriptor("Brackets", SemanticColors.BRACKETS),
            new AttributesDescriptor("Parentheses", SemanticColors.PARENTHESES),
            new AttributesDescriptor("Delimiter", SemanticColors.DELIMITER),
            new AttributesDescriptor("Invalid character", SemanticColors.BAD_CHARACTER)
    };

    @Override
    public @Nullable Icon getIcon() {
        return SemanticIcons.FILE;
    }

    @Override
    public @NotNull SyntaxHighlighter getHighlighter() {
        return new SemanticSyntaxHighlighter();
    }

    @Override
    public @NotNull String getDemoText() {
        return "se 1\n\n"
                + "# Semantic Programming Language highlighting preview\n"
                + "program Demo\n"
                + "object Main\n\n"
                + "ranges {\n"
                + "    1-10\n"
                + "    20 - 42\n"
                + "}\n\n"
                + "scope example {\n"
                + "    node item\n"
                + "    relations\n"
                + "    true false null unknown\n"
                + "    %12 @42\n"
                + "    \\\"Semantic string\\\"\n"
                + "    123 3.14159 6.02e23 0xFF\n"
                + "    list [1, 2, 3]\n"
                + "    object -> @42\n"
                + "}\n";
    }

    @Override
    public @Nullable Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @Override
    public AttributesDescriptor @NotNull [] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @Override
    public ColorDescriptor @NotNull [] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @Override
    public @NotNull String getDisplayName() {
        return "Semantic";
    }
}
