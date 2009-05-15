// Driver for parser
package analizador;
import java_cup.runtime.Symbol;
import java.io.*;

class Main
{
	static boolean do_debug_parse=false;
	
	static public void main (String[] args) throws java.io.IOException {
		parser parser_obj = new parser(new AnaLex(new FileReader(args[0])));
		Symbol parse_tree = null;
		try {
			if (do_debug_parse)
				parse_tree = parser_obj.debug_parse();
			else
				parse_tree = parser_obj.parse();
		}
		catch (Exception e) {
			System.out.println("Analisis INCORRECTO!");
            e.printStackTrace();

		}
		finally {
			System.out.println("Fin del analisis");
		}
	}
}