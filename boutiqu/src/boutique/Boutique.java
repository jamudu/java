//boutique

package boutique;

import utilidades.Fichero;

/**
 *
 * @author jaume
 */
public class Boutique {

    public static Fichero miFichero;
    public static ListaPrendas misPrendas;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        miFichero=new Fichero("boutique.xml");
        misPrendas=(ListaPrendas) miFichero.leer();
        if (misPrendas==null){
            misPrendas=new ListaPrendas();
        }
        MenuPrincipal menu=new MenuPrincipal();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }
}
