//clase lista prendas

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author jaume
 */
public class ListaPrendas implements Serializable {

    private ObservableList<Prendas> lista;

    public ListaPrendas() {
        lista=ObservableCollections.observableList(new ArrayList<Prendas>());
    }

    public static final String PROP_LISTA = "lista";

    public ObservableList<Prendas> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Prendas> lista) {
        ObservableList<Prendas> oldLista = this.lista;
        this.lista = lista;
        propertyChangeSupport.firePropertyChange(PROP_LISTA, oldLista, lista);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public void altaPrenda(Prendas p) {
        lista.add(p);
    }

    public void bajaPrenda(Prendas p){
        lista.remove(p);
    }
    
    public int cantidad() {
        return lista.size();
    }

    public Prendas prendaPorCodigo(String codigo) {
        for (Prendas p : lista) {
            if (p.getCodigo().equalsIgnoreCase(codigo)) {
                return p;
            }
        }
        return null;
    }
    
    public ArrayList<String> color() {
        ArrayList<String> col = new ArrayList<>();
        for (Prendas p : lista) {
            if (!col.contains(p.getColor())) {
                col.add(p.getColor());
            }
        }
        return col;
    }
    
    public ListaPrendas prendasPorColor(String color) {
        ListaPrendas prendasCol = new ListaPrendas();
        for (Prendas p : lista) {
            if (color.equalsIgnoreCase(p.getColor())) {
                prendasCol.altaPrenda(p);
            }
        }
            return prendasCol;
    }
    
    public double valorCoste(){
        double valorC=0;
        for (Prendas p : lista) {
            valorC+=p.getPrecioCoste()*p.getStock();
        }
        return valorC;
    }
    
    public int totalStock(){
        int stock=0;
        for (Prendas p : lista) {
            stock+=p.getStock();
        }
        return stock;
    }
}
