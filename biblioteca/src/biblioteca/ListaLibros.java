//
package biblioteca;

import java.io.Serializable;
import java.util.ArrayList;
import utilidades.EntrdaDatos;

/**
 *
 * @author jaume
 */
public class ListaLibros implements Serializable {

    private ArrayList<Libro> lista;

    public ListaLibros() {
        lista = new ArrayList<Libro>();
    }

    public void altaLibro(Libro l) {
        lista.add(l);
    }

    public boolean buida() {
        return lista.isEmpty();
    }
    public int quantitat(){
        return lista.size();
    }
    
    public Libro obtenerLibro1(int posicion){
        return lista.get(posicion);
    } 

    public boolean existeLibro(String codigo) {
        Libro l = new Libro();
        l.setCodi(codigo);
        return lista.contains(l);
    }

    public Libro obtenerLibro(String codigo) {
        Libro l = new Libro();
        l.setCodi(codigo);
        int posicion = lista.indexOf(l);
        System.out.println(posicion);
        Libro encontrado = lista.get(posicion);
        return encontrado;
    }
    
    public ArrayList<Libro> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Libro> lista) {
        this.lista = lista;
    }
}
