package dominio;

public class Operacion {

	public static void minimumSpanningTree(Grafo grafo, Nodo nodo){ //Algoritmo de Prim
		if(grafo.getTipo() == 0){ //Solo se puede realizar para grafos no dirigidos
			
		}
	}
	
	public static void shortestPath(Grafo grafo, Nodo nodo1, Nodo nodo2){
		if(grafo.getTipo() == 1){ //Solo se puede realizar para grafos dirigidos
			
		}
	}
	
	public static Grafo union(String nombre, Grafo grafo1, Grafo grafo2, Nodo nodo1, Nodo nodo2, Arco arco){
		Grafo res = null;
		
		if(grafo1.getTipo() == 1 && grafo2.getTipo() == 1){
			res = new Grafo(nombre, 1);
		}else{
			if(grafo1.getTipo() == 0 && grafo2.getTipo() == 0){
				res = new Grafo(nombre, 0);
			}else{
				System.err.println("Error");
			}
		}
		
		for(int i=0; i<grafo1.getNodos().size(); i++){
			if(!res.getNodos().contains(grafo1.getNodos().elementAt(i))){
				res.getNodos().add(grafo1.getNodos().elementAt(i));
			}
		}
		
		for(int i=0; i<grafo2.getNodos().size(); i++){
			if(!res.getNodos().contains(grafo2.getNodos().elementAt(i))){
				res.getNodos().add(grafo2.getNodos().elementAt(i));
			}
		}
		
		for(int i=0; i<grafo1.getArcos().size(); i++){
			if(!res.getArcos().contains(grafo1.getArcos().elementAt(i))){
				res.getArcos().add(grafo1.getArcos().elementAt(i));
			}
		}
		
		for(int i=0; i<grafo2.getArcos().size(); i++){
			if(!res.getArcos().contains(grafo2.getArcos().elementAt(i))){
				res.getArcos().add(grafo2.getArcos().elementAt(i));
			}
		}
		
		res.getArcos().get(res.getArcos().lastIndexOf(arco)).setNodoOrigen(nodo1);
		res.getArcos().get(res.getArcos().lastIndexOf(arco)).setNodoDestino(nodo2);
		
		return res;
	}
	
}
