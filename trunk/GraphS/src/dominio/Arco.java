package dominio;

public class Arco implements Cloneable{

	private String arista;
	private int peso;
	private String nodoOrigen;
	private String nodoDestino;

	public Arco(String arista){
		this.arista=arista;
		this.peso=0;
	}
	
	public Arco(String arista, int peso){
		this.arista=arista;
		this.peso=peso;
	}
	
	public Arco(String arista, int peso, String nodoOrigen, String nodoDestino){
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
	
	public String getNodoOrigen(){
		return this.nodoOrigen;
	}
	
	public void setNodoOrigen(String estOrig){
		this.nodoOrigen=estOrig;
	}
	
	public int getPeso(){
		return peso;
	}
	
	public void setPeso(int p){
		this.peso=p;
	}
	
	public String getNodoDestino(){
		return nodoDestino;
	}
	
	public void setNodoDestino(String estDest){
		this.nodoDestino=estDest;
	}
	
	public String toString(){
		String cadena = getArista() + " = " + getNodoOrigen().toString() + " (" + getPeso() + ") " + " -> " + getNodoDestino().toString() + "\n";
		return cadena;
	}

    public boolean equals(Object obj){
		boolean iguales=false;
		if ((obj != null) && (obj instanceof Arco)) {
			Arco aris=(Arco)obj;
			if (getNodoOrigen().equals(aris.getNodoOrigen()) && getNodoDestino().equals(aris.getNodoDestino())){
				iguales=true;
			}
		}
		return iguales;
	}

	/*public boolean equals(Object obj){
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
	}*/
	
    @Override
	public Arco clone(){
		Arco copia = new Arco(this.getArista(), this.getPeso(), this.getNodoOrigen(), this.getNodoDestino());
		return copia;
	}
	
}
