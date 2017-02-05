package edu.illinois.cs.cogcomp.ideaplugin;

import com.intellij.psi.tree.IElementType;

public interface LBJavaElementTypes {
    IElementType JAVADOC_COMMENT = new LBJavaElementType("JAVADOC_COMMENT");
    IElementType JAVADOC_END_COMMENT = new LBJavaElementType("JAVADOC_END_COMMENT");

    IElementType LITERAL = new LBJavaElementType("LITERAL");
    IElementType ALPHA = new LBJavaElementType("ALPHA");
    IElementType ATLEAST = new LBJavaElementType("ATLEAST");
    IElementType ATMOST = new LBJavaElementType("ATMOST");
    IElementType BYTE = new LBJavaElementType("BYTE");
    IElementType CACHED = new LBJavaElementType("CACHED");
    IElementType CACHEDIN = new LBJavaElementType("CACHEDIN");
    IElementType CACHEDINMAP = new LBJavaElementType("CACHEDINMAP");
    IElementType CONSTRAINT = new LBJavaElementType("CONSTRAINT");
    IElementType CVAL = new LBJavaElementType("CVAL");
    IElementType DISCRETE = new LBJavaElementType("DISCRETE");
    IElementType ENCODING = new LBJavaElementType("ENCODING");
    IElementType END = new LBJavaElementType("END");
    IElementType EVALUATE = new LBJavaElementType("EVALUATE");
    IElementType EXISTS = new LBJavaElementType("EXISTS");
    IElementType FORALL = new LBJavaElementType("FORALL");
    IElementType FROM = new LBJavaElementType("FROM");
    IElementType HEAD = new LBJavaElementType("HEAD");
    IElementType IN = new LBJavaElementType("IN");
    IElementType INFERENCE = new LBJavaElementType("INFERENCE");
    IElementType LEARN = new LBJavaElementType("LEARN");
    IElementType MAXIMIZE = new LBJavaElementType("MAXIMIZE");
    IElementType MINIMIZE = new LBJavaElementType("MINIMIZE");
    IElementType MIXED = new LBJavaElementType("MIXED");
    IElementType NORMALIZEDBY = new LBJavaElementType("NORMALIZEDBY");
    IElementType OF = new LBJavaElementType("OF");
    IElementType PREEXTRACT = new LBJavaElementType("PREEXTRACT");
    IElementType PROGRESSOUTPUT = new LBJavaElementType("PROGRESSOUTPUT");
    IElementType PRUNE = new LBJavaElementType("PRUNE");
    IElementType REAL = new LBJavaElementType("REAL");
    IElementType ROUNDS = new LBJavaElementType("ROUNDS");
    IElementType SENSE = new LBJavaElementType("SENSE");
    IElementType SENSEALL = new LBJavaElementType("SENSEALL");
    IElementType SUBJECTTO = new LBJavaElementType("SUBJECTTO");
    IElementType TESTFROM = new LBJavaElementType("TESTFROM");
    IElementType TESTINGMETRIC = new LBJavaElementType("TESTINGMETRIC");
    IElementType USING = new LBJavaElementType("USING");

    IElementType LBRACEBRACE = new LBJavaElementType("LBRACEBRACE");
    IElementType RBRACEBRACE = new LBJavaElementType("RBRACEBRACE");
    IElementType DOTDOT = new LBJavaElementType("DOTDOT");
    IElementType LTEQ = new LBJavaElementType("LTEQ");
    IElementType GTEQ = new LBJavaElementType("GTEQ");
    IElementType BANGCOLON = new LBJavaElementType("BANGCOLON");

    IElementType CONJUNCTION = new LBJavaElementType("CONJUNCTION");
    IElementType DISJUNCTION = new LBJavaElementType("DISJUNCTION");
    IElementType IMPLICATION = new LBJavaElementType("IMPLICATION");
    IElementType ARROW = new LBJavaElementType("ARROW");
    IElementType RARROW = new LBJavaElementType("RARROW");
    IElementType DOUBLEIMPLICATION = new LBJavaElementType("DOUBLEIMPLICATION");
}
