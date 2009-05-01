package dominio;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angel
 */
public class TipoDato {
    private int dist, intermedio;

    public TipoDato(int d, int inter){
        dist = d;
        intermedio = inter;
    }

    public int getDist(){
        return dist;
    }

    public void setDist(int d){
        dist = d;
    }

    public int getIntermedio(){
        return intermedio;
    }

    public void setIntermedio(int i){
        intermedio = i;
    }

}

