//

package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author usu21
 */
public class Pelicula {
    
    private String codigo;
    private String titulo;
    private int duracion;
    private String genero;
    private int valoracion;
    private boolean visto;

    public Pelicula() {
        codigo="";
        titulo="";
        genero="";
    }

    public static final String PROP_VISTO = "visto";

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        boolean oldVisto = this.visto;
        this.visto = visto;
        propertyChangeSupport.firePropertyChange(PROP_VISTO, oldVisto, visto);
    }

    public static final String PROP_VALORACION = "valoracion";

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        int oldValoracion = this.valoracion;
        this.valoracion = valoracion;
        propertyChangeSupport.firePropertyChange(PROP_VALORACION, oldValoracion, valoracion);
    }

    public static final String PROP_GENERO = "genero";

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        String oldGenero = this.genero;
        this.genero = genero;
        propertyChangeSupport.firePropertyChange(PROP_GENERO, oldGenero, genero);
    }

    public static final String PROP_DURACION = "duracion";

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        int oldDuracion = this.duracion;
        this.duracion = duracion;
        propertyChangeSupport.firePropertyChange(PROP_DURACION, oldDuracion, duracion);
    }

    public static final String PROP_TITULO = "titulo";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        propertyChangeSupport.firePropertyChange(PROP_TITULO, oldTitulo, titulo);
    }

    public static final String PROP_CODIGO = "codigo";

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        String oldCodigo = this.codigo;
        this.codigo = codigo;
        propertyChangeSupport.firePropertyChange(PROP_CODIGO, oldCodigo, codigo);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
