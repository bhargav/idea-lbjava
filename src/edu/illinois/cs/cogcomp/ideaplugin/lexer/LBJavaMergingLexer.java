package edu.illinois.cs.cogcomp.ideaplugin.lexer;


import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.MergingLexerAdapter;
import com.intellij.psi.tree.TokenSet;

public class LBJavaMergingLexer extends MergingLexerAdapter {
    public static final TokenSet tokensToMerge = TokenSet.EMPTY;

    public LBJavaMergingLexer() {
        super(new FlexAdapter(new _LBJavaLexer(null)), tokensToMerge);
    }
}
