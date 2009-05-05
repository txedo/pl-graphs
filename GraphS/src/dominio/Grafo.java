package dominio;
import java.util.ArrayList;

public class Grafo {
	
	private String nombre;
	private int tipo;
	private ArrayList<String> nodos;
	private ArrayList<Arco> arcos;
	private ArrayList<Operacion> operaciones;
    private int[][] adyacencia;
	
	public Grafo(String nombre, int tipo){
		this.nombre=nombre;
		this.tipo=tipo;
		nodos = new ArrayList<String>();
        arcos = new ArrayList<Arco>();
        operaciones = new ArrayList<Operacion>();

	}
	
	public Grafo(String nombre, int tipo, ArrayList<String> nodosGlobales, ArrayList<Arco> arcosGlobales){
		this.nombre=nombre;
		this.tipo=tipo;
		this.nodos.addAll(nodosGlobales);
		this.arcos.addAll(arcosGlobales);
	}
	
	public Grafo(String nombre, int tipo, ArrayList<String> nodos, ArrayList<Arco> arcos, ArrayList<Operacion> operaciones){
		this.nombre=nombre;
		this.tipo=tipo;
		this.nodos=nodos;
		this.arcos=arcos;
		this.operaciones=operaciones;
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

	public ArrayList<String> getNodos(){
		return nodos;
	}
	
	public void setNodos(ArrayList<String> n){
		this.nodos=n;
	}
	
	public ArrayList<Arco> getArcos(){
		return arcos;
	}
	
	public void setArcos(ArrayList<Arco> a){
		arcos=a;
	}

	public ArrayList<Operacion> getOperaciones(){
		return operaciones;
	}
	
	public void setOperaciones(ArrayList<Operacion> op){
		operaciones=op;
	}
	
    public int[][] getAdyacencia(){
		return adyacencia;
	}
	
	public void setAdyacencia(int[][] ad){
		adyacencia=ad;
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
	
	public boolean estaNodo(String nodo){
        return getNodos().contains(nodo);
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
                    if((getArcos().get(i).getNodoOrigen().equals(getNodos().get(j)) && (getArcos().get(i).getNodoDestino().equals(getNodos().get(k))))){
                        adyacencia[j][k] = getArcos().get(i).getPeso();
                    }
                    if((getArcos().get(i).getNodoOrigen().equals(getNodos().get(k)) && (getArcos().get(i).getNodoDestino().equals(getNodos().get(j))))){
                        adyacencia[k][j] = getArcos().get(i).getPeso();
                    }
                }
            }
        }
    }


    public Arco obtenerArista(String origen, String destino){
        Arco res = null;
        Arco aux = new Arco("aux", 0, origen, destino);
        int indice;
        indice = getArcos().indexOf(aux);
        if(indice != -1){
            res = getArcos().get(indice).clone();
        }

        return res;

    }


    
}