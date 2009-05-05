/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dominio;

/**
 *
 * @author Angel
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grafo g = new Grafo("Grafo prueba", 1);
        Nodo s = new Nodo("s");
        Nodo uno = new Nodo("1");
        Nodo dos = new Nodo("2");
        Nodo tres = new Nodo("3");
        Nodo cuatro = new Nodo("4");
        Nodo cinco = new Nodo("5");
        Nodo seis = new Nodo("6");
        Nodo t = new Nodo("t");

        g.getNodos().add(s);
        g.getNodos().add(uno);
        g.getNodos().add(dos);
        g.getNodos().add(tres);
        g.getNodos().add(cuatro);
        g.getNodos().add(cinco);
        g.getNodos().add(seis);
        g.getNodos().add(t);

        Arco a = new Arco("a", 2, s, uno);

        g.getArcos().add(a);
        g.getArcos().add(new Arco("b", 1, s, cinco));
        g.getArcos().add(new Arco("c", 2, uno, tres));
        g.getArcos().add(new Arco("d", 2, uno, dos));
        g.getArcos().add(new Arco("e", 4, uno, cuatro));
        g.getArcos().add(new Arco("f", 3, tres, cinco));
        g.getArcos().add(new Arco("g", 4, tres, cuatro));
        g.getArcos().add(new Arco("h", 5, cinco, seis));
        g.getArcos().add(new Arco("i", 3, dos, cuatro));
        g.getArcos().add(new Arco("j", 7, cuatro, seis));
        g.getArcos().add(new Arco("k", 1, dos, t));
        g.getArcos().add(new Arco("l", 6, seis, t));

        System.out.println(g.toString());

		//g.crearMatrizAdyacencia();

        for(int i=0; i<g.getAdyacencia().length;i++){
            for(int j=0; j<g.getAdyacencia().length;j++){
                System.out.print(g.getAdyacencia()[i][j] + " ");
            }
            System.out.println();
        }

        Grafo res = Operacion.shortestPath(g, s, t);
        Grafo res2 = Operacion.union("Union_g_res", g, res, uno, t, new Arco("union_arc", 2, uno, t));

        System.out.println(res.toString()+"\n\n\n");

        System.out.println(res2.toString()+"\n\n\n");
    }

}
