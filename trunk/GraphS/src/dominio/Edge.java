public class Edge implements Comparable<Edge> {

	String name;
	Node from, to;
	int weight;

	Edge(String n, int w){
		name = n;
		from = null;
		to = null;
		weight = w;
	}
	/*
	Edge(Node f, Node t, int w){
		from = f;
		to = t;
		weight = w;
	}
	*/
	Edge(String n, Node f, Node t, int w){
		name = n;
		from = f;
		to = t;
		weight = w;
	}

	public int compareTo(Edge e){
		return weight - e.weight;
	}

	public boolean equals (Object ob) {
		boolean equals = false;
		if ((ob != null) && (ob instanceof Edge)) {
			Edge e = (Edge)ob;
			if (from.equals(e.from) && to.equals(e.to)){
				equals = true;
			}
		}
		return equals;
	}
	
	public String toString(){
		String res = "";
		res += "Arista " + name + " desde "+from.toString()+" hasta "+to.toString()+" con peso "+weight;
		return res;
	}
}
