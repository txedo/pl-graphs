package dominio;

import java.util.ArrayList;

public class Operation {
    private String operation;
    private ArrayList<Object> params;

    public Operation(String operation, ArrayList<Object> params) {
        this.operation = operation;
        this.params = params;
    }

    public ArrayList<Object> getParams() {
        return params;
    }

    public void setParams(ArrayList<Object> params) {
        this.params = params;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    
}
