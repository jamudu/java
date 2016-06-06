//

package videoclubfichero;

import utilidades.Fichero;

/**
 *
 * @author jaume
 */
public class VideoClubFichero {
    
    public static Fichero miFichero;
    public static ListaPeliculas misPeliculas;
    public static String genero="";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        miFichero=new Fichero("videoclub.xml");
        misPeliculas=(ListaPeliculas) miFichero.leer();
        if (misPeliculas==null){
            misPeliculas=new ListaPeliculas();
        }
        MenuPrincipal menu=new MenuPrincipal();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }
}
