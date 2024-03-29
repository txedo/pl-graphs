package dominio;

import java.util.ArrayList;


public class Graph {
	String name;
	boolean weighted;
	boolean directed;
	ArrayList<Node> nodes;
	ArrayList<Edge> edges;
    ArrayList<Operation> operations;
	
	public Graph (String na, boolean w, boolean d, ArrayList<Node> n, ArrayList<Edge> e) {
		name = na;
		weighted = w;
		directed = d;
		nodes = n;
		edges = e;
        operations = null;
	}

    public Graph (String na, boolean w, boolean d, ArrayList<Node> n, ArrayList<Edge> e, ArrayList<Operation> op) {
		name = na;
		weighted = w;
		directed = d;
		nodes = n;
		edges = e;
        operations = op;
	}

    public String getName() {
        return name;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public boolean isDirected() {
        return directed;
    }

    public boolean isWeighted() {
        return weighted;
    }
    
    public ArrayList<Operation> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<Operation> operations) {
        this.operations = operations;
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

    public boolean hasNode (String id) {
        boolean exists = false;

        Node n = new Node (id);
        int index = nodes.indexOf(n);
        if (index != -1) exists = true;

        return exists;
    }

    public Node getNode (String id) {
        Node n = new Node (id);
        int index = nodes.indexOf(n);

        return nodes.get(index);
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
		String union_name = graph1.name + graph2.name;
		boolean weighted = false;
		if (graph1.weighted && graph2.weighted) weighted = true;
		boolean directed = false;
		if (graph1.directed && graph2.directed) directed = true;
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for (Node n: graph1.nodes) {
			nodes.add(new Node(n.name + graph1.name));
		}
		for (Node n: graph2.nodes) {
			nodes.add(new Node(n.name + graph2.name));
		}
		for (Edge e: graph1.edges) {
			edges.add(new Edge(e.name + graph1.name, new Node(e.from.name + graph1.name), new Node(e.to.name + graph1.name), e.weight));
		}
		for (Edge e: graph2.edges) {
			edges.add(new Edge(e.name + graph2.name, new Node(e.from.name + graph2.name), new Node(e.to.name + graph2.name), e.weight));
		}
		// Metemos la arista que une los dos grafos
		edges.add(new Edge(ed.name + union_name, new Node(source.name + graph1.name), new Node(target.name + graph2.name), ed.weight));
		res = new Graph (union_name, weighted, directed, nodes, edges);
		return res;
	}
}
