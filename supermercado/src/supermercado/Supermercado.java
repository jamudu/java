//supermercado

package supermercado;

import modelo.ListaClientes;
import modelo.ListaFacturas;
import modelo.ListaProductos;
import utilidades.Fichero;
import vista.MenuPrincipal;

/**
 *
 * @author usu21
 */
public class Supermercado {
    
    public static Fichero ficheroClientes;
    public static Fichero ficheroProductos;
    public static Fichero ficheroFacturas;
    
    public static ListaClientes clientes;
    public static ListaProductos productos;
    public static ListaFacturas facturas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ficheroClientes = new Fichero ("clientes.xml");
        ficheroProductos = new Fichero ("productos.xml");
        ficheroFacturas = new Fichero ("facturas.xml");
        
        clientes=(ListaClientes) ficheroClientes.leer();
        if (clientes==null){
            clientes=new ListaClientes();
        }
        productos=(ListaProductos) ficheroProductos.leer();
        if (productos==null){
            productos=new ListaProductos();
        }
        facturas=(ListaFacturas) ficheroFacturas.leer();
        if (facturas==null){
            facturas=new ListaFacturas();
        }
        MenuPrincipal menu=new MenuPrincipal();
        menu.setVisible(true);
    }
    
}
