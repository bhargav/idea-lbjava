package edu.illinois.cs.cogcomp.ideaplugin.fileTypes;


import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import edu.illinois.cs.cogcomp.ideaplugin.LBJavaElementType;
import edu.illinois.cs.cogcomp.ideaplugin.LBJavaElementTypes;
import edu.illinois.cs.cogcomp.ideaplugin.editor.LBJavaHighlighterColors;
import edu.illinois.cs.cogcomp.ideaplugin.lexer.LBJavaHighlighterLexer;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class LBJavaSyntaxHighlighter extends SyntaxHighlighterBase {

    private final LBJavaHighlighterLexer lexer;
    private final Map<IElementType, TextAttributesKey> colors = new HashMap<>();
    private final Map<IElementType, TextAttributesKey> backgrounds = new HashMap<>();

    public LBJavaSyntaxHighlighter() {
        lexer = new LBJavaHighlighterLexer();

        colors.put(LBJavaElementTypes.JAVADOC_COMMENT, LBJavaHighlighterColors.JAVADOC_COMMENT);
        colors.put(LBJavaElementTypes.JAVADOC_END_COMMENT, LBJavaHighlighterColors.JAVADOC_END_COMMENT);

        colors.put(LBJavaElementTypes.LITERAL, LBJavaHighlighterColors.LITERAL);
        colors.put(LBJavaElementTypes.ALPHA, LBJavaHighlighterColors.ALPHA);
        colors.put(LBJavaElementTypes.ATLEAST, LBJavaHighlighterColors.ATLEAST);
        colors.put(LBJavaElementTypes.ATMOST, LBJavaHighlighterColors.ATMOST);
        colors.put(LBJavaElementTypes.CACHED, LBJavaHighlighterColors.CACHED);
        colors.put(LBJavaElementTypes.CACHEDIN, LBJavaHighlighterColors.CACHEDIN);
        colors.put(LBJavaElementTypes.CACHEDINMAP, LBJavaHighlighterColors.CACHEDINMAP);
        colors.put(LBJavaElementTypes.CONSTRAINT, LBJavaHighlighterColors.CONSTRAINT);
        colors.put(LBJavaElementTypes.CVAL, LBJavaHighlighterColors.CVAL);
        colors.put(LBJavaElementTypes.DISCRETE, LBJavaHighlighterColors.DISCRETE);
        colors.put(LBJavaElementTypes.ENCODING, LBJavaHighlighterColors.ENCODING);
        colors.put(LBJavaElementTypes.END, LBJavaHighlighterColors.END);
        colors.put(LBJavaElementTypes.EVALUATE, LBJavaHighlighterColors.EVALUATE);
        colors.put(LBJavaElementTypes.EXISTS, LBJavaHighlighterColors.EXISTS);
        colors.put(LBJavaElementTypes.FORALL, LBJavaHighlighterColors.FORALL);
        colors.put(LBJavaElementTypes.FROM, LBJavaHighlighterColors.FROM);
        colors.put(LBJavaElementTypes.HEAD, LBJavaHighlighterColors.HEAD);
        colors.put(LBJavaElementTypes.IN, LBJavaHighlighterColors.IN);
        colors.put(LBJavaElementTypes.INFERENCE, LBJavaHighlighterColors.INFERENCE);
        colors.put(LBJavaElementTypes.LEARN, LBJavaHighlighterColors.LEARN);
        colors.put(LBJavaElementTypes.MAXIMIZE, LBJavaHighlighterColors.MAXIMIZE);
        colors.put(LBJavaElementTypes.MINIMIZE, LBJavaHighlighterColors.MINIMIZE);
        colors.put(LBJavaElementTypes.MIXED, LBJavaHighlighterColors.MIXED);
        colors.put(LBJavaElementTypes.NORMALIZEDBY, LBJavaHighlighterColors.NORMALIZEDBY);
        colors.put(LBJavaElementTypes.OF, LBJavaHighlighterColors.OF);
        colors.put(LBJavaElementTypes.PREEXTRACT, LBJavaHighlighterColors.PREEXTRACT);
        colors.put(LBJavaElementTypes.PROGRESSOUTPUT, LBJavaHighlighterColors.PROGRESSOUTPUT);
        colors.put(LBJavaElementTypes.PRUNE, LBJavaHighlighterColors.PRUNE);
        colors.put(LBJavaElementTypes.REAL, LBJavaHighlighterColors.REAL);
        colors.put(LBJavaElementTypes.ROUNDS, LBJavaHighlighterColors.ROUNDS);
        colors.put(LBJavaElementTypes.SENSE, LBJavaHighlighterColors.SENSE);
        colors.put(LBJavaElementTypes.SENSEALL, LBJavaHighlighterColors.SENSEALL);
        colors.put(LBJavaElementTypes.SUBJECTTO, LBJavaHighlighterColors.SUBJECTTO);
        colors.put(LBJavaElementTypes.TESTFROM, LBJavaHighlighterColors.TESTFROM);
        colors.put(LBJavaElementTypes.TESTINGMETRIC, LBJavaHighlighterColors.TESTINGMETRIC);
        colors.put(LBJavaElementTypes.USING, LBJavaHighlighterColors.USING);

        colors.put(LBJavaElementTypes.LBRACEBRACE, LBJavaHighlighterColors.LBRACEBRACE);
        colors.put(LBJavaElementTypes.RBRACEBRACE, LBJavaHighlighterColors.RBRACEBRACE);
        colors.put(LBJavaElementTypes.DOTDOT, LBJavaHighlighterColors.DOTDOT);
        colors.put(LBJavaElementTypes.LTEQ, LBJavaHighlighterColors.LTEQ);
        colors.put(LBJavaElementTypes.GTEQ, LBJavaHighlighterColors.GTEQ);
        colors.put(LBJavaElementTypes.BANGCOLON, LBJavaHighlighterColors.BANGCOLON);

        colors.put(LBJavaElementTypes.CONJUNCTION, LBJavaHighlighterColors.CONJUNCTION);
        colors.put(LBJavaElementTypes.DISJUNCTION, LBJavaHighlighterColors.DISJUNCTION);
        colors.put(LBJavaElementTypes.IMPLICATION, LBJavaHighlighterColors.IMPLICATION);
        colors.put(LBJavaElementTypes.ARROW, LBJavaHighlighterColors.ARROW);
        colors.put(LBJavaElementTypes.RARROW, LBJavaHighlighterColors.RARROW);
        colors.put(LBJavaElementTypes.DOUBLEIMPLICATION, LBJavaHighlighterColors.DOUBLEIMPLICATION);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return lexer;
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(getAttributeKeys(tokenType, backgrounds), getAttributeKeys(tokenType, colors));
    }

    private TextAttributesKey getAttributeKeys(IElementType tokenType, Map<IElementType, TextAttributesKey> map) {
        TextAttributesKey attributes = map.get(tokenType);
        if (attributes == null && tokenType instanceof LBJavaElementType) {
            return map.get(((LBJavaElementType) tokenType).getParsedType());
        }
        return map.get(tokenType);
    }
}
