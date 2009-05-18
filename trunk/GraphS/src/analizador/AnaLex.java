/* The following code was generated by JFlex 1.4.2 on 18/05/09 6:49 */

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
        else System.out.println ("Error: Lexeme not associated with a token.");

        return token;
    }

    public static String errorMsg (int error) {
        return errorMsg[error];
    }

}




/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.2
 * on 18/05/09 6:49 from the specification file
 * <tt>E:/Universidad/Ingenieria Superior/Procesadores de Lenguajes/pl-graphs/5 - Analizador Semantico/analex.flex</tt>
 */
public class AnaLex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int COMMENTM = 4;
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\7\0\1\12"+
    "\1\13\1\5\1\0\1\15\1\17\1\0\1\4\1\21\11\7\1\0"+
    "\1\14\1\0\1\16\1\20\2\0\32\6\6\0\32\6\1\10\1\0"+
    "\1\11\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\2\2\2\1\1\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\4\2\15"+
    "\1\2\1\16\1\17\1\20\1\21\1\14";

  private static int [] zzUnpackAction() {
    int [] result = new int[27];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
public static final int ERROR_MSG_IDENT = 0;
public static final int ERROR_SYNTAX  = 1;

private Symbol symbol (int type) {
    return new Symbol(type,yyline+1,yycolumn+1);
}

private Symbol symbol (int type, Object val) {
    return new Symbol(type,yyline+1,yycolumn+1,val);
}



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnaLex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AnaLex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 64) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
        if(zzLexicalState==COMMENTM)
            System.out.println((yyline+1) + ":" + (yycolumn+1) + " " + Utility.errorMsg(ERROR_SYNTAX)+"Unclosed comment.\n");
  yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;


    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          zzInput = zzCMapL[zzInput];

          boolean zzIsFinal = false;
          boolean zzNoLookAhead = false;

          zzForNext: { switch (zzState) {
            case 0:
              switch (zzInput) {
                case 1: zzIsFinal = true; zzState = 4; break zzForNext;
                case 2: 
                case 3: zzIsFinal = true; zzNoLookAhead = true; zzState = 5; break zzForNext;
                case 4: zzIsFinal = true; zzState = 6; break zzForNext;
                case 5: zzIsFinal = true; zzState = 7; break zzForNext;
                case 6: zzIsFinal = true; zzState = 8; break zzForNext;
                case 7: zzIsFinal = true; zzState = 9; break zzForNext;
                case 8: zzIsFinal = true; zzNoLookAhead = true; zzState = 10; break zzForNext;
                case 9: zzIsFinal = true; zzNoLookAhead = true; zzState = 11; break zzForNext;
                case 10: zzIsFinal = true; zzNoLookAhead = true; zzState = 12; break zzForNext;
                case 11: zzIsFinal = true; zzNoLookAhead = true; zzState = 13; break zzForNext;
                case 12: zzIsFinal = true; zzNoLookAhead = true; zzState = 14; break zzForNext;
                case 13: zzIsFinal = true; zzNoLookAhead = true; zzState = 15; break zzForNext;
                case 14: zzIsFinal = true; zzNoLookAhead = true; zzState = 16; break zzForNext;
                case 15: zzIsFinal = true; zzState = 17; break zzForNext;
                case 17: zzIsFinal = true; zzState = 18; break zzForNext;
                default: zzIsFinal = true; zzNoLookAhead = true; zzState = 3; break zzForNext;
              }

            case 1:
              switch (zzInput) {
                case 1: zzIsFinal = true; zzState = 19; break zzForNext;
                case 2: zzIsFinal = true; zzNoLookAhead = true; zzState = 20; break zzForNext;
                default: zzIsFinal = true; zzNoLookAhead = true; zzState = 5; break zzForNext;
              }

            case 2:
              switch (zzInput) {
                case 1: zzIsFinal = true; zzState = 4; break zzForNext;
                case 5: zzIsFinal = true; zzState = 21; break zzForNext;
                default: zzIsFinal = true; zzNoLookAhead = true; zzState = 5; break zzForNext;
              }

            case 4:
              switch (zzInput) {
                case 2: zzIsFinal = true; zzNoLookAhead = true; zzState = 5; break zzForNext;
                default: break zzForAction;
              }

            case 6:
              switch (zzInput) {
                case 4: zzIsFinal = true; zzNoLookAhead = true; zzState = 22; break zzForNext;
                case 5: zzIsFinal = true; zzNoLookAhead = true; zzState = 23; break zzForNext;
                default: break zzForAction;
              }

            case 7:
              switch (zzInput) {
                case 4: zzIsFinal = true; zzNoLookAhead = true; zzState = 24; break zzForNext;
                default: break zzForAction;
              }

            case 8:
              switch (zzInput) {
                case 6: 
                case 7: 
                case 17: zzIsFinal = true; break zzForNext;
                default: break zzForAction;
              }

            case 9:
              switch (zzInput) {
                case 7: 
                case 17: zzIsFinal = true; break zzForNext;
                case 6: zzIsFinal = true; zzState = 25; break zzForNext;
                default: break zzForAction;
              }

            case 17:
              switch (zzInput) {
                case 16: zzIsFinal = true; zzNoLookAhead = true; zzState = 26; break zzForNext;
                default: break zzForAction;
              }

            case 18:
              switch (zzInput) {
                case 6: 
                case 7: 
                case 17: zzIsFinal = true; zzState = 25; break zzForNext;
                default: break zzForAction;
              }

            case 19:
              switch (zzInput) {
                case 2: zzIsFinal = true; zzNoLookAhead = true; zzState = 20; break zzForNext;
                default: break zzForAction;
              }

            case 21:
              switch (zzInput) {
                case 4: zzIsFinal = true; zzNoLookAhead = true; zzState = 20; break zzForNext;
                default: break zzForAction;
              }

            case 25:
              switch (zzInput) {
                case 6: 
                case 7: 
                case 17: zzIsFinal = true; break zzForNext;
                default: break zzForAction;
              }

            default:
              // if this is ever reached, there is a serious bug in JFlex
              zzScanError(ZZ_UNKNOWN_ERROR);
              break;
          } }

          if ( zzIsFinal ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( zzNoLookAhead ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 16: 
          { parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " " + Utility.errorMsg(ERROR_SYNTAX)+"Illegal start of expresion.\n");
          }
        case 18: break;
        case 14: 
          { yybegin(COMMENT);
          }
        case 19: break;
        case 7: 
          { return symbol(sym.l_paren);
          }
        case 20: break;
        case 9: 
          { return symbol(sym.semicolon);
          }
        case 21: break;
        case 12: 
          { return symbol(sym.connector, yytext());
          }
        case 22: break;
        case 1: 
          { parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " Illegal exprsion <"+yytext()+">\n");
          }
        case 23: break;
        case 11: 
          { return symbol(sym.equal);
          }
        case 24: break;
        case 17: 
          { parser.ponerMensajes((yyline+1) + ":" + (yycolumn+1) + " " + Utility.errorMsg(ERROR_MSG_IDENT)+" <"+yytext()+">\n");
          }
        case 25: break;
        case 5: 
          { return symbol(sym.l_bracket);
          }
        case 26: break;
        case 15: 
          { yybegin(COMMENTM);
          }
        case 27: break;
        case 3: 
          { if (Utility.isKeyword(yytext())) {
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
        case 28: break;
        case 4: 
          { return symbol(sym.number, new Integer(yytext()));
          }
        case 29: break;
        case 8: 
          { return symbol(sym.r_paren);
          }
        case 30: break;
        case 10: 
          { return symbol(sym.comma);
          }
        case 31: break;
        case 13: 
          { yybegin(YYINITIAL);
          }
        case 32: break;
        case 6: 
          { return symbol(sym.r_bracket);
          }
        case 33: break;
        case 2: 
          { 
          }
        case 34: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
