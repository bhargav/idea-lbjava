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
    TextAttributesKey ALPHA = createTextAttributesKey("LBJAVA.ALPHA", JavaHighlightingColors.KEYWORD);
    TextAttributesKey ATLEAST = createTextAttributesKey("LBJAVA.ATLEAST", JavaHighlightingColors.KEYWORD);
    TextAttributesKey ATMOST = createTextAttributesKey("LBJAVA.ATMOST", JavaHighlightingColors.KEYWORD);
    TextAttributesKey CACHED = createTextAttributesKey("LBJAVA.CACHED", JavaHighlightingColors.KEYWORD);
    TextAttributesKey CACHEDIN = createTextAttributesKey("LBJAVA.CACHEDIN", JavaHighlightingColors.KEYWORD);
    TextAttributesKey CACHEDINMAP = createTextAttributesKey("LBJAVA.CACHEDINMAP", JavaHighlightingColors.KEYWORD);
    TextAttributesKey CONSTRAINT = createTextAttributesKey("LBJAVA.CONSTRAINT", JavaHighlightingColors.KEYWORD);
    TextAttributesKey CVAL = createTextAttributesKey("LBJAVA.CVAL", JavaHighlightingColors.KEYWORD);
    TextAttributesKey DISCRETE = createTextAttributesKey("LBJAVA.DISCRETE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey ENCODING = createTextAttributesKey("LBJAVA.ENCODING", JavaHighlightingColors.KEYWORD);
    TextAttributesKey END = createTextAttributesKey("LBJAVA.END", JavaHighlightingColors.KEYWORD);
    TextAttributesKey EVALUATE = createTextAttributesKey("LBJAVA.EVALUATE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey EXISTS = createTextAttributesKey("LBJAVA.EXISTS", JavaHighlightingColors.KEYWORD);
    TextAttributesKey FORALL = createTextAttributesKey("LBJAVA.FORALL", JavaHighlightingColors.KEYWORD);
    TextAttributesKey FROM = createTextAttributesKey("LBJAVA.FROM", JavaHighlightingColors.KEYWORD);
    TextAttributesKey HEAD = createTextAttributesKey("LBJAVA.HEAD", JavaHighlightingColors.KEYWORD);
    TextAttributesKey IN = createTextAttributesKey("LBJAVA.IN", JavaHighlightingColors.KEYWORD);
    TextAttributesKey INFERENCE = createTextAttributesKey("LBJAVA.INFERENCE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey LEARN = createTextAttributesKey("LBJAVA.LEARN", JavaHighlightingColors.KEYWORD);
    TextAttributesKey MAXIMIZE = createTextAttributesKey("LBJAVA.MAXIMIZE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey MINIMIZE = createTextAttributesKey("LBJAVA.MINIMIZE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey MIXED = createTextAttributesKey("LBJAVA.MIXED", JavaHighlightingColors.KEYWORD);
    TextAttributesKey NORMALIZEDBY = createTextAttributesKey("LBJAVA.NORMALIZEDBY", JavaHighlightingColors.KEYWORD);
    TextAttributesKey OF = createTextAttributesKey("LBJAVA.OF", JavaHighlightingColors.KEYWORD);
    TextAttributesKey PREEXTRACT = createTextAttributesKey("LBJAVA.PREEXTRACT", JavaHighlightingColors.KEYWORD);
    TextAttributesKey PROGRESSOUTPUT = createTextAttributesKey("LBJAVA.PROGRESSOUTPUT", JavaHighlightingColors.KEYWORD);
    TextAttributesKey PRUNE = createTextAttributesKey("LBJAVA.PRUNE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey REAL = createTextAttributesKey("LBJAVA.REAL", JavaHighlightingColors.KEYWORD);
    TextAttributesKey ROUNDS = createTextAttributesKey("LBJAVA.ROUNDS", JavaHighlightingColors.KEYWORD);
    TextAttributesKey SENSE = createTextAttributesKey("LBJAVA.SENSE", JavaHighlightingColors.KEYWORD);
    TextAttributesKey SENSEALL = createTextAttributesKey("LBJAVA.SENSEALL", JavaHighlightingColors.KEYWORD);
    TextAttributesKey SUBJECTTO = createTextAttributesKey("LBJAVA.SUBJECTTO", JavaHighlightingColors.KEYWORD);
    TextAttributesKey TESTFROM = createTextAttributesKey("LBJAVA.TESTFROM", JavaHighlightingColors.KEYWORD);
    TextAttributesKey TESTINGMETRIC = createTextAttributesKey("LBJAVA.TESTINGMETRIC", JavaHighlightingColors.KEYWORD);
    TextAttributesKey USING = createTextAttributesKey("LBJAVA.USING", JavaHighlightingColors.KEYWORD);

    TextAttributesKey LBRACEBRACE = createTextAttributesKey("LBJAVA.LBRACEBRACE", JavaHighlightingColors.BRACES);
    TextAttributesKey RBRACEBRACE = createTextAttributesKey("LBJAVA.RBRACEBRACE", JavaHighlightingColors.BRACES);
    TextAttributesKey DOTDOT = createTextAttributesKey("LBJAVA.DOTDOT", JavaHighlightingColors.DOT);
    TextAttributesKey LTEQ = createTextAttributesKey("LBJAVA.LTEQ", JavaHighlightingColors.KEYWORD);
    TextAttributesKey GTEQ = createTextAttributesKey("LBJAVA.GTEQ", JavaHighlightingColors.KEYWORD);
    TextAttributesKey BANGCOLON = createTextAttributesKey("LBJAVA.BANGCOLON", JavaHighlightingColors.JAVA_SEMICOLON);

    TextAttributesKey CONJUNCTION = createTextAttributesKey(
            "LBJAVA.CONJUNCTION", JavaHighlightingColors.OPERATION_SIGN
    );
    TextAttributesKey DISJUNCTION = createTextAttributesKey(
            "LBJAVA.DISJUNCTION", JavaHighlightingColors.OPERATION_SIGN
    );
    TextAttributesKey IMPLICATION = createTextAttributesKey(
            "LBJAVA.IMPLICATION", JavaHighlightingColors.OPERATION_SIGN
    );
    TextAttributesKey ARROW = createTextAttributesKey(
            "LBJAVA.ARROW", JavaHighlightingColors.OPERATION_SIGN
    );
    TextAttributesKey RARROW = createTextAttributesKey(
            "LBJAVA.RARROW", JavaHighlightingColors.OPERATION_SIGN
    );
    TextAttributesKey DOUBLEIMPLICATION = createTextAttributesKey(
            "LBJAVA.DOUBLEIMPLICATION", JavaHighlightingColors.OPERATION_SIGN
    );
}
