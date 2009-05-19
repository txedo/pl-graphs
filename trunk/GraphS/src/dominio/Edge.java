package dominio;


public class Edge implements Comparable<Edge> {

    /* http://algowiki.net/wiki/index.php/Edge */

	String name;
	Node from, to;
	int weight;

	public Edge(String n, int w){
		name = n;
		from = null;
		to = null;
		weight = w;
	}

	public Edge(String n, Node f, Node t, int w){
		name = n;
		from = f;
		to = t;
		weight = w;
	}

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Edge (name, from, to, weight);
    }


}
