/*
 * AutoPro
 *
 * AutoPro is the legal property of its developers. Please refer to the 
 * COPYRIGHT file distributed with this source distribution.
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */

package utilidades;
import java.util.LinkedList;
import java.io.File;
import dominio.*;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author glam
 */
public class Result {
    
    /*Esta clase se encargara de mostrar el resultado. Utilizamos un patron
     *singleton para evitar que se cree mas de una instancia de la misma. Actuar�
     *como un controlador del modelo vista-controlador, recibiendo la lista de 
     *automatas que debe mostrar como resultado, generando su salida con graphviz
     *y mostrandola mediante html*/
    private String dotUbication = "dot";
    private static Result INSTANCE = null;
    private String generacion = "default";
    private static StringBuffer result = new StringBuffer("");

    // Private constructor suppresses 
    
    private Result(String dotUbication) {
        this.dotUbication = dotUbication;
    }
    
    

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instantiaci�n m�ltiple 
    
    private synchronized static void createInstance(String dotUbication) {
        if (INSTANCE == null) { 
            INSTANCE = new Result(dotUbication);
        }
    }

    public static Result getInstance(String dotUbication) {
        if (INSTANCE == null) createInstance(dotUbication);
        return INSTANCE;
    }
    
    private Result() {
        this.dotUbication = dotUbication;
    }
    

    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instantiaci�n m�ltiple 
    
    private synchronized static void createInstance() {
        if (INSTANCE == null) { 
            INSTANCE = new Result();
        }
    }

    public static Result getInstance() {
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }
    
    private void setGeneracion(String g) {
        this.generacion = g;
    }
        
    public void creaGrafos(ArrayList<Graph> listaGrafos) {
        Graph grafo = null;
        GraphViz gv = null;
        java.io.File prueba = null;
        for (int i=0;i<listaGrafos.size();i++) {
            grafo = listaGrafos.get(i);
            gv = new GraphViz(dotUbication);
            if (grafo.isDirected()) gv.addln(gv.start_digraph(grafo.getName()));
            else gv.addln(gv.start_graph(grafo.getName()));
            gv.addln("node [shape=circle, style=filled, fillcolor=grey90]");
            gv.addln("rankdir=LR");
            for (Edge e : grafo.getEdges()) {
                if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=" + e.getName() + "];");
                else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=" + e.getName() + "];");
            }
            gv.addln(gv.end_graph());
            prueba = new java.io.File(grafo.getName() + ".gif");
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource()),prueba);

            for (Operation o : grafo.getOperations()) {
                gv = new GraphViz(dotUbication);
                Graph aux = null;
                if (o.getOperation().equals("shortestPath"))
                    aux = grafo.Floyd((Node)o.getParams().get(0), (Node)o.getParams().get(1));
                else if (o.getOperation().equals("minimumSpanningTree"))
                    aux = grafo.Kruskal();
                if (aux.isDirected()) gv.addln(gv.start_digraph(aux.getName()));
                else gv.addln(gv.start_graph(aux.getName()));
                gv.addln("rankdir=LR");
                gv.addln("node [shape=circle, style=filled, fillcolor=grey90]");
                for (Node n : aux.getNodes()) {
                    gv.addln(n.getName() + " [color=red, fillcolor=papayawhip]");
                }
                for (Edge e : grafo.getEdges()) {
                    if (aux.getEdges().contains((Edge)e)) {
                        if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=" + e.getName() + ", color=red];");
                        else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=" + e.getName() + ", color=red];");
                    }
                    else {
                        if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=" + e.getName() + "];");
                        else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=" + e.getName() + "];");
                    }
                }
                gv.addln(gv.end_graph());
                prueba = new java.io.File(aux.getName() + ".gif");
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource()),prueba);
            }
        }
    }
    
  
    
    public static void limpiaResultados() {
        result = new StringBuffer("");
    }
    public static void agregaTexto(String texto) {
        result.append(texto);
    }
    
    public static String getResultado() {
        result.append("\n\n<h3>" +
                "<font color=black size=+2><i>AutoPro</i></font>\n\n" +
                "Creado por:\n" +
                "Ignacio Arriaga S�nchez\n" +
                "Manuel Rodrigo G�mez\n\n");
        result.append("</body></html>");
        
        return (result.toString()).replaceAll("\n", "<br>");
    }
    
    
}

