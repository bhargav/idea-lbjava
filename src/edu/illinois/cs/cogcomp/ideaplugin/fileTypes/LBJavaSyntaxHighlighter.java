package edu.illinois.cs.cogcomp.ideaplugin.fileTypes;


import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import edu.illinois.cs.cogcomp.ideaplugin.LBJavaElementType;
import edu.illinois.cs.cogcomp.ideaplugin.LBJavaElementTypes;
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
        colors.put(LBJavaElementTypes.LEARN, JavaHighlightingColors.OPERATION_SIGN);
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
