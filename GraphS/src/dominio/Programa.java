package dominio;

import java.util.Vector;

public class Programa {
	
	private Vector<Grafo> grafos;
	private Vector<Nodo> nodosGlobales;
	private Vector<Arco> arcosGlobales;
	
	public Programa(Vector<Grafo> grafos){
		this.grafos = grafos;
		nodosGlobales = new Vector<Nodo>();
		arcosGlobales = new Vector<Arco>();
	}
	
	public Programa(Vector<Grafo> grafos, Vector<Nodo> nodosGlobales, Vector<Arco> arcosGlobales){
		this.grafos = grafos;
		this.nodosGlobales = (Vector<Nodo>) nodosGlobales.clone();
		this.arcosGlobales = (Vector<Arco>) arcosGlobales.clone();
	}
	
	public Vector<Grafo> getGrafos(){
		return grafos;
	}
	
	public void setGrafos(Vector<Grafo> g){
		this.grafos=g;
	}
	
	public Vector<Nodo> getNodosGlobales(){
		return nodosGlobales;
	}
	
	public void setNodosGlobales(Vector<Nodo> n){
		this.nodosGlobales=n;
	}
	
	public Vector<Arco> getArcosGlobales(){
		return arcosGlobales;
	}
	
	public void setArcosGlobales(Vector<Arco> a){
		arcosGlobales=a;
	}
	
	public void nuevoNodoGlobal(Nodo n){
		getNodosGlobales().add(n);
	}
	
	public void nuevoArcoGlobal(Arco a){
		getArcosGlobales().add(a);
	}
	
	public boolean equals(Object obj){
		boolean iguales=false;
		if ((obj != null) && (obj instanceof Programa)) {
			iguales=true;
			Programa prog=(Programa)obj;
			if (this.getGrafos() == prog.getGrafos()){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((this.getNodosGlobales().equals(prog.getNodosGlobales())) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((this.getArcosGlobales().equals(prog.getArcosGlobales())) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
		}
		
		return iguales;
	}
	
	public String toString(){
		String res;
		res= " Grafos: ";
		for(int i=0; i<getGrafos().size(); i++){
			res+="  " + getGrafos().get(i).toString();
		}
		res+= " Nodos: ";
		for(int i=0; i<getNodosGlobales().size(); i++){
			res+="  " + getNodosGlobales().get(i).toString();
		}
		res+="\n Arcos: ";
		for(int i=0; i<getArcosGlobales().size(); i++){
			res+="  " + getArcosGlobales().get(i).toString();
		}

		res+="\n";
		return res;
	}
	
	public void ejecutarOperaciones(){
		//TODO
	}
	
}
