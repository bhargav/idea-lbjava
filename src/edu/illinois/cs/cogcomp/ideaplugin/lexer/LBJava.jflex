/**
 * This software is released under the University of Illinois/Research and Academic Use License. See
 * the LICENSE file in the root folder for details. Copyright (c) 2016
 *
 * Developed by: The Cognitive Computations Group, University of Illinois at Urbana-Champaign
 * http://cogcomp.cs.illinois.edu/
 */
/// --- scanner.jflex ----------------------------------------- vim:syntax=lex
/// Author: Nick Rizzolo
/// Description:
///   JLex scanner specification for LBJava.  Currently, the LBJava language
///   supports C and C++ style comments that may be nested, identifiers
///   containing alpha-numeric characters and underscores and beginning with
///   either an alphabetic character or an underscore, and a minimum of
///   operators and keywords.
///
/// Modified by Christos Christodoulopoulos to be used inside Maven
///
/// Modified by Bhargav Mangipudi from JLex to JFlex format
/// --------------------------------------------------------------------------

package edu.illinois.cs.cogcomp.ideaplugin.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.JavaTokenType;
import edu.illinois.cs.cogcomp.ideaplugin.LBJavaElementTypes;

%%

%class _JFlexLexer
%implements FlexLexer
%final
%unicode
%function advance
%type IElementType
%eof{ return;
%eof}


%{
  // Declarations for variables, subroutines, etc. accessible to all
  // scanner actions.
  public String sourceFilename;  
  private int comment_nest = 0;
%}



%line  // Make the "yyline" (line number in file) and "yychar" (byte offset in
%char  // file) variables available to the scanner actions.

%state BLOCK_COMMENT, LINE_COMMENT, JAVADOC_COMMENT

