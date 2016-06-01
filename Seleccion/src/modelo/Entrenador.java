//clase entrenador (hereda de persona)

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Entrenador extends Persona{
    
    private String numLicencia;
    private int experiencia;

    public Entrenador() {
        super();
        numLicencia="";
    }

    public static final String PROP_EXPERIENCIA = "experiencia";

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        int oldExperiencia = this.experiencia;
        this.experiencia = experiencia;
        propertyChangeSupport.firePropertyChange(PROP_EXPERIENCIA, oldExperiencia, experiencia);
    }

    public static final String PROP_NUMLICENCIA = "numLicencia";

    public String getNumLicencia() {
        return numLicencia;
    }

    public void setNumLicencia(String numLicencia) {
        String oldNumLicencia = this.numLicencia;
        this.numLicencia = numLicencia;
        propertyChangeSupport.firePropertyChange(PROP_NUMLICENCIA, oldNumLicencia, numLicencia);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
