package dominio;

import java.util.ArrayList;


public class AtributosGrafo {

    private ArrayList<String> listaNodos;
    private ArrayList<Arco> listaArcos;

    public AtributosGrafo(){
        listaNodos = new ArrayList<String>();
        listaArcos = new ArrayList<Arco>();
    }

    public ArrayList<String> getListaNodos(){
        return listaNodos;
    }

    public void setListaNodos(ArrayList<String> ln){
        listaNodos = ln;
    }

    public ArrayList<Arco> getListaArcos(){
        return listaArcos;
    }

    public void setListaArcos(ArrayList<Arco> la){
        listaArcos = la;
    }

}
