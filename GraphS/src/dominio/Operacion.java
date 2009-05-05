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

    public static void reconstruirCamino(int origen, int destino, TipoDato[][] dist, Grafo grafo, Grafo res){
        if(dist[origen][destino].getIntermedio() != destino){
            reconstruirCamino(origen, dist[origen][destino].getIntermedio(), dist, grafo, res);
            //Nodo aux1 = grafo.getNodos().elementAt(origen).clone();
            Nodo aux2 = grafo.getNodos().elementAt(dist[origen][destino].getIntermedio()).clone();
            //res.getNodos().add(aux1);
            res.getNodos().add(aux2);
            for(int i=0; i<grafo.getArcos().size(); i++){
                if(grafo.getArcos().elementAt(i).getNodoOrigen().equals(grafo.getNodos().elementAt(origen)) && grafo.getArcos().elementAt(i).getNodoDestino().equals(aux2)){
                    res.getArcos().add(grafo.getArcos().elementAt(i).clone());
                }
            }
            //System.out.println("->"+ dist[origen][destino].getIntermedio());
            reconstruirCamino(dist[origen][destino].getIntermedio(), destino, dist, grafo, res);
        }
    }

    /*public static void reconstruirCamino2(int origen, int destino, TipoDato[][] dist){
        if(dist[origen][destino].getIntermedio() != destino){
            reconstruirCamino(origen, dist[origen][destino].getIntermedio(), dist);
            System.out.println("->"+ dist[origen][destino].getIntermedio());
            reconstruirCamino(dist[origen][destino].getIntermedio(), destino, dist);
        }
    }*/

	public static Grafo shortestPath(Grafo grafo, Nodo origen, Nodo destino){
        Grafo res = null;
        int posOrigen, posDestino, aux;
        TipoDato[][] dist;

		if(grafo.getTipo() == 1){ //Solo se puede realizar para grafos dirigidos
            res = new Grafo("shortestPath_"+grafo.getNombre(), 1);
			grafo.crearMatrizAdyacencia();
            posOrigen = grafo.getNodos().indexOf(origen);
            //System.out.println(" ->" + posOrigen);
            //System.out.println(" ------->>>" + destino.toString());
            posDestino = grafo.getNodos().indexOf(destino);
            //System.out.println(" ->" + posDestino);
            dist = floyd(grafo.getAdyacencia());
            aux = posOrigen;


            /*
            res.getNodos().add(origen.clone());
            while(dist[aux][posDestino].getIntermedio() != posDestino){
                res.getNodos().add(grafo.getNodos().elementAt(dist[aux][posDestino].getIntermedio()).clone());
                boolean encontrado = false;
                for(int i=0; i< grafo.getArcos().size() && !encontrado; i++){
                    if(grafo.getArcos().elementAt(i).getNodoOrigen().equals(grafo.getNodos().elementAt(aux)) && grafo.getArcos().elementAt(i).getNodoDestino().equals(grafo.getNodos().elementAt(dist[aux][posDestino].getIntermedio()))){
                        encontrado = true;
                        res.getArcos().add(grafo.getArcos().elementAt(i).clone());
                    }
                    
                }
                aux = dist[aux][posDestino].getIntermedio();
            }
            res.getNodos().add(grafo.getNodos().elementAt(posDestino).clone());
            boolean encontrado = false;
            for(int i=0; i< grafo.getArcos().size() && !encontrado; i++){
                if(grafo.getArcos().elementAt(i).getNodoOrigen().equals(grafo.getNodos().elementAt(aux)) && grafo.getArcos().elementAt(i).getNodoDestino().equals(grafo.getNodos().elementAt(posDestino))){
                    encontrado = true;
                    res.getArcos().add(grafo.getArcos().elementAt(i).clone());
                }
            }
            if(encontrado == false){
                res.getArcos().add(new Arco(grafo.getNodos().elementAt(aux).toString() + grafo.getNodos().elementAt(posDestino).toString(), 666, res.getNodos().get(res.getNodos().lastIndexOf(origen)), res.getNodos().get(res.getNodos().lastIndexOf(destino))));
            }*/




            
            //System.out.println("origen->"+ posOrigen);
            res.getNodos().add(grafo.getNodos().elementAt(posOrigen).clone());
            reconstruirCamino(posOrigen, posDestino, dist, grafo, res);
            res.getNodos().add(grafo.getNodos().elementAt(posDestino).clone());
            //System.out.println("destino->"+ posDestino);
            
		}
        return res;
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
				res.getNodos().add(grafo1.getNodos().elementAt(i).clone());
			}
		}
		
		for(int i=0; i<grafo2.getNodos().size(); i++){
			if(!res.getNodos().contains(grafo2.getNodos().elementAt(i))){
				res.getNodos().add(grafo2.getNodos().elementAt(i).clone());
			}
		}
		
		for(int i=0; i<grafo1.getArcos().size(); i++){
			if(!res.getArcos().contains(grafo1.getArcos().elementAt(i))){
				res.getArcos().add(grafo1.getArcos().elementAt(i).clone());
			}
		}
		
		for(int i=0; i<grafo2.getArcos().size(); i++){
			if(!res.getArcos().contains(grafo2.getArcos().elementAt(i))){
				res.getArcos().add(grafo2.getArcos().elementAt(i).clone());
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
