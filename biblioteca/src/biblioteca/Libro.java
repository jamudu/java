//clase libro

package biblioteca;

import java.io.Serializable;
import java.util.Objects;
import utilidades.EntrdaDatos;

/**
 *
 * @author jaume
 */
public class Libro implements Serializable{

    public Libro(String codi, String titulo, String autor, int numPag, String genero, double precio, boolean enPrestamo) {
        this.codi = codi;
        this.titulo = titulo;
        this.autor = autor;
        this.numPag = numPag;
        this.genero = genero;
        this.precio = precio;
        this.enPrestamo = enPrestamo;
    }
    public Libro() {
        this.codi = "";
        this.titulo="";
        this.autor="";
        this.genero="";
    }
        
    private String codi;
    private String titulo;
    private String autor;
    private int numPag;
    private String genero;
    private double precio;
    private boolean enPrestamo;

    public boolean isEnPrestamo() {
        return enPrestamo;
    }
    public void setEnPrestamo(boolean enPrestamo) {
        this.enPrestamo = enPrestamo;
    }

    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNumPag() {
        return numPag;
    }
    public void setNumPag(int numPag) {
        this.numPag = numPag;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCodi() {
        return codi;
    }
    public void setCodi(String codi) {
        this.codi = codi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public String toString() {
        String llistat=String.format("%1$-8s",codi);
        llistat+=String.format("%1$-31s",EntrdaDatos.mayuscules(titulo,0));
        llistat+=String.format("%1$-21s",EntrdaDatos.mayuscules(autor,0));
        llistat+=String.format("%1$-15s",EntrdaDatos.mayuscules(genero,0));
        llistat+=String.format("%1$5s",Integer.toString(numPag));
        llistat+=String.format("%1$9s",Double.toString(precio));
        llistat+="    ";
        if (enPrestamo == true) {
            llistat+="SI";
        }else{
            llistat+="NO";
        }
        return llistat;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Libro other = (Libro) obj;
        if (!Objects.equals(this.codi, other.codi)) {
            return false;
        }
        return true;
    }
}