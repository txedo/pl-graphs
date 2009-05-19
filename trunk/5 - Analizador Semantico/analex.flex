package analizador;

import java_cup.runtime.*;

/* Codigo de usuario */

class Utility {
    public static final String Keywords[] = {"graph","node","edge", "op", "minimumSpanningTree","shortestPath","union"};
    public static final String errorMsg[] = {
        "Error: Invalid variable name",
        "Syntax error: "
    };

    public static boolean isKeyword (String cadena) {
        boolean found = false;
        for (int i = 0; i < Keywords.length && !found; i++) {
                if (cadena.equals(Keywords[i])) found = true;
        }
        return found;
    }

    public static String Keyword (String cadena) {
        String token = "";

        if (cadena.equals("graph")) token = "graph";
        else if (cadena.equals("node")) token = "node";
        else if (cadena.equals("edge")) token = "edge";
        else if (cadena.equals("op")) token = "op";
        else if (cadena.equals("minimumSpanningTree")) token = "operadorUnario";
        else if (cadena.equals("shortestPath")) token = "operadorBinario";
        else if (cadena.equals("union")) token = "operadorQuinario";
        else parser.ponerMensajes("Error: Lexeme not associated with a token.");

        return token;
    }

    public static String errorMsg (int error) {
        return errorMsg[error];
    }

}



%%

/* Seccion de opciones y declaraciones */

%class AnaLex
%cup        /* Compatibilidad con el interfaz CUP */
%public
%line
%column
%switch
%states COMMENT, COMMENTM

%eof{
    if(zzLexicalState==COMMENTM)
            parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " " + Utility.errorMsg(ERROR_SYNTAX)+"Unclosed comment.\n");
%eof}

%{
public static final int ERROR_MSG_IDENT = 0;
public static final int ERROR_SYNTAX  = 1;

private Symbol symbol (int type) {
    return new Symbol(type,yyline+1,yycolumn+1);
}

private Symbol symbol (int type, Object val) {
    return new Symbol(type,yyline+1,yycolumn+1,val);
}

%}

/* Macros */

LineTerminator = \r | \n | \r\n
WhiteSpace = {LineTerminator} | [\t\f] | " "



%%


<YYINITIAL> {
    "//"        { yybegin(COMMENT); }
    "/*"        { yybegin(COMMENTM); }
    [a-zA-Z][a-zA-Z0-9]*        {
        if (Utility.isKeyword(yytext())) {
            String Keyword = new String();
            Keyword = Utility.Keyword(yytext());
            if (Keyword.equals(yytext())) {
                if (yytext().equals("graph")) return symbol(sym.graph);
                if (yytext().equals("node")) return symbol(sym.node);
                if (yytext().equals("edge")) return symbol(sym.edge);
                if (yytext().equals("op")) return symbol(sym.op);
            } else {
                if (yytext().equals("minimumSpanningTree")) return symbol(sym.operadorUnario, yytext());
                if (yytext().equals("shortestPath")) return symbol(sym.operadorBinario, yytext());
                if (yytext().equals("union")) return symbol(sym.operadorQuinario, yytext());
            }
        } else {
            return symbol(sym.ident, yytext());
        }
    }
    "{"                { return symbol(sym.l_bracket); }
    "}"                { return symbol(sym.r_bracket); }
    "("                { return symbol(sym.l_paren); }
    ")"                { return symbol(sym.r_paren); }
    ";"                { return symbol(sym.semicolon); }
    ","                { return symbol(sym.comma); }
    "="                { return symbol(sym.equal); }
    "-" | "->"         { return symbol(sym.connector, yytext()); }
    0 | [1-9][0-9]*    { return symbol(sym.number, new Integer(yytext())); }
    "*/"               { parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " " + Utility.errorMsg(ERROR_SYNTAX)+"Illegal start of expresion.\n"); }
    [0-9][a-zA-Z0-9]*  { parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " " + Utility.errorMsg(ERROR_MSG_IDENT)+" <"+yytext()+">\n"); }
    {WhiteSpace}       { }
    .                  { parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " Illegal exprsion <"+yytext()+">\n"); }
}



<COMMENT> {
        {LineTerminator}        { yybegin(YYINITIAL); }
        .        { }
}


<COMMENTM> {
        "*/"        { yybegin(YYINITIAL); }
        {LineTerminator}        { }
        .        { }
}

