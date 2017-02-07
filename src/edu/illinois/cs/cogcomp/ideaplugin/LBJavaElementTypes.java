package edu.illinois.cs.cogcomp.ideaplugin;

import com.intellij.psi.JavaTokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;

public interface LBJavaElementTypes {
    IElementType JAVADOC_COMMENT = new LBJavaElementType("JAVADOC_COMMENT");
    IElementType JAVADOC_END_COMMENT = new LBJavaElementType("JAVADOC_END_COMMENT");

    IElementType LITERAL = new LBJavaElementType("LITERAL");
    IElementType ALPHA = new LBJavaElementType("ALPHA");
    IElementType ATLEAST = new LBJavaElementType("ATLEAST");
    IElementType ATMOST = new LBJavaElementType("ATMOST");
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

    TokenSet LBJAVA_KEYWORDS = TokenSet.create(
            ALPHA,
            ATLEAST,
            ATMOST,
            CACHED,
            CACHEDIN,
            CACHEDINMAP,
            CONSTRAINT,
            CVAL,
            DISCRETE,
            ENCODING,
            END,
            EVALUATE,
            EXISTS,
            FORALL,
            FROM,
            HEAD,
            IN,
            INFERENCE,
            LEARN,
            MAXIMIZE,
            MINIMIZE,
            MIXED,
            NORMALIZEDBY,
            OF,
            PREEXTRACT,
            PROGRESSOUTPUT,
            PRUNE,
            REAL,
            ROUNDS,
            SENSE,
            SENSEALL,
            SUBJECTTO,
            TESTFROM,
            TESTINGMETRIC,
            USING,
            LTEQ,
            GTEQ
    );

    TokenSet LBJAVA_OPERATORS = TokenSet.create(
            CONJUNCTION,
            DISJUNCTION,
            IMPLICATION,
            ARROW,
            RARROW,
            DOUBLEIMPLICATION
    );

    TokenSet JAVA_KEYWORDS = TokenSet.create(
            JavaTokenType.ABSTRACT_KEYWORD,
            JavaTokenType.ASSERT_KEYWORD,
            JavaTokenType.BOOLEAN_KEYWORD,
            JavaTokenType.BREAK_KEYWORD,
            JavaTokenType.CASE_KEYWORD,
            JavaTokenType.CATCH_KEYWORD,
            JavaTokenType.CHAR_KEYWORD,
            JavaTokenType.CLASS_KEYWORD,
            JavaTokenType.CONST_KEYWORD,
            JavaTokenType.CONTINUE_KEYWORD,
            JavaTokenType.DEFAULT_KEYWORD,
            JavaTokenType.DO_KEYWORD,
            JavaTokenType.ELSE_KEYWORD,
            JavaTokenType.EXTENDS_KEYWORD,
            JavaTokenType.FALSE_KEYWORD,
            JavaTokenType.FINAL_KEYWORD,
            JavaTokenType.FINALLY_KEYWORD,
            JavaTokenType.FOR_KEYWORD,
            JavaTokenType.GOTO_KEYWORD,
            JavaTokenType.IF_KEYWORD,
            JavaTokenType.IMPLEMENTS_KEYWORD,
            JavaTokenType.IMPORT_KEYWORD,
            JavaTokenType.INSTANCEOF_KEYWORD,
            JavaTokenType.INTERFACE_KEYWORD,
            JavaTokenType.NATIVE_KEYWORD,
            JavaTokenType.NEW_KEYWORD,
            JavaTokenType.NULL_KEYWORD,
            JavaTokenType.PACKAGE_KEYWORD,
            JavaTokenType.PRIVATE_KEYWORD,
            JavaTokenType.PROTECTED_KEYWORD,
            JavaTokenType.PUBLIC_KEYWORD,
            JavaTokenType.RETURN_KEYWORD,
            JavaTokenType.STATIC_KEYWORD,
            JavaTokenType.STRICTFP_KEYWORD,
            JavaTokenType.SUPER_KEYWORD,
            JavaTokenType.SWITCH_KEYWORD,
            JavaTokenType.SYNCHRONIZED_KEYWORD,
            JavaTokenType.THIS_KEYWORD,
            JavaTokenType.THROW_KEYWORD,
            JavaTokenType.THROWS_KEYWORD,
            JavaTokenType.TRANSIENT_KEYWORD,
            JavaTokenType.TRUE_KEYWORD,
            JavaTokenType.TRY_KEYWORD,
            JavaTokenType.VOID_KEYWORD,
            JavaTokenType.VOLATILE_KEYWORD,
            JavaTokenType.WHILE_KEYWORD,
            JavaTokenType.WITH_KEYWORD
    );

    TokenSet JAVA_NUMBER = TokenSet.create(
            JavaTokenType.DOUBLE_KEYWORD,
            JavaTokenType.FLOAT_KEYWORD,
            JavaTokenType.INT_KEYWORD,
            JavaTokenType.LONG_KEYWORD,
            JavaTokenType.SHORT_KEYWORD,
            JavaTokenType.BYTE_KEYWORD
    );

    TokenSet JAVA_BRACES = TokenSet.create(
            JavaTokenType.LBRACE,
            JavaTokenType.RBRACE
    );

    TokenSet JAVA_BRACKETS = TokenSet.create(
            JavaTokenType.LBRACKET,
            JavaTokenType.RBRACKET
    );

    TokenSet JAVA_PARENTHESIS = TokenSet.create(
            JavaTokenType.LPARENTH,
            JavaTokenType.RPARENTH
    );

    TokenSet JAVA_OPERATOR = TokenSet.create(
            JavaTokenType.PLUS,
            JavaTokenType.MINUS,
            JavaTokenType.ASTERISK,
            JavaTokenType.DIV,
            JavaTokenType.PERC,
            JavaTokenType.OR,
            JavaTokenType.AND,
            JavaTokenType.XOR,
            JavaTokenType.LT,
            JavaTokenType.GT,
            JavaTokenType.QUEST,
            JavaTokenType.EQ,
            JavaTokenType.TILDE,
            JavaTokenType.EXCL,
            JavaTokenType.AT,
            JavaTokenType.OREQ,
            JavaTokenType.ANDEQ,
            JavaTokenType.PLUSEQ,
            JavaTokenType.MINUSEQ,
            JavaTokenType.ASTERISKEQ,
            JavaTokenType.DIVEQ,
            JavaTokenType.PERCEQ,
            JavaTokenType.XOREQ,
            JavaTokenType.PLUSPLUS,
            JavaTokenType.MINUSMINUS,
            JavaTokenType.LTLT,
            JavaTokenType.GTGT,
            JavaTokenType.EQEQ,
            JavaTokenType.PERCEQ,
            JavaTokenType.ANDAND,
            JavaTokenType.OROR,
            JavaTokenType.LTLTEQ,
            JavaTokenType.GTGTEQ,
            JavaTokenType.GTGTGT,
            JavaTokenType.GTGTGTEQ
    );

    TokenSet JAVA_COLON = TokenSet.create(
            JavaTokenType.COLON,
            JavaTokenType.SEMICOLON,
            JavaTokenType.DOUBLE_COLON
    );

    // Other JavaTokenType used:
    // JavaTokenType.IDENTIFIER
    // JavaTokenType.DOT
    // JavaTokenType.COMMA
}
