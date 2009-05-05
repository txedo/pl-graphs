/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author Angel
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Grafo g = new Grafo("Grafo prueba", true, true);

        
        g.getNodos().add("s");
        g.getNodos().add("1");
        g.getNodos().add("2");
        g.getNodos().add("3");
        g.getNodos().add("4");
        g.getNodos().add("5");
        g.getNodos().add("6");
        g.getNodos().add("t");


        g.getArcos().add(new Arco("a", 2, true, "s", "1"));
        g.getArcos().add(new Arco("b", 1, true, "s", "5"));
        g.getArcos().add(new Arco("c", 2, true, "1", "3"));
        g.getArcos().add(new Arco("d", 2, true, "1", "2"));
        g.getArcos().add(new Arco("e", 4, true, "1", "4"));
        g.getArcos().add(new Arco("f", 3,  true,"3", "5"));
        g.getArcos().add(new Arco("g", 4, true, "3", "4"));
        g.getArcos().add(new Arco("h", 5, true, "5", "6"));
        g.getArcos().add(new Arco("i", 3, true, "2", "4"));
        g.getArcos().add(new Arco("j", 7, true, "4", "6"));
        g.getArcos().add(new Arco("k", 1, true, "2", "t"));
        g.getArcos().add(new Arco("l", 6, true, "6", "t"));

        System.out.println(g.toString());

		g.crearMatrizAdyacencia();

        for(int i=0; i<g.getAdyacencia().length;i++){
            for(int j=0; j<g.getAdyacencia().length;j++){
                System.out.print(g.getAdyacencia()[i][j] + " ");
            }
            System.out.println();
        }
        Grafo res = Operacion.shortestPath(g, "s", "t");
        //Grafo res2 = Operacion.union("Union_g_res", g, res, uno, t, new Arco("union_arc", 2, uno, t));

        System.out.println(res.toString()+"\n\n\n");

        //System.out.println(res2.toString()+"\n\n\n");
    }

}
