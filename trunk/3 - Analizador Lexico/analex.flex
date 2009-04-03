

/* Codigo de usuario */

class Utility {
	public static final String Keywords[] = {"graph","node","edge","minimumSpanningTree","shortestPath","union"};
	public static final String errorMsg[] = {
		"Identificador no valido",
		"Error de sintaxis"
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
		else if (cadena.equals("minimumSpanningTree")) token = "operadorUnario";
		else if (cadena.equals("shortestPath")) token = "operadorBinario";
		else if (cadena.equals("union")) token = "operadorQuinario";
		else System.out.println (":: ERROR. El lexema no se encuentra asociado a ningun token.");

		return token;

	}

	public static String errorMsg (int error) {
		return errorMsg[error];
	}

}


class Main {
	public static void main (String argv[]) {
		if (argv.length == 0 || argv.length > 1) {
			System.out.println("Uso : java AnaLex <inputfile>");
		}
		else {
			AnaLex scanner = null;
			try {
				scanner = new AnaLex( new java.io.FileReader(argv[0]));
				System.out.println (":: Analizando fichero "+argv[0]+"\n");
				scanner.yylex();
			}
				catch (java.io.FileNotFoundException e) {
				System.out.println("File not found : \""+argv[0]+"\"");
			}
			catch (java.io.IOException e) {
				System.out.println("IO error scanning file \""+argv[0]+"\"");
				System.out.println(e);
			}
			catch (Exception e) {
				System.out.println("Unexpected exception:");
				e.printStackTrace();
			}
		}
	}
}


%%

/* Seccion de opciones y declaraciones */

%class AnaLex
/* %standalone */
%type Object
%line
%column
%switch
%states COMMENT, COMMENTM

%eof{
	if(zzLexicalState==COMMENTM)
		System.out.println(Utility.errorMsg(ERROR_SYNTAX)+". Apertura de comentario sin cierre. Linea: "+(yyline+1)+" Columna: "+(yycolumn+1));
%eof}

%{
public static final int ERROR_MSG_IDENT = 0;
public static final int ERROR_SYNTAX  = 1;



%}

/* Macros */

LineTerminator = \r | \n | \r\n
WhiteSpace = {LineTerminator} | [\t\f] | " "



%%


<YYINITIAL> {
	"//"	{ yybegin(COMMENT); }
	"/*"	{ yybegin(COMMENTM); }
	[a-zA-Z][a-zA-Z0-9]*	{
					if (Utility.isKeyword(yytext())) {
						String Keyword = new String();
						Keyword = Utility.Keyword(yytext());
						if (Keyword.equals(yytext())) {
							System.out.println ("Token reconocido: "+Keyword+" id(13) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); 	
						} else {
							System.out.println ("Token reconocido: "+Keyword+" id(13) Lexema: "+yytext()+" Linea: " +(yyline+1)+" Columna: "+(yycolumn+1));	
						}
					} else {
						System.out.println("Token reconocido: ident id(13) Lexema: "+yytext()+" Linea: " +(yyline+1)+" Columna: "+(yycolumn+1));
					}
				}
	"{"			{ System.out.println("Token reconocido: l_bracket id(2) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	"}"			{ System.out.println("Token reconocido: r_bracket id(3) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	"("			{ System.out.println("Token reconocido: l_paren id(4) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	")"			{ System.out.println("Token reconocido: r_paren id(5) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	";"			{ System.out.println("Token reconocido: semicolon id(6) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	","			{ System.out.println("Token reconocido: comma id(7) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	"="			{ System.out.println("Token reconocido: equal id(8) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	"-" | "->"		{ System.out.println("Token reconocido: connector id(9) Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	0			{ System.out.println("Token reconocido: number id(11) Lexema: "+yytext()+" Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	[1-9][0-9]*		{ System.out.println("Token reconocido: number id(12) Lexema: "+yytext()+" Linea: " +(yyline+1)+" Columna: "+(yycolumn+1)); }
	"*/"			{ System.out.println(Utility.errorMsg(ERROR_SYNTAX)+". Fin de comentario sin apertura. Linea: "+(yyline+1)+" Columna: "+(yycolumn+1)); }
	[0-9][a-zA-Z0-9]*	{ System.out.println(Utility.errorMsg(ERROR_MSG_IDENT)+" <"+yytext()+"> Linea: "+(yyline+1)+" Columna: "+(yycolumn+1)); }
	{WhiteSpace}		{ }
	.			{ System.out.println("Expresion ilegal <"+yytext()+"> Linea: "+(yyline+1)+" Columna: "+(yycolumn+1)); }

}



<COMMENT> {
	{LineTerminator}	{ yybegin(YYINITIAL); }
	.	{ }
}


<COMMENTM> {
	"*/"	{ yybegin(YYINITIAL); }
	{LineTerminator}	{ }
	.	{ } 
}