%{
  // Scanner macros.
%}
DIGIT=[0-9]
NON_ZERO_DIGIT=[1-9]
OCTAL_DIGIT=[0-7]
HEX_DIGIT=[0-9A-Fa-f]
UNICODE=[\u0080-\uFFFF]
ALPHA=[A-Za-z_\$]
ALPHA_NUMERIC={ALPHA}|{DIGIT}
WHITE_SPACE_CHAR=[\r\n\ \t\b\012]
CHARACTER_CONSTANT="'"([^\\']|{UNICODE}|\\[btnfr\"'\\]|\\u+{HEX_DIGIT}{HEX_DIGIT}{HEX_DIGIT}{HEX_DIGIT}\\[0-7]|\\[0-7][0-7]|\\[0-3][0-7][0-7])"'"
STRING_CONSTANT="\""([^\\\"]|{UNICODE}|\\[btnfr\"'\\]|\\u+{HEX_DIGIT}{HEX_DIGIT}{HEX_DIGIT}{HEX_DIGIT}\\[0-7]|\\[0-7][0-7]|\\[0-3][0-7][0-7])*"\""


%{
  // The text inside a block comment can include any characters including "/"
  // and "*", as long as they don't fall in either of these orders: "/*" or
  // "*/".  Notice that the COMMENT_TEXT regular expression will not match any
  // amount of consecutive "*" characters if they are immediately followed by
  // a "/".
%}

COMMENT_TEXT=([^/*]|("*")+[^/*]|"/"[^*])*

%%

<YYINITIAL> ({WHITE_SPACE_CHAR})+ { return TokenType.WHITE_SPACE; }

<YYINITIAL> "//" { yybegin(LINE_COMMENT); }
<LINE_COMMENT> ([^\n])+ { }
<LINE_COMMENT> [\n] { yybegin(YYINITIAL); }

<YYINITIAL> "/**" { yybegin(JAVADOC_COMMENT); }
<JAVADOC_COMMENT> {COMMENT_TEXT}
{
  return LBJavaElementTypes.JAVADOC_COMMENT;
}
<JAVADOC_COMMENT> ("*")+"/"
{
  yybegin(YYINITIAL);
  return LBJavaElementTypes.JAVADOC_END_COMMENT;
}

<YYINITIAL> "/*" { yybegin(BLOCK_COMMENT); comment_nest++; }
<BLOCK_COMMENT> "/*" { comment_nest++; }
"*/"
{ 
  // It should be ok to match "*/" in any state.  Of course, we wanted to
  // match it in the BLOCK_COMMENT state anyway.  It's also ok in YYINITIAL,
  // since "*/" is not an operator or delimiter and it can't be part of a
  // reserved word or identifier.  Also, it's never syntactically correct for
  // the "*" operator to be immediately followed by the "/" operator.
  // Finally, this rule will never be matched in the LINE_COMMENT state, since
  // the first LINE_COMMENT rule above matches as much as possible and it
  // appears before this rule.

  comment_nest--;
  if (comment_nest == 0) yybegin(YYINITIAL);
  else if (comment_nest < 0)
  {
    // If this ever happens, it will be because comment_nest == -1.  If more
    // code follows, and in particular another block comment, the comment_nest
    // variable should not be starting from -1 when it begins to keep track of
    // the new nested comments.  Hence, the next line of code below.
    comment_nest++;
    // ScannerError.commentEndWithoutBegin();
    return TokenType.ERROR_ELEMENT;
  }
}

<BLOCK_COMMENT> ("*")+"/"
{
  // It might have been a little cleaner to include zero width look ahead
  // assertions in the COMMENT_TEXT regular expressions so that this rule
  // wasn't necessary, but jlex does not support them.  So, this rule takes
  // care of comments ended with more than one "*" and then a "/" in the
  // BLOCK_COMMENT state.  In the YYINITIAL state, we will let the extra "*"
  // characters be treated as operators, but "*/" will still be treated as an
  // end of comment delimiter.
  comment_nest--;
  if (comment_nest == 0) yybegin(YYINITIAL);
}

<BLOCK_COMMENT> {COMMENT_TEXT} { }




<YYINITIAL> ({DIGIT})+\.({DIGIT})*([Ee][+-]?({DIGIT})+)?[DdFf]?
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> \.({DIGIT})+([Ee][+-]?({DIGIT})+)?[DdFf]?
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> ({DIGIT})+([Ee][+-]?({DIGIT})+)[DdFf]?
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> ({DIGIT})+[DdFf]
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> ({NON_ZERO_DIGIT})({DIGIT})*[Ll]?
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> "0"({OCTAL_DIGIT})+[Ll]?
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> "0"[Xx]({HEX_DIGIT})+[Ll]?
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> "0"|"0l"|"0L"
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> {STRING_CONSTANT}
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> {CHARACTER_CONSTANT}
{
  return LBJavaElementTypes.LITERAL;
}

<YYINITIAL> "abstract"
{
  return JavaTokenType.ABSTRACT_KEYWORD;
}

<YYINITIAL> "alpha"
{
  return LBJavaElementTypes.ALPHA;
}

<YYINITIAL> "assert"
{
  return JavaTokenType.ASSERT_KEYWORD;
}

<YYINITIAL> "atleast"
{
  return LBJavaElementTypes.ATLEAST;
}

<YYINITIAL> "atmost"
{
  return LBJavaElementTypes.ATMOST;
}

<YYINITIAL> "boolean"
{
  return JavaTokenType.BOOLEAN_KEYWORD;
}

<YYINITIAL> "break"
{
  return JavaTokenType.BREAK_KEYWORD;
}

<YYINITIAL> "byte"
{
  return JavaTokenType.BYTE_KEYWORD;
}

<YYINITIAL> "cached"
{
  return LBJavaElementTypes.CACHED;
}

<YYINITIAL> "cachedin"
{
  return LBJavaElementTypes.CACHEDIN;
}

<YYINITIAL> "cachedinmap"
{
  return LBJavaElementTypes.CACHEDINMAP;
}

<YYINITIAL> "case"
{
  return JavaTokenType.CASE_KEYWORD;
}

<YYINITIAL> "catch"
{
  return JavaTokenType.CATCH_KEYWORD;
}

<YYINITIAL> "char"
{
  return JavaTokenType.CHAR_KEYWORD;
}

<YYINITIAL> "class"
{
  return JavaTokenType.CLASS_KEYWORD;
}

<YYINITIAL> "const"
{
  return JavaTokenType.CONST_KEYWORD;
}

<YYINITIAL> "constraint"
{
  return LBJavaElementTypes.CONSTRAINT;
}

<YYINITIAL> "continue"
{
  return JavaTokenType.CONTINUE_KEYWORD;
}

<YYINITIAL> "cval"
{
  return LBJavaElementTypes.CVAL;
}

<YYINITIAL> "default"
{
  return JavaTokenType.DEFAULT_KEYWORD;
}

<YYINITIAL> "discrete"
{
  return LBJavaElementTypes.DISCRETE;
}

<YYINITIAL> "do"
{
  return JavaTokenType.DO_KEYWORD;
}

<YYINITIAL> "double"
{
  return JavaTokenType.DOUBLE_KEYWORD;
}

<YYINITIAL> "else"
{
  return JavaTokenType.ELSE_KEYWORD;
}

<YYINITIAL> "encoding"
{
  return LBJavaElementTypes.ENCODING;
}

<YYINITIAL> "end"
{
  return LBJavaElementTypes.END;
}

<YYINITIAL> "evaluate"
{
  return LBJavaElementTypes.EVALUATE;
}

<YYINITIAL> "extends"
{
  return JavaTokenType.EXTENDS_KEYWORD;
}

<YYINITIAL> "exists"
{
  return LBJavaElementTypes.EXISTS;
}

<YYINITIAL> "false"
{
  return JavaTokenType.FALSE_KEYWORD;
}

<YYINITIAL> "final"
{
  return JavaTokenType.FINAL_KEYWORD;
}

<YYINITIAL> "finally"
{
  return JavaTokenType.FINALLY_KEYWORD;
}

<YYINITIAL> "float"
{
  return JavaTokenType.FLOAT_KEYWORD;
}

<YYINITIAL> "for"
{
  return JavaTokenType.FOR_KEYWORD;
}

<YYINITIAL> "forall"
{
  return LBJavaElementTypes.FORALL;
}

<YYINITIAL> "from"
{
  return LBJavaElementTypes.FROM;
}

<YYINITIAL> "goto"
{
  return JavaTokenType.GOTO_KEYWORD;
}

<YYINITIAL> "head"
{
  return LBJavaElementTypes.HEAD;
}

<YYINITIAL> "if"
{
  return JavaTokenType.IF_KEYWORD;
}

<YYINITIAL> "in"
{
  return LBJavaElementTypes.IN;
}

<YYINITIAL> "implements"
{
  return JavaTokenType.IMPLEMENTS_KEYWORD;
}

<YYINITIAL> "import"
{
  return JavaTokenType.IMPORT_KEYWORD;
}

<YYINITIAL> "inference"
{
  return LBJavaElementTypes.INFERENCE;
}

<YYINITIAL> "instanceof"
{
  return JavaTokenType.INSTANCEOF_KEYWORD;
}

<YYINITIAL> "int"
{
  return JavaTokenType.INT_KEYWORD;
}

<YYINITIAL> "interface"
{
  return JavaTokenType.INTERFACE_KEYWORD;
}

<YYINITIAL> "learn"
{
  return LBJavaElementTypes.LEARN;
}

<YYINITIAL> "long"
{
  return JavaTokenType.LONG_KEYWORD;
}

<YYINITIAL> "maximize"
{
  return LBJavaElementTypes.MAXIMIZE;
}

<YYINITIAL> "minimize"
{
  return LBJavaElementTypes.MINIMIZE;
}

<YYINITIAL> "mixed"
{
  return LBJavaElementTypes.MIXED;
}

<YYINITIAL> "native"
{
  return JavaTokenType.NATIVE_KEYWORD;
}

<YYINITIAL> "new"
{
  return JavaTokenType.NEW_KEYWORD;
}

<YYINITIAL> "normalizedby"
{
  return LBJavaElementTypes.NORMALIZEDBY;
}

<YYINITIAL> "null"
{
  return JavaTokenType.NULL_KEYWORD;
}

<YYINITIAL> "of"
{
  return LBJavaElementTypes.OF;
}

<YYINITIAL> "package"
{
  return JavaTokenType.PACKAGE_KEYWORD;
}

<YYINITIAL> "preExtract"
{
  return LBJavaElementTypes.PREEXTRACT;
}

<YYINITIAL> "private"
{
  return JavaTokenType.PRIVATE_KEYWORD;
}

<YYINITIAL> "progressOutput"
{
  return LBJavaElementTypes.PROGRESSOUTPUT;
}

<YYINITIAL> "protected"
{
  return JavaTokenType.PROTECTED_KEYWORD;
}

<YYINITIAL> "prune"
{
  return LBJavaElementTypes.PRUNE;
}

<YYINITIAL> "public"
{
  return JavaTokenType.PUBLIC_KEYWORD;
}

<YYINITIAL> "real"
{
  return LBJavaElementTypes.REAL;
}

<YYINITIAL> "return"
{
  return JavaTokenType.RETURN_KEYWORD;
}

<YYINITIAL> "rounds"
{
  return LBJavaElementTypes.ROUNDS;
}

<YYINITIAL> "sense"
{
  return LBJavaElementTypes.SENSE;
}

<YYINITIAL> "senseall"
{
  return LBJavaElementTypes.SENSEALL;
}

<YYINITIAL> "short"
{
  return JavaTokenType.SHORT_KEYWORD;
}

<YYINITIAL> "static"
{
  return JavaTokenType.STATIC_KEYWORD;
}

<YYINITIAL> "strictfp"
{
  return JavaTokenType.STRICTFP_KEYWORD;
}

<YYINITIAL> "subjectto"
{
  return LBJavaElementTypes.SUBJECTTO;
}

<YYINITIAL> "super"
{
  return JavaTokenType.SUPER_KEYWORD;
}

<YYINITIAL> "switch"
{
  return JavaTokenType.SWITCH_KEYWORD;
}

<YYINITIAL> "synchronized"
{
  return JavaTokenType.SYNCHRONIZED_KEYWORD;
}

<YYINITIAL> "testFrom"
{
  return LBJavaElementTypes.TESTFROM;
}

<YYINITIAL> "testingMetric"
{
  return LBJavaElementTypes.TESTINGMETRIC;
}

<YYINITIAL> "this"
{
  return JavaTokenType.THIS_KEYWORD;
}

<YYINITIAL> "throw"
{
  return JavaTokenType.THROW_KEYWORD;
}

<YYINITIAL> "throws"
{
  return JavaTokenType.THROWS_KEYWORD;
}

<YYINITIAL> "transient"
{
  return JavaTokenType.TRANSIENT_KEYWORD;
}

<YYINITIAL> "true"
{
  return JavaTokenType.TRUE_KEYWORD;
}

<YYINITIAL> "try"
{
  return JavaTokenType.TRY_KEYWORD;
}

<YYINITIAL> "using"
{
  return JavaTokenType.USING_KEYWORD;
}

<YYINITIAL> "void"
{
  return JavaTokenType.VOID_KEYWORD;
}

<YYINITIAL> "volatile"
{
  return JavaTokenType.VOLATILE_KEYWORD;
}

<YYINITIAL> "while"
{
  return JavaTokenType.WHILE_KEYWORD;
}

<YYINITIAL> "with"
{
  return JavaTokenType.WITH_KEYWORD;
}


<YYINITIAL> {ALPHA}({ALPHA_NUMERIC})*
{
  return LBJavaElementTypes.IDENTIFIER;
}


<YYINITIAL> ";"
{ 
  return JavaTokenType.SEMICOLON_KEYWORD;
} 

<YYINITIAL> "("
{ 
  return JavaTokenType.LPARENTH;
} 

<YYINITIAL> ")"
{ 
  return JavaTokenType.RPARENTH;
} 

<YYINITIAL> "["
{ 
  return JavaTokenType.LBRACKET;
} 

<YYINITIAL> "]"
{ 
  return JavaTokenType.RBRACKET;
} 

<YYINITIAL> "{"
{ 
  return JavaTokenType.LBRACE;
} 

<YYINITIAL> "{{"
{ 
  return LBJavaElementTypes.LBRACEBRACE;
} 

<YYINITIAL> "}"
{ 
  return JavaTokenType.RBRACE;
} 

<YYINITIAL> "}}"
{ 
  return LBJavaElementTypes.RBRACEBRACE;
} 

<YYINITIAL> ","
{ 
  return JavaTokenType.COMMA;
} 


<YYINITIAL> "+"
{ 
  return JavaTokenType.PLUS;
} 

<YYINITIAL> "-"
{ 
  return JavaTokenType.MINUS;
} 

<YYINITIAL> "*"
{ 
  return JavaTokenType.ASTERISK;;
} 

<YYINITIAL> "/"
{ 
  return JavaTokenType.DIV;
} 

<YYINITIAL> "%"
{ 
  return JavaTokenType.PERC;
} 

<YYINITIAL> "."
{ 
  return JavaTokenType.DOT;
} 

<YYINITIAL> ".."
{ 
  return LBJavaElementTypes.DOTDOT;
} 

<YYINITIAL> "|"
{ 
  return JavaTokenType.OR;
} 

<YYINITIAL> "&"
{ 
  return JavaTokenType.AND;
} 

<YYINITIAL> "^"
{
  return JavaTokenType.XOR;
}

<YYINITIAL> "<"
{
  return JavaTokenType.LT;
}

<YYINITIAL> ">"
{
  return JavaTokenType.GT;
}

<YYINITIAL> "?"
{ 
  return JavaTokenType.QUEST;
} 

<YYINITIAL> ":"
{ 
  return JavaTokenType.COLON;
} 

<YYINITIAL> "="
{ 
  return JavaTokenType.EQ;
} 

<YYINITIAL> "~"
{
  return JavaTokenType.TILDE;
}

<YYINITIAL> "!"
{
  return JavaTokenType.EXCL;
}

<YYINITIAL> "@"
{
  return JavaTokenType.AT;
}

<YYINITIAL> "|="
{ 
  return JavaTokenType.OREQ;
} 

<YYINITIAL> "&="
{ 
  return JavaTokenType.ANDEQ;
} 

<YYINITIAL> "+="
{ 
  return JavaTokenType.PLUSEQ;
} 

<YYINITIAL> "-="
{ 
  return JavaTokenType.MINUSEQ;
} 

<YYINITIAL> "*="
{ 
  return JavaTokenType.ASTERISKEQ;
} 

<YYINITIAL> "/="
{ 
  return JavaTokenType.DIVEQ;
} 

<YYINITIAL> "%="
{ 
  return JavaTokenType.PERCEQ;
} 

<YYINITIAL> "^="
{ 
  return JavaTokenType.XOREQ;
} 

<YYINITIAL> "++"
{ 
  return JavaTokenType.PLUSPLUS;
} 

<YYINITIAL> "--"
{ 
  return JavaTokenType.MINUSMINUS;
}

<YYINITIAL> "<<"
{
  return JavaTokenType.LTLT;
}

<YYINITIAL> ">>"
{
  return JavaTokenType.GTGT;
}

<YYINITIAL> "<="
{
  return LBJavaElementTypes.LTEQ;
}

<YYINITIAL> ">="
{
  return LBJavaElementTypes.GTEQ;
}

<YYINITIAL> "=="
{
  return JavaTokenType.EQEQ;
}

<YYINITIAL> "!="
{
  return JavaTokenType.PERCEQ;
}

<YYINITIAL> "&&"
{
  return JavaTokenType.ANDAND;
}

<YYINITIAL> "||"
{
  return JavaTokenType.OROR;
}

<YYINITIAL> "::"
{
  return JavaTokenType.DOUBLE_COLON;
}

<YYINITIAL> "!:"
{
  return LBJavaElementTypes.BANGCOLON;
}

<YYINITIAL> "/"\\
{
  return LBJavaElementTypes.CONJUNCTION;
}

<YYINITIAL> \\"/"
{
  return LBJavaElementTypes.DISJUNCTION;
}

<YYINITIAL> "=>"
{
  return LBJavaElementTypes.IMPLICATION;
}

<YYINITIAL> "<-"
{
  return LBJavaElementTypes.ARROW;
}

<YYINITIAL> "->"
{
  return LBJavaElementTypes.RARROW;
}

<YYINITIAL> "<=>"
{
  return LBJavaElementTypes.DOUBLEIMPLICATION;
}

<YYINITIAL> "<<="
{
  return JavaTokenType.LTLTEQ;
}

<YYINITIAL> ">>="
{
  return JavaTokenType.GTGTEQ;
}

<YYINITIAL> ">>>"
{
  return JavaTokenType.GTGTGT;
}

<YYINITIAL> ">>>="
{
  return JavaTokenType.GTGTGTEQ;
}

.
{
  // ScannerError.illegalCharacterError();
  return TokenType.ERROR_ELEMENT;
}

