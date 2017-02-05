package edu.illinois.cs.cogcomp.ideaplugin;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;

public class LBJavaLanguage extends Language {
    @NonNls
    public static final String ID = "LBJava";

    public static final LBJavaLanguage INSTANCE = new LBJavaLanguage();

    protected LBJavaLanguage() {
        super(ID);
    }
}
