package analizador;

import dominio.Node;
import dominio.Edge;
import dominio.Graph;

public class EntradaTS {
    private Object variable;
    private int timesUsed;

    public EntradaTS(Object variable, int timesUsed) {
        this.variable = variable;
        this.timesUsed = timesUsed;
    }

    public int getTimesUsed() {
        return timesUsed;
    }

    public Object getVariable() {
        return variable;
    }

    public void setTimesUsed(int timesUsed) {
        this.timesUsed = timesUsed;
    }

    public void setVariable(Object variable) {
        this.variable = variable;
    }

    public int getTipo() {
        int tipo = -1;
        
        if (variable instanceof Node) tipo = parser.NODE;
        if (variable instanceof Edge) tipo = parser.EDGE;
        if (variable instanceof Graph) tipo = parser.GRAPH;
        
        return tipo;
    }

    public String toString(){
        return "Variable: " + " timesUsed: " ;
    }
}
