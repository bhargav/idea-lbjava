package edu.illinois.cs.cogcomp.ideaplugin.editor;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public interface LBJavaHighlighterColors {
    TextAttributesKey JAVADOC_COMMENT = createTextAttributesKey(
            "LBJAVA.JAVADOC_COMMENT", JavaHighlightingColors.DOC_COMMENT
    );
    TextAttributesKey JAVADOC_END_COMMENT = createTextAttributesKey(
            "LBJAVA.JAVADOC_END_COMMENT", JavaHighlightingColors.DOC_COMMENT
    );

    TextAttributesKey LITERAL = createTextAttributesKey("LBJAVA.LITERAL", JavaHighlightingColors.STRING);
    TextAttributesKey LBRACEBRACE = createTextAttributesKey("LBJAVA.LBRACEBRACE", JavaHighlightingColors.BRACES);
    TextAttributesKey RBRACEBRACE = createTextAttributesKey("LBJAVA.RBRACEBRACE", JavaHighlightingColors.BRACES);
    TextAttributesKey DOTDOT = createTextAttributesKey("LBJAVA.DOTDOT", JavaHighlightingColors.DOT);
    TextAttributesKey BANGCOLON = createTextAttributesKey("LBJAVA.BANGCOLON", JavaHighlightingColors.JAVA_SEMICOLON);
}
