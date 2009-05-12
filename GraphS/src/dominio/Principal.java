import java.util.ArrayList;


public class Principal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Grafo original al cual aplicaremos Kruskal");
		Graph test1 = obtenerGrafoEjemplo_Kruskal();
		System.out.println(test1.toString());
		System.out.println("Grafo con Kruskal aplicado");
		Graph grafo_kruskal = test1.Kruskal();
		System.out.println(grafo_kruskal.toString());
		System.out.println("Comprobamos que el grafo original no ha sido modificado");
		System.out.println(test1.toString());
		System.out.println("-------------------------------");
		System.out.println("Grafo original al cual aplicaremos Floyd");
		Graph test2 = obtenerGrafoEjemplo_Floyd();
		System.out.println(test2.toString());
		System.out.println("Grafo con Floyd aplicado");
		Graph grafo_floyd = test2.Floyd(new Node("S"), new Node("T"));
		System.out.println(grafo_floyd.toString());
		System.out.println("Comprobamos que el grafo original no ha sido modificado");
		System.out.println(test2.toString());
		System.out.println("-------------------------------");
		System.out.println("Grafo original al cual aplicaremos UNION");
		Graph test3 = Graph.Union(test1, test2, new Node("A"), new Node("S"), new Edge("Z", new Node("A"), new Node("S"), 2));
		System.out.println(test3.toString());
	}
	
	public static Graph obtenerGrafoEjemplo_Kruskal () {
		Graph res = null;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node A = new Node("A");
		Node B = new Node("B");
		Node C = new Node("C");
		Node D = new Node("D");
		Node E = new Node("E");
		nodes.add(A);
		nodes.add(B);
		nodes.add(C);
		nodes.add(D);
		nodes.add(E);
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		Edge x = new Edge("X", A, B, 4);
		Edge y = new Edge("Y", A, C, 1);
		Edge z = new Edge("Z", A, E, 2);
		Edge l = new Edge("L", C, E, 3);
		Edge m = new Edge("M", C, D, 3);
		Edge n = new Edge("N", E, D, 2);
		Edge o = new Edge("O", B, E, 3);
		Edge p = new Edge("P", B, D, 1);
		edges.add(x);
		edges.add(y);
		edges.add(z);
		edges.add(l);
		edges.add(m);
		edges.add(n);
		edges.add(o);
		edges.add(p);
		/*
		Edge x1 = new Edge(B, A, 4);
		Edge y1 = new Edge(C, A, 1);
		Edge z1 = new Edge(E, A, 2);
		Edge l1 = new Edge(E, C, 3);
		Edge m1 = new Edge(D, C, 3);
		Edge n1 = new Edge(D, E, 2);
		Edge o1 = new Edge(E, B, 3);
		Edge p1 = new Edge(D, B, 1);
		edges.add(x1);
		edges.add(y1);
		edges.add(z1);
		edges.add(l1);
		edges.add(m1);
		edges.add(n1);
		edges.add(o1);
		edges.add(p1);
		*/

		res = new Graph("Grafo2", false, false, nodes, edges);
		return res;
	}
	
	public static Graph obtenerGrafoEjemplo_Floyd () {
		Graph res = null;
		ArrayList<Node> nodes = new ArrayList<Node>();
		Node s = new Node ("S");
		Node uno = new Node ("1");
		Node dos = new Node ("2");
		Node tres = new Node ("3");
		Node cuatro = new Node ("4");
		Node cinco = new Node ("5");
		Node seis = new Node ("6");
		Node t = new Node ("T");
		nodes.add(s);
		nodes.add(uno);
		nodes.add(dos);
		nodes.add(tres);
		nodes.add(cuatro);
		nodes.add(cinco);
		nodes.add(seis);
		nodes.add(t);
		
		ArrayList<Edge> edges = new ArrayList<Edge>();
		Edge a = new Edge("a", s, uno, 2);
		Edge b = new Edge("b", s, cinco, 1);
		Edge c = new Edge("c", uno, dos, 2);
		Edge d = new Edge("d", uno, tres, 2);
		Edge e = new Edge("e", uno, cuatro, 4);
		Edge f = new Edge("f", tres, cuatro, 4);
		Edge g = new Edge("g", tres, cinco, 3);
		Edge h = new Edge("h", cinco, seis, 5);
		Edge i = new Edge("i", dos, cuatro, 3);
		Edge j = new Edge("j", dos, t, 1);
		Edge k = new Edge("k", cuatro, seis, 7);
		Edge l = new Edge("l", seis, t, 6);
		edges.add(a);
		edges.add(b);
		edges.add(c);
		edges.add(d);
		edges.add(e);
		edges.add(f);
		edges.add(g);
		edges.add(h);
		edges.add(i);
		edges.add(j);
		edges.add(k);
		edges.add(l);

		res = new Graph ("Grafo1", false, false, nodes, edges);
		return res;
	}

}
