
//----------------------------------------------------
// The following code was generated by CUP v0.10k
// Sun Mar 15 20:58:55 CET 2009
//----------------------------------------------------

import java_cup.runtime.*;

/** CUP v0.10k generated parser.
  * @version Sun Mar 15 20:58:55 CET 2009
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\035\000\002\003\004\000\002\002\004\000\002\004" +
    "\004\000\002\004\002\000\002\005\010\000\002\006\006" +
    "\000\002\006\004\000\002\007\003\000\002\007\003\000" +
    "\002\007\002\000\002\010\007\000\002\012\005\000\002" +
    "\012\002\000\002\011\007\000\002\011\012\000\002\013" +
    "\005\000\002\013\010\000\002\013\002\000\002\014\004" +
    "\000\002\014\002\000\002\015\010\000\002\016\004\000" +
    "\002\017\004\000\002\017\002\000\002\020\004\000\002" +
    "\020\004\000\002\021\006\000\002\022\010\000\002\023" +
    "\016" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\125\000\012\002\ufff8\004\ufff8\005\006\006\007\001" +
    "\002\000\004\002\127\001\002\000\006\002\ufffe\004\043" +
    "\001\002\000\004\022\033\001\002\000\004\022\012\001" +
    "\002\000\010\002\ufffa\004\ufffa\022\ufffa\001\002\000\010" +
    "\002\ufff9\004\ufff9\022\ufff9\001\002\000\010\014\015\016" +
    "\ufff0\017\013\001\002\000\004\022\025\001\002\000\004" +
    "\016\023\001\002\000\004\023\016\001\002\000\004\015" +
    "\017\001\002\000\006\016\ufff0\017\013\001\002\000\004" +
    "\016\021\001\002\000\014\002\ufff8\004\ufff8\005\006\006" +
    "\007\022\ufff8\001\002\000\010\002\ufff3\004\ufff3\022\ufff3" +
    "\001\002\000\014\002\ufff8\004\ufff8\005\006\006\007\022" +
    "\ufff8\001\002\000\010\002\ufff4\004\ufff4\022\ufff4\001\002" +
    "\000\010\014\027\016\ufff0\017\013\001\002\000\004\016" +
    "\ufff2\001\002\000\004\023\030\001\002\000\004\015\031" +
    "\001\002\000\006\016\ufff0\017\013\001\002\000\004\016" +
    "\ufff1\001\002\000\006\016\ufff5\017\034\001\002\000\004" +
    "\022\040\001\002\000\004\016\036\001\002\000\014\002" +
    "\ufff8\004\ufff8\005\006\006\007\022\ufff8\001\002\000\010" +
    "\002\ufff7\004\ufff7\022\ufff7\001\002\000\006\016\ufff5\017" +
    "\034\001\002\000\004\016\ufff6\001\002\000\004\002\001" +
    "\001\002\000\004\022\046\001\002\000\006\002\ufffe\004" +
    "\043\001\002\000\004\002\uffff\001\002\000\004\012\047" +
    "\001\002\000\012\005\006\006\007\011\051\022\ufff8\001" +
    "\002\000\004\016\126\001\002\000\004\014\113\001\002" +
    "\000\010\007\074\010\070\013\uffea\001\002\000\004\013" +
    "\110\001\002\000\004\022\056\001\002\000\012\007\uffee" +
    "\010\uffee\013\uffee\022\056\001\002\000\004\020\057\001" +
    "\002\000\004\022\060\001\002\000\004\021\061\001\002" +
    "\000\004\022\062\001\002\000\004\016\063\001\002\000" +
    "\012\007\uffed\010\uffed\013\uffed\022\uffed\001\002\000\010" +
    "\007\074\010\070\013\uffea\001\002\000\012\007\uffee\010" +
    "\uffee\013\uffee\022\056\001\002\000\010\007\uffef\010\uffef" +
    "\013\uffef\001\002\000\010\007\074\010\070\013\uffea\001" +
    "\002\000\004\014\102\001\002\000\004\013\ufffc\001\002" +
    "\000\004\016\101\001\002\000\004\016\100\001\002\000" +
    "\004\014\075\001\002\000\004\022\076\001\002\000\004" +
    "\015\077\001\002\000\004\016\uffe7\001\002\000\010\007" +
    "\uffe9\010\uffe9\013\uffe9\001\002\000\010\007\uffe8\010\uffe8" +
    "\013\uffe8\001\002\000\004\022\103\001\002\000\004\017" +
    "\104\001\002\000\004\022\105\001\002\000\004\015\106" +
    "\001\002\000\004\016\uffe6\001\002\000\004\013\uffeb\001" +
    "\002\000\004\016\111\001\002\000\006\002\ufffd\004\ufffd" +
    "\001\002\000\004\013\ufffb\001\002\000\004\022\114\001" +
    "\002\000\004\017\115\001\002\000\004\022\116\001\002" +
    "\000\004\017\117\001\002\000\004\022\120\001\002\000" +
    "\004\017\121\001\002\000\004\022\122\001\002\000\004" +
    "\017\123\001\002\000\004\022\124\001\002\000\004\015" +
    "\125\001\002\000\004\016\uffe5\001\002\000\010\007\uffec" +
    "\010\uffec\013\uffec\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\125\000\012\003\003\007\004\010\007\011\010\001" +
    "\001\000\002\001\001\000\006\004\041\005\043\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\013\013\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\013\017\001\001\000\002\001\001\000\010\007\021" +
    "\010\007\011\010\001\001\000\002\001\001\000\010\007" +
    "\023\010\007\011\010\001\001\000\002\001\001\000\004" +
    "\013\025\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\004\013\031\001\001\000\002\001\001" +
    "\000\004\012\034\001\001\000\002\001\001\000\002\001" +
    "\001\000\010\007\036\010\007\011\010\001\001\000\002" +
    "\001\001\000\004\012\040\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\004\044\005\043" +
    "\001\001\000\002\001\001\000\002\001\001\000\016\006" +
    "\052\007\053\010\007\011\010\016\051\023\047\001\001" +
    "\000\002\001\001\000\002\001\001\000\012\017\111\020" +
    "\066\021\072\022\071\001\001\000\002\001\001\000\004" +
    "\015\054\001\001\000\006\014\063\015\064\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\017" +
    "\070\020\066\021\072\022\071\001\001\000\006\014\065" +
    "\015\064\001\001\000\002\001\001\000\012\017\106\020" +
    "\066\021\072\022\071\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // OP5 ::= operadorQuinario l_paren ident comma ident comma ident comma ident comma ident r_paren 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(17/*OP5*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-11)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // OP2 ::= operadorBinario l_paren ident comma ident r_paren 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(16/*OP2*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // OP1 ::= operadorUnario l_paren ident r_paren 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(15/*OP1*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // OP ::= OP2 semicolon 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(14/*OP*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // OP ::= OP1 semicolon 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(14/*OP*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // OPS ::= 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*OPS*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // OPS ::= OP OPS 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(13/*OPS*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // OPS_GEN ::= OP5 semicolon 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(12/*OPS_GEN*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // ARC ::= ident equal ident connector ident semicolon 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(11/*ARC*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // ARCS ::= 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(10/*ARCS*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ARCS ::= ARC ARCS 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(10/*ARCS*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // MORE_EDGES ::= 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(9/*MORE_EDGES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // MORE_EDGES ::= comma ident l_paren number r_paren MORE_EDGES 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(9/*MORE_EDGES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // MORE_EDGES ::= comma ident MORE_EDGES 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(9/*MORE_EDGES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // DECL_EDGES ::= edge ident l_paren number r_paren MORE_EDGES semicolon DECL 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(7/*DECL_EDGES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-7)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // DECL_EDGES ::= edge ident MORE_EDGES semicolon DECL 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(7/*DECL_EDGES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // MORE_NODES ::= 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(8/*MORE_NODES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // MORE_NODES ::= comma ident MORE_NODES 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(8/*MORE_NODES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // DECL_NODES ::= node ident MORE_NODES semicolon DECL 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(6/*DECL_NODES*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // DECL ::= 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(5/*DECL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // DECL ::= DECL_EDGES 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(5/*DECL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // DECL ::= DECL_NODES 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(5/*DECL*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // BODY ::= OPS_GEN OPS 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(4/*BODY*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // BODY ::= DECL ARC ARCS OPS 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(4/*BODY*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // GRAPH ::= graph ident l_bracket BODY r_bracket semicolon 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(3/*GRAPH*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // GRAPHS_SET ::= 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(2/*GRAPHS_SET*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // GRAPHS_SET ::= GRAPH GRAPHS_SET 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(2/*GRAPHS_SET*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= SYNTAX EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // SYNTAX ::= DECL GRAPHS_SET 
            {
              Object RESULT = null;

              CUP$parser$result = new java_cup.runtime.Symbol(1/*SYNTAX*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

