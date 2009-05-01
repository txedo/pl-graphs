/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graphs;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author TxEdO
 */
class FiltreSimple extends FileFilter{
   // descripción y extensión aceptada pr el filto
   private String description;
   private String extension;

   // contructor a partir de la descripvión y la extensión aceptada
   public FiltreSimple(String description, String extension){
      if(description == null || extension ==null){
         throw new NullPointerException("La descripción (o extensión) no pueden ser null.");
      }
      this.description = description;
      this.extension = extension;
   }

   // Implementación del FileFilter
   public boolean accept(File file){
      if(file.isDirectory()) {
         return true;
      }
      String nombreFichero = file.getName().toLowerCase();
      return nombreFichero.endsWith(extension);
   }
   public String getDescription(){
      return description;
   }
}

