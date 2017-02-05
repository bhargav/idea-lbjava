package edu.illinois.cs.cogcomp.ideaplugin.fileTypes;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.IconLoader;
import edu.illinois.cs.cogcomp.ideaplugin.LBJavaLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class LBJavaFileType extends LanguageFileType {
    public static final LBJavaFileType INSTANCE = new LBJavaFileType();

    @NonNls
    public static final String DEFAULT_EXTENSION = "lbj";

    public LBJavaFileType() {
        super(LBJavaLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "LBJava";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "LBJava Language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Nullable
    @Override
    public Icon getIcon() {
        // TODO - Add Icon
        return IconLoader.getIcon("/cogcomp.png");
    }
}
