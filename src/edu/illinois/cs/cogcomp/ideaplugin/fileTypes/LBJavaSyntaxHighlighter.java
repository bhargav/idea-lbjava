package edu.illinois.cs.cogcomp.ideaplugin.fileTypes;


import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.JavaTokenType;
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
        colors.put(LBJavaElementTypes.LBRACEBRACE, LBJavaHighlighterColors.LBRACEBRACE);
        colors.put(LBJavaElementTypes.RBRACEBRACE, LBJavaHighlighterColors.RBRACEBRACE);
        colors.put(LBJavaElementTypes.DOTDOT, LBJavaHighlighterColors.DOTDOT);
        colors.put(LBJavaElementTypes.BANGCOLON, LBJavaHighlighterColors.BANGCOLON);

        fillMap(colors, LBJavaElementTypes.LBJAVA_KEYWORDS, JavaHighlightingColors.KEYWORD);
        fillMap(colors, LBJavaElementTypes.LBJAVA_OPERATORS, JavaHighlightingColors.OPERATION_SIGN);

        // colors for Java Language Tokens
        colors.put(JavaTokenType.IDENTIFIER, DefaultLanguageHighlighterColors.IDENTIFIER);

        colors.put(JavaTokenType.DOT, JavaHighlightingColors.DOT);
        colors.put(JavaTokenType.COMMA, JavaHighlightingColors.COMMA);

        fillMap(colors, LBJavaElementTypes.JAVA_KEYWORDS, JavaHighlightingColors.KEYWORD);
        fillMap(colors, LBJavaElementTypes.JAVA_NUMBER, JavaHighlightingColors.NUMBER);
        fillMap(colors, LBJavaElementTypes.JAVA_BRACES, JavaHighlightingColors.BRACES);
        fillMap(colors, LBJavaElementTypes.JAVA_BRACKETS, JavaHighlightingColors.BRACKETS);
        fillMap(colors, LBJavaElementTypes.JAVA_PARENTHESIS, JavaHighlightingColors.PARENTHESES);
        fillMap(colors, LBJavaElementTypes.JAVA_OPERATOR, JavaHighlightingColors.OPERATION_SIGN);
        fillMap(colors, LBJavaElementTypes.JAVA_COLON, JavaHighlightingColors.JAVA_SEMICOLON);
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
