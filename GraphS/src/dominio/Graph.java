import java.util.ArrayList;


public class Graph {
	String name;
	boolean weighted;
	boolean directed;
	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
	
	public Graph (String na, boolean w, boolean d, ArrayList<Node> n, ArrayList<Edge> e) {
		name = na;
		weighted = w;
		directed = d;
		nodes = n;
		edges = e;
	}
	
	public String toString(){
		String res = "";
		
		res += name + "\n" + "valorado: " + weighted + "\n" + "dirigido: " + directed + "\n";
		for (Node n: nodes) {
			res += n.toString() + "\n";
		}
		for (Edge e: edges) {
			res += e.toString() + "\n";
		}
		
		return res;
	}
	
	public Edge getEdge (Node source, Node target) {
		Edge e = new Edge ("", source, target, 0);
		int index = edges.indexOf(e);

		return edges.get(index);
	}
	
	public Graph Kruskal () {
		Graph res = null;
		
		Kruskal kru = new Kruskal();
		res = kru.getMST(this);
		
		return res;
	}
	
	public Graph Floyd (Node source, Node target) {
		Graph res = null;
		
		Floyd flo = new Floyd();
		flo.calcShortestPaths(this);
		res = flo.getShortestPath(this, source, target);
		
		return res;
	}
	
	public static Graph Union (Graph graph1, Graph graph2, Node source, Node target, Edge ed) {
		Graph res = null;
		String union_name = graph1.name + "_" + graph2.name;
		boolean weighted = false;
		if (graph1.weighted && graph2.weighted) weighted = true;
		boolean directed = false;
		if (graph1.directed && graph2.directed) directed = true;
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (Node n: graph1.nodes) {
			nodes.add(new Node(n.name + "_" + graph1.name));
		}
		for (Node n: graph2.nodes) {
			nodes.add(new Node(n.name + "_" + graph2.name));
		}
		for (Edge e: graph1.edges) {
			edges.add(new Edge(e.name + "_" + graph1.name, new Node(e.from.name + "_" + graph1.name), new Node(e.to.name + "_" + graph1.name), e.weight));
		}
		for (Edge e: graph2.edges) {
			edges.add(new Edge(e.name + "_" + graph2.name, new Node(e.from.name + "_" + graph2.name), new Node(e.to.name + "_" + graph2.name), e.weight));
		}
		// Metemos la arista que une los dos grafos
		edges.add(new Edge(ed.name + "_" + union_name, new Node(source.name + "_" + graph1.name), new Node(target.name + "_" + graph2.name), ed.weight));
		res = new Graph (union_name, weighted, directed, nodes, edges);
		return res;
	}
}
