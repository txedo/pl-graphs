package dominio;

public class Operacion {


    /*
	public static Grafo minimumSpanningTree(Grafo grafo, Nodo nodo){ //Algoritmo de Prim
        Grafo res = null;
        int[] camino;
		if(grafo.getTipo() == 0){ //Solo se puede realizar para grafos no dirigidos
            res = new Grafo("minimumSpanningTree_"+grafo.getNombre(), 0);
			grafo.crearMatrizAdyacencia();
            try{
                camino = caminoMinimo(grafo.getAdyacencia(), grafo.getNodos().indexOf(nodo));
                res.getNodos().add(grafo.getNodos().elementAt(camino[0]).clone());
                for(int i=1;i<camino.length;i++){
                    if(i<grafo.getAdyacencia().length){
                        res.getNodos().add(grafo.getNodos().elementAt(camino[i]).clone());
                    }
                        
                    }
                    
                }
            }catch(CloneNotSupportedException e){
                System.err.println("CloneNotSupportedException");
            }
            
		}
        return res;
	*/

    
    /**
    * Método que recorre el grafo y almacena el camino mínimo en un vector.
    * @param inicio Valor que representa el nodo donde comienza el recorrido.
    * @return El camino minimo en un vector de enteros.
    */
    /*private static int[] caminoMinimo(int[][] adyacencia, int inicio) {
        int numNodos = adyacencia.length;
        int minimo[] = new int[numNodos];
        
        // Inicializar el vector de mínimos a -1 (para el caso del nodo cero).
        for (int i = 0; i < minimo.length; i++) {
            minimo[i] = -1;
        }
        int longitudCamino = 0;
        int menor = 0;
        int actual = inicio;
        minimo[0] = inicio;
        while (longitudCamino < (numNodos - 1)) {
            // Encontrar el camino mínimo al siguiente nodo
            for (int i = 0; i < numNodos; i++) {
                // Para evitar repetir nodos.
                if ( (adyacencia[actual][i] < adyacencia[actual][menor]) && (!estaRepetido(minimo, i))) {
                    menor = i;
                // Ahora, el nodo siguiente es el del camino mínimo anterior.
                }
            }
            longitudCamino++;
            actual = menor;
            minimo[longitudCamino] = actual;
        }
        return minimo;
    }


    private static boolean estaRepetido(int vector[], int i) {
        for (int j = 0; j < vector.length; j++) {
            if (vector[j] == i) {
            return true;
            }
        }
        return false;
    }*/

    public static TipoDato[][] floyd(int[][] adyacencia){
        int i,j,k;
        TipoDato[][] res= new TipoDato[adyacencia.length][adyacencia.length];
        TipoDato aux;

        System.out.println("floyd");
        for(i=0;i<adyacencia.length;i++){
            for(j=0;j<adyacencia.length;j++){

                System.out.println(i + " " + j + " " + adyacencia[i][j]);
                aux = new TipoDato(adyacencia[i][j], j);
                res[i][j] = aux;
            }
        }

        for(k=0;k<adyacencia.length;k++){
            for(i=0;i<adyacencia.length;i++){
                for(j=0;j<adyacencia.length;j++){
                    if(res[i][j].getDist() > (res[i][k].getDist() + res[k][j].getDist())){
                        res[i][j].setDist(res[i][k].getDist() + res[k][j].getDist());
                        res[i][j].setIntermedio(k);
                    }

                }
            }
        }

        return res;
    }

