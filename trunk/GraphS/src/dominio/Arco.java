package dominio;

public class Arco implements Cloneable{

	private String arista;
	private int peso;
	private Nodo nodoOrigen;
	private Nodo nodoDestino;

	public Arco(String arista){
		this.arista=arista;
		this.peso=0;
	}
	
	public Arco(String arista, int peso){
		this.arista=arista;
		this.peso=peso;
	}
	
	public Arco(String arista, int peso, Nodo nodoOrigen, Nodo nodoDestino){
		this.arista=arista;
		this.peso=peso;
		this.nodoOrigen=nodoOrigen;
		this.nodoDestino=nodoDestino;
	}
	
	public String getArista(){
		return this.arista;
	}
	
	public void setArista(String a){
		this.arista=a;
	}
	
	public Nodo getNodoOrigen(){
		return this.nodoOrigen;
	}
	
	public void setNodoOrigen(Nodo estOrig){
		this.nodoOrigen=estOrig;
	}
	
	public int getPeso(){
		return peso;
	}
	
	public void setPeso(int p){
		this.peso=p;
	}
	
	public Nodo getNodoDestino(){
		return nodoDestino;
	}
	
	public void setNodoDestino(Nodo estDest){
		this.nodoDestino=estDest;
	}
	
	public String toString(){
		String cadena = getArista() + " = " + getNodoOrigen().toString() + " (" + getPeso() + ") " + " -> " + getNodoDestino().toString() + "\n";
		return cadena;
	}
	
	public boolean equals(Object obj){
		boolean iguales=false;
		if ((obj != null) && (obj instanceof Arco)) {
			iguales=true;
			Arco aris=(Arco)obj;
			if (getArista().equals(aris.getArista())){
				iguales=true;
			}else{
				iguales=false;
			}
			if (getNodoOrigen().equals(aris.getNodoOrigen())){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((getPeso() == aris.getPeso()) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((getNodoDestino().equals(aris.getNodoDestino())) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
		}
		return iguales;
	}
	
	public Arco clone() throws CloneNotSupportedException{
		Arco copia = new Arco(this.getArista(), this.getPeso(), this.getNodoOrigen(), this.getNodoOrigen());
		return copia;
	}
	
}
