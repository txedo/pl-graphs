/*
 * GraphSApp.java
 */

package interfaz;

import java.awt.Dimension;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class GraphSApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    public final int MAXWIDTH = 100;
    public final int MAXHEIGHT = 650;

    @Override protected void startup() {
        Dimension dim = new Dimension();
        dim.height = MAXHEIGHT;
        dim.width = MAXWIDTH;
        GraphSView gv = new GraphSView(this);
        gv.getFrame().setMinimumSize(dim);
        gv.getFrame().setMaximumSize(dim);
        gv.getFrame().setSize(dim);
        gv.getFrame().setResizable(false);
        gv.getFrame().setTitle("GraphS - Untitled");
        show(gv);
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of GraphSApp
     */
    public static GraphSApp getApplication() {
        return Application.getInstance(GraphSApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(GraphSApp.class, args);
    }
    
}
