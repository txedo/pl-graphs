package dominio;

import java.util.ArrayList;

public class Programa {
	
	private ArrayList<Grafo> grafos;
	private ArrayList<Nodo> nodosGlobales;
	private ArrayList<Arco> arcosGlobales;
	
	public Programa(ArrayList<Grafo> grafos){
		this.grafos = grafos;
		nodosGlobales = new ArrayList<Nodo>();
		arcosGlobales = new ArrayList<Arco>();
	}
	
	public Programa(ArrayList<Grafo> grafos, ArrayList<Nodo> nodosGlobales, ArrayList<Arco> arcosGlobales){
		this.grafos = grafos;
		this.nodosGlobales = (ArrayList<Nodo>) nodosGlobales.clone();
		this.arcosGlobales = (ArrayList<Arco>) arcosGlobales.clone();
	}
	
	public ArrayList<Grafo> getGrafos(){
		return grafos;
	}
	
	public void setGrafos(ArrayList<Grafo> g){
		this.grafos=g;
	}
	
	public ArrayList<Nodo> getNodosGlobales(){
		return nodosGlobales;
	}
	
	public void setNodosGlobales(ArrayList<Nodo> n){
		this.nodosGlobales=n;
	}
	
	public ArrayList<Arco> getArcosGlobales(){
		return arcosGlobales;
	}
	
	public void setArcosGlobales(ArrayList<Arco> a){
		arcosGlobales=a;
	}
	
	public void nuevoNodoGlobal(Nodo n){
		getNodosGlobales().add(n);
	}
	
	public void nuevoArcoGlobal(Arco a){
		getArcosGlobales().add(a);
	}
	
	public void ejecutarOperaciones(){
		//TODO
	}
	
}
