/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador;

/**
 *
 * @author TxEdO
 */
public class ClaveTS {

    private String identificador;
    private int scope;

    public ClaveTS(String identificador, int scope) {
        this.identificador = identificador;
        this.scope = scope;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o){
        boolean iguales=false;
        if(o instanceof ClaveTS){
            ClaveTS c = (ClaveTS) o;
            if(c.getIdentificador().equals(getIdentificador()) && c.getScope() == getScope()){
                iguales = true;
            }
        }
        return iguales;
    }

    public String toString(){
        return "Identificador: " + getIdentificador() + " scope: " + getScope();
    }

    public int hashCode(){
        int value = -1;
        value = identificador.hashCode() * 10 + scope;
        return value;
    }

}
