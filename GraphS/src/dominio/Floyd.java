package dominio;

import java.util.ArrayList;
import java.util.Arrays;


public class Floyd {
	/* The Floyd-Warshall algorithm finds the shortest path in a weighted, directed graph for all node pairs in a single execution.
     * http://algowiki.net/wiki/index.php/Floyd-Warshall%27s_algorithm
     * */
	static int[][] D;
	static Node[][] P;

	public void calcShortestPaths(Graph graph) {
		ArrayList<Node> nodes = graph.nodes;
		ArrayList<Edge> edges = graph.edges;
		
		D = initializeWeight(nodes, edges);
		P = new Node[nodes.size()][nodes.size()];

		for(int k=0; k<nodes.size(); k++){
			for(int i=0; i<nodes.size(); i++){
				for(int j=0; j<nodes.size(); j++){
					if(D[i][k] != Integer.MAX_VALUE && D[k][j] != Integer.MAX_VALUE && D[i][k]+D[k][j] < D[i][j]){
						D[i][j] = D[i][k]+D[k][j];
						P[i][j] = nodes.get(k);
					}
				}
			}
		}
	}

	public int getShortestDistance(ArrayList<Node> nodes, Node source, Node target){
		int nSource = nodes.indexOf(source);
		int nTarget = nodes.indexOf(target);
		return D[nSource][nTarget];
	}

	public Graph getShortestPath(Graph graph, Node source, Node target){
		ArrayList<Node> nodes = graph.nodes;
		int nSource = nodes.indexOf(source);
		int nTarget = nodes.indexOf(target);
		Graph res = new Graph (graph.name + "_Floyd", graph.weighted, graph.directed, new ArrayList<Node>(), new ArrayList<Edge>());
		
		if(D[nSource][nTarget] == Integer.MAX_VALUE){
			return new Graph (graph.name + "_Floyd", graph.weighted, graph.directed, new ArrayList<Node>(), new ArrayList<Edge>());
		}
		res.nodes = getIntermediatePath(graph, source, target);
		res.nodes.add(0, source);
		res.nodes.add(target);
		for (int i = 0; i < res.nodes.size()-1; i++) {
			res.edges.add(graph.getEdge(res.nodes.get(i), res.nodes.get(i+1)));
		}
		return res;
	}

	private ArrayList<Node> getIntermediatePath(Graph graph, Node source, Node target){
		ArrayList<Node> nodes = graph.nodes;
		int nSource = nodes.indexOf(source);
		int nTarget = nodes.indexOf(target);
		if(D == null){
			throw new IllegalArgumentException("Must call calcShortestPaths(...) before attempting to obtain a path.");
		}
		if(P[nSource][nTarget] == null){
			return new ArrayList<Node>();
		}
		ArrayList<Node> path = new ArrayList<Node>();
		path.addAll(getIntermediatePath(graph, source, P[nSource][nTarget]));
		path.add(P[nSource][nTarget]);
		path.addAll(getIntermediatePath(graph, P[nSource][nTarget], target));
		return path;
	}

	private int[][] initializeWeight(ArrayList<Node> nodes, ArrayList<Edge> edges){
		int nFrom = -1;
		int nTo = -1;
		int[][] Weight = new int[nodes.size()][nodes.size()];
		for(int i=0; i<nodes.size(); i++){
			Arrays.fill(Weight[i], Integer.MAX_VALUE);
		}
		for(Edge e : edges){
			nFrom = nodes.indexOf(e.from);
			nTo = nodes.indexOf(e.to);
			Weight[nFrom][nTo] = e.weight;
		}
		return Weight;
	}


}
