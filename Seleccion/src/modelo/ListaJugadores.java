//clase para encapsular el ArrayList de Jugador

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.observablecollections.ObservableList;

/**
 *
 * @author usu21
 */
public class ListaJugadores implements Serializable{
    
    private ObservableList<Jugador> lista;

    public ListaJugadores() {
        lista=ObservableCollections.observableList(new ArrayList<Jugador>());
    }

    public void altaJuagador(Jugador j){
        lista.add(j);
    }
    public boolean existeJugador(Jugador j){
        return lista.contains(j);
    }
    public static final String PROP_LISTA = "lista";

    public ObservableList<Jugador> getLista() {
        return lista;
    }

    public void setLista(ObservableList<Jugador> lista) {
        ObservableList<Jugador> oldLista = this.lista;
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

}
