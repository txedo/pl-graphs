package dominio;

public class Node implements Comparable<Node> {

	String name;
	boolean visited = false;   // used for Kosaraju's algorithm and Edmonds's algorithm
	int lowlink = -1;          // used for Tarjan's algorithm
	int index = -1;            // used for Tarjan's algorithm
	
	Node(String n){
		name = n;
	}
	
	public boolean equals (Object ob) {
		boolean equals = false;
		if ((ob != null) && (ob instanceof Node)) {
			Node n = (Node)ob;
			if (n.name == name) {
				equals = true;
			}
		}
		return equals;
	}

	public int compareTo(Node n){
		if(n == this)
			return 0;
		return -1;
	}
	
	public String toString(){
		String res = "";
		res += name;
		return res;
	}
}
