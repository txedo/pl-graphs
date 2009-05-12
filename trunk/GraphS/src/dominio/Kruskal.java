package dominio;

import java.util.ArrayList;


public class Kruskal {

	/**
	 * ALGORITMO DE KRUSKAL
	 * ====================
	 * Kruskal's algorithm finds a minimum spanning tree for a connected, weighted, undirected graph. 
	 * 
	 * REFERENCIAS
	 * ===========
	 * http://algowiki.net/wiki/index.php/Kruskal%27s_algorithm
	 * http://algowiki.net/wiki/index.php/Disjoint-set
	 * http://algowiki.net/wiki/index.php/Edge
	 * http://algowiki.net/wiki/index.php/Node
	 */
	
	public Graph getMST(Graph graph){
		Graph res = new Graph (graph.name + "_Kruskal", graph.weighted, graph.directed, graph.nodes, new ArrayList<Edge>());
		ArrayList<Node> nodes = graph.nodes;
		ArrayList<Edge> edges = new ArrayList<Edge>(graph.edges);
		java.util.Collections.sort(edges);
		DisjointSet<Node> nodeset = new DisjointSet<Node>();
		nodeset.createSubsets(nodes);
		for(Edge e : edges){
			if(nodeset.find(e.from) != nodeset.find(e.to)){
				nodeset.merge(nodeset.find(e.from), nodeset.find(e.to));
				res.edges.add(e);
			}
		}
		return res;
	}


}