    /*public static void reconstruirCamino(int origen, int destino, TipoDato[][] dist, Grafo grafo, Grafo res){
        if(dist[origen][destino].getIntermedio() != destino){
            reconstruirCamino(origen, dist[origen][destino].getIntermedio(), dist, grafo, res);
            //Nodo aux1 = grafo.getNodos().elementAt(origen).clone();
            String aux2 = grafo.getNodos().get(dist[origen][destino].getIntermedio());
            //res.getNodos().add(aux1);
            res.getNodos().add(aux2);
            for(int i=0; i<grafo.getArcos().size(); i++){
                if(grafo.getArcos().get(i).getNodoOrigen().equals(grafo.getNodos().get(origen)) && grafo.getArcos().get(i).getNodoDestino().equals(aux2)){
                    System.out.println("Putisima");
                    res.getArcos().add(grafo.getArcos().get(i).clone());
                }
            }
            //System.out.println("->"+ dist[origen][destino].getIntermedio());
            reconstruirCamino(dist[origen][destino].getIntermedio(), destino, dist, grafo, res);
        }
    }*/

    /*public static void reconstruirCamino2(int origen, int destino, TipoDato[][] dist){
        if(dist[origen][destino].getIntermedio() != destino){
            reconstruirCamino(origen, dist[origen][destino].getIntermedio(), dist);
            System.out.println("->"+ dist[origen][destino].getIntermedio());
            reconstruirCamino(dist[origen][destino].getIntermedio(), destino, dist);
        }
    }*/

   public static Grafo reconstruirCamino(Grafo grafo, String origen, String dest, TipoDato[][] dist){
       String destino = dest;
       String nodoaux = null;
       boolean parada = false;
       Grafo res = new Grafo("shortestPath_"+grafo.getNombre(), 1);
       res.getNodos().add(destino);
       while(!origen.equals(nodoaux) && !parada){
           int intermedio = dist[grafo.getNodos().indexOf(origen)][grafo.getNodos().indexOf(destino)].getIntermedio();
           nodoaux = grafo.getNodos().get(intermedio);
           System.out.println("Origen "+origen+" Destino "+destino+" Intermedio "+nodoaux);
           if(destino.equals(nodoaux)){
               parada = true;
               res.getNodos().add(origen);
               res.getArcos().add(grafo.obtenerArista(origen, nodoaux));
           }else{
               res.getNodos().add(nodoaux);
               Arco arcoaux = grafo.obtenerArista(nodoaux, destino).clone();
               res.getArcos().add(arcoaux);
           }
           destino = nodoaux;
       }
       return res;
   }

	public static Grafo shortestPath(Grafo grafo, String origen, String destino){
        Grafo res = null;
        TipoDato[][] dist;

		if(grafo.getTipo() == 1){ //Solo se puede realizar para grafos dirigidos
			grafo.crearMatrizAdyacencia();
            dist = floyd(grafo.getAdyacencia());
            res = reconstruirCamino(grafo, origen, destino, dist);
            
            
		}
        return res;
	}
	
	public static Grafo union(String nombre, Grafo grafo1, Grafo grafo2, String nodo1, String nodo2, Arco arco){
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
			if(!res.getNodos().contains(grafo1.getNodos().get(i))){
				res.getNodos().add(grafo1.getNodos().get(i));
			}
		}
		
		for(int i=0; i<grafo2.getNodos().size(); i++){
			if(!res.getNodos().contains(grafo2.getNodos().get(i))){
				res.getNodos().add(grafo2.getNodos().get(i));
			}
		}
		
		for(int i=0; i<grafo1.getArcos().size(); i++){
			if(!res.getArcos().contains(grafo1.getArcos().get(i))){
				res.getArcos().add(grafo1.getArcos().get(i).clone());
			}
		}
		
		for(int i=0; i<grafo2.getArcos().size(); i++){
			if(!res.getArcos().contains(grafo2.getArcos().get(i))){
				res.getArcos().add(grafo2.getArcos().get(i).clone());
			}
		}
		
        if(res.getArcos().contains(arco)){
            res.getArcos().get(res.getArcos().lastIndexOf(arco)).setNodoOrigen(nodo1);
            res.getArcos().get(res.getArcos().lastIndexOf(arco)).setNodoDestino(nodo2);
        }else{
            arco.setNodoOrigen(nodo1);
            arco.setNodoDestino(nodo2);
            res.getArcos().add(arco);
        }
        
		
		return res;
	}
	
}
