package dominio;
import java.util.Vector;

public class Grafo {
	
	private String nombre;
	private int tipo;
	private Vector<Nodo> nodos;
	private Vector<Arco> arcos;
	private Vector<Operacion> operaciones;
    private int[][] adyacencia;
	
	public Grafo(String nombre, int tipo){
		this.nombre=nombre;
		this.tipo=tipo;
		nodos = new Vector<Nodo>();
        arcos = new Vector<Arco>();
        operaciones = new Vector<Operacion>();

	}
	
	public Grafo(String nombre, int tipo, Vector<Nodo> nodosGlobales, Vector<Arco> arcosGlobales){
		this.nombre=nombre;
		this.tipo=tipo;
		this.nodos.addAll(nodosGlobales);
		this.arcos.addAll(arcosGlobales);
	}
	
	public Grafo(String nombre, int tipo, Vector<Nodo> nodos, Vector<Arco> arcos, Vector<Operacion> operaciones){
		this.nombre=nombre;
		this.tipo=tipo;
		this.nodos=nodos;
		this.arcos=arcos;
		this.operaciones=operaciones;
	}
	
	public void nuevoNodo(Nodo n){
		getNodos().add(n);
	}
	
	public void nuevoArco(Arco a){
		getArcos().add(a);
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public void setNombre(String nom){
		nombre=nom;
	}
	
	public int getTipo(){
		return tipo;
	}
	
	public String getStringTipo(){
		String res = "";
		switch(this.tipo){
			case 0:
				res = "No dirigido";
				break;
			case 1:
				res = "Dirigido";
				break;
		}
		return res;
	}
	
	public void setTipo(int tip){
		tipo=tip;
	}

	public Vector<Nodo> getNodos(){
		return nodos;
	}
	
	public void setNodos(Vector<Nodo> n){
		this.nodos=n;
	}
	
	public Vector<Arco> getArcos(){
		return arcos;
	}
	
	public void setArcos(Vector<Arco> a){
		arcos=a;
	}

	public Vector<Operacion> getOperaciones(){
		return operaciones;
	}
	
	public void setOperaciones(Vector<Operacion> op){
		operaciones=op;
	}
	
    public int[][] getAdyacencia(){
		return adyacencia;
	}
	
	public void setAdyacencia(int[][] ad){
		adyacencia=ad;
	}

	public void imprimir(){

		System.out.println("Nombre: " + getNombre().toString() + "\n");
		System.out.println("Tipo: " + getTipo() + "\n");
		System.out.println(" Nodos: ");
		for(int i=0; i<getNodos().size(); i++){
			System.out.print("  " + getNodos().get(i).toString());
		}
		System.out.println("\n Arcos: ");
		for(int i=0; i<getArcos().size(); i++){
			System.out.print("  " + getArcos().get(i).toString());
		}
		System.out.println(" Operaciones: ");
		for(int i=0; i<getOperaciones().size(); i++){
			System.out.print("  " + getOperaciones().get(i).toString());
		}
		System.out.println("\n");
	}
	
	public String toString(){
		String res;
		res = "Nombre: " + getNombre().toString() + "\n";
		res+= "Tipo: " + getStringTipo() + "\n";
		res+= " Nodos: ";
		for(int i=0; i<getNodos().size(); i++){
			res+="  " + getNodos().get(i).toString();
		}
		res+="\n Arcos: ";
		for(int i=0; i<getArcos().size(); i++){
			res+="  " + getArcos().get(i).toString();
		}
		res+=" Operaciones: ";
		for(int i=0; i<getOperaciones().size(); i++){
			res+="  " + getOperaciones().get(i).toString();
		}
		res+="\n";
		return res;
	}
	
	public boolean equals(Object obj){
		boolean iguales=false;
		if ((obj != null) && (obj instanceof Grafo)) {
			iguales=true;
			Grafo aut=(Grafo)obj;
			if (this.getTipo() == aut.getTipo()){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((this.getNodos().equals(aut.getNodos())) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((this.getArcos().equals(aut.getArcos())) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
			if ((this.getOperaciones().equals(aut.getOperaciones())) && (iguales == true)){
				iguales=true;
			}else{
				iguales=false;
			}
		}
		
		
		return iguales;
	}
	
	public boolean estaNodo(Nodo nodo){
		boolean esta = false;
		getNodos().contains(nodo);
		for(int i = 0; i<getNodos().size(); i++){
			if(nodo.equals(getNodos().get(i))){
				esta = true;
			}
		}
		return esta;
	}

    public void crearMatrizAdyacencia(){
        adyacencia = new int[getNodos().size()][getNodos().size()];

        for(int i=0;i<getNodos().size();i++){
            for(int j=0;j<getNodos().size();j++){
                adyacencia[i][j] = 9999;
            }
        }

        for(int i=0;i<getArcos().size();i++){
            for(int j=0;j<getNodos().size();j++){
                for(int k=0;k<getNodos().size();k++){
                    if((getArcos().elementAt(i).getNodoOrigen().equals(getNodos().elementAt(j)) && (getArcos().elementAt(i).getNodoDestino().equals(getNodos().elementAt(k))))){
                        adyacencia[j][k] = getArcos().elementAt(i).getPeso();
                    }
                    if((getArcos().elementAt(i).getNodoOrigen().equals(getNodos().elementAt(k)) && (getArcos().elementAt(i).getNodoDestino().equals(getNodos().elementAt(j))))){
                        adyacencia[k][j] = getArcos().elementAt(i).getPeso();
                    }
                }
            }
        }
        
    }

    
}