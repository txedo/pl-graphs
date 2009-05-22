
package utilidades;
import java.io.File;
import dominio.*;
import interfaz.GraphSView;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Result {

    /*Esta clase se encargara de mostrar el resultado. Utilizamos un patron
     *singleton para evitar que se cree mas de una instancia de la misma. Actuar�
     *como un controlador del modelo vista-controlador, recibiendo la lista de
     *automatas que debe mostrar como resultado, generando su salida con graphviz
     *y mostrandola mediante html*/

    private String dotUbication = "dot";
    private static Result INSTANCE = null;
    private static int grafosCreados = 0;
    private static String messages = new String("");

    // Private constructor suppresses

    private Result(String dotUbication) {
        this.dotUbication = dotUbication;
    }



    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instantiaci�n m�ltiple

    private synchronized static void createInstance(String dotUbication) {
        if (INSTANCE == null) {
            INSTANCE = new Result(dotUbication);
        }
    }

    public static Result getInstance(String dotUbication) {
        if (INSTANCE == null) createInstance(dotUbication);
        return INSTANCE;
    }

    private Result() {
        this.dotUbication = dotUbication;
    }


    // creador sincronizado para protegerse de posibles problemas  multi-hilo
    // otra prueba para evitar instantiaci�n m�ltiple

    private synchronized static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Result();
        }
    }

    public static Result getInstance() {
        grafosCreados = 0;
        if (INSTANCE == null) createInstance();
        return INSTANCE;
    }

    public int getGrafosCreados() {
        return grafosCreados;
    }

    public void addmsg(String msg) {
        messages += msg;
    }

    public static String getMessages() {
        return messages;
    }

    public static void clearMessages() {
        messages = new String("");
    }

    private String cerrarHTML() {
        String cabecera = "</body>\n</head>";
        return cabecera;
    }

    private String iniciarHTML() {
        String cabecera = "<html>\n\t<head>\n\t\t<title>GraphS - Analysis report</title>\n\t</head><body>";
        return cabecera;
    }

    public void creaGrafos(ArrayList<Graph> listaGrafos, String title) {
        Graph grafo = null;
        GraphViz gv = null;
        String archivo = new String("");
        archivo = iniciarHTML();
        java.io.File prueba = null;
        java.io.File resultado = null;
        archivo += "<br><H1>Compiled file: " + title + "</H1>\n";
        for (int i=0;i<listaGrafos.size();i++) {
            grafo = listaGrafos.get(i);
            gv = new GraphViz(dotUbication);
            if (grafo.isDirected()) gv.addln(gv.start_digraph(grafo.getName()));
            else gv.addln(gv.start_graph(grafo.getName()));
            gv.addln("node [shape=circle, style=filled, fillcolor=grey90]");
            gv.addln("rankdir=LR");
            for (Edge e : grafo.getEdges()) {
                if (e.getWeight() == 0) {
                    if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=" + e.getName() + "];");
                    else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=" + e.getName() + "];");
                }
                else {
                    if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=\"" + e.getName() + "=" + e.getWeight() + "\"];");
                    else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=\"" + e.getName() + "=" + e.getWeight() + "\"];");
                }
            }
            gv.addln(gv.end_graph());
            prueba = new java.io.File("reports/" + grafo.getName() + ".png");
            archivo += "<p align=\"center\"><b> Grafo: "+ grafo.getName() +"</b> </p> <div align=\"center\"> <img src=\""+ prueba.getName() + "\"></img></div>\n\n";
            gv.writeGraphToFile(gv.getGraph(gv.getDotSource()),prueba);
            // mensajes de error y warnings
            addmsg(gv.getMessages());
            gv.clearMessages();

            for (Operation o : grafo.getOperations()) {
                gv = new GraphViz(dotUbication);
                Graph aux = null;
                if (o.getOperation().equals("shortestPath"))
                    aux = grafo.Floyd((Node)o.getParams().get(0), (Node)o.getParams().get(1));
                else if (o.getOperation().equals("minimumSpanningTree"))
                    aux = grafo.Kruskal();
                if (aux.isDirected()) gv.addln(gv.start_digraph(aux.getName()));
                else gv.addln(gv.start_graph(aux.getName()));

                gv.addln("rankdir=LR");
                gv.addln("node [shape=circle, style=filled, fillcolor=grey90]");
                for (Node n : aux.getNodes()) {
                    gv.addln(n.getName() + " [color=red, fillcolor=papayawhip]");
                }
                for (Edge e : grafo.getEdges()) {
                    if (aux.getEdges().contains((Edge)e)) {
                        if (e.getWeight() == 0) {
                            if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=" + e.getName() + ", color=red];");
                            else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=" + e.getName() + ", color=red];");
                        }
                        else {
                            if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=\"" + e.getName() + "=" + e.getWeight() + "\", color=red];");
                            else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=\"" + e.getName() + "=" + e.getWeight() + "\", color=red];");
                        }
                    }
                    else {
                        if (e.getWeight() == 0) {
                            if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=" + e.getName() + "];");
                            else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=" + e.getName() + "];");
                        }
                        else {
                            if (grafo.isDirected()) gv.addln(e.getFrom().getName() + " -> " + e.getTo().getName() + " [label=\"" + e.getName() + "=" + e.getWeight() + "\"];");
                            else gv.addln(e.getFrom().getName() + " -- " + e.getTo().getName() + " [label=\"" + e.getName() + "=" + e.getWeight() + "\"];");
                        }
                    }
                }
                gv.addln(gv.end_graph());
                prueba = new java.io.File("reports/" + aux.getName() + ".png");
                archivo += "<p align=\"center\"><b> Grafo: "+ aux.getName() +"</b> </p> <div align=\"center\"> <img src=\""+ prueba.getName() + "\"></img> </div>\n\n";
                gv.writeGraphToFile(gv.getGraph(gv.getDotSource()),prueba);
                grafosCreados++;
                // mensajes de error y warnings
                addmsg(gv.getMessages());
                gv.clearMessages();
            }
            grafosCreados++;
        }
        archivo += ponerFirma();
        archivo += cerrarHTML();
        resultado = new java.io.File(System.getProperty("user.dir")+"/reports/" + title + ".html");


        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(resultado));
            bw.write(archivo);
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(GraphSView.class.getName()).log(Level.SEVERE, null, ex);
        }
        abrirURL("file:"+System.getProperty("user.dir")+"/reports/" + title + ".html");

    }
    
    public void abrirURL(String url) {

        String nombreSO = System.getProperty("os.name");

        try {
            if (nombreSO.startsWith("Windows"))
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            else{
                //se asume  Unix or Linux
                String[] navegadores = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
                String navegador = null;
                for (int contador = 0; contador < navegadores.length && navegador == null; contador++){
                    if (Runtime.getRuntime().exec( new String[] {"which", navegadores[contador]}).waitFor() == 0)
                        navegador = navegadores[contador];
                }

                if (navegador == null) throw new Exception("No se encuentra navegador web");
                else
                    Runtime.getRuntime().exec(new String[] {navegador, url});
                }
        } catch (Exception ex) {
            Logger.getLogger(GraphSView.class.getName()).log(Level.SEVERE, null, ex + "Error al intentar lanzar el navegador web");
        }
    }

    public String ponerFirma() {
        String res = "";
        res = "\n\n<h3>" +
                "<i><font color=black size=+2>GraphS</font> - Yet Another Graph Specification Language</i>\n\n" +
                "Creado por:\n" +
                "Jose Domingo L&oacute;pez L&oacute;pez\n" +
                "&Aacute;ngel Escribano Santamarina\n\n";

        return (res.toString()).replaceAll("\n", "<br>");
    }
    
    
}

