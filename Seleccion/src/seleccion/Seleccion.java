//

package seleccion;

import modelo.ListaEntrenadores;
import modelo.ListaJugadores;
import utilidades.Fichero;
import vista.MenuPrincipal;

/**
 *
 * @author usu21
 */
public class Seleccion {
    
    public static ListaJugadores todosJugadores;
    public static Fichero ficheroJugadores;
    public static ListaEntrenadores todosEntrenadores;
    public static Fichero ficheroEntrenadores;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ficheroJugadores=new Fichero("jugadores");
        todosJugadores=(ListaJugadores) ficheroJugadores.leer();
        if (todosJugadores==null){
            todosJugadores=new ListaJugadores();
        }
        ficheroEntrenadores=new Fichero("entrenadores.xml");
        todosEntrenadores=(ListaEntrenadores) ficheroEntrenadores.leer();
        if (todosEntrenadores==null){
            todosEntrenadores=new ListaEntrenadores();
        }
        MenuPrincipal mp=new MenuPrincipal();
        mp.setVisible(true);
    }
    
}
