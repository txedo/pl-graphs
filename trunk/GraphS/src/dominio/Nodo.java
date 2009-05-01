package dominio;

public class Nodo implements Cloneable{
	
	private String nombre;

	
	public Nodo(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String n){
		nombre = n;
	}
	
	public boolean equals(Object obj){
		boolean iguales=false;
		if ((obj != null) && (obj instanceof Nodo)) {
			iguales=true;
			Nodo nod=(Nodo)obj;
			if (getNombre().equals(nod.getNombre())){
				iguales=true;
			}else{
				iguales=false;
			}
		}
		return iguales;
	}
	
	public String toString(){
		return nombre;
	}
	
	public Nodo clone() throws CloneNotSupportedException{
		Nodo copia = new Nodo(this.getNombre());
		return copia;
	}
	
}
