//clase prendas

package boutique;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author jaume
 */
public class Prendas implements Serializable{
    
    private String codigo;    
    private String descripcion;
    private String color;
    private String talla;
    private double precioCoste;
    private double precioVenta;
    private int stock;

    public Prendas() {
        codigo="";
        descripcion="";
        color="";
        talla="";
    }

    public Prendas(String codigo) {
        this.codigo = codigo;
    }

    public Prendas(String codigo, String descripcion, String color, String talla, double precioCoste, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.color = color;
        this.talla = talla;
        this.precioCoste = precioCoste;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "codigo=" + codigo + " - " + descripcion + ", " + color + ", talla: " + talla + ", stock: " + stock;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.codigo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prendas other = (Prendas) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }

    
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCoste() {
        return precioCoste;
    }
    public void setPrecioCoste(double precioCoste) {
        this.precioCoste = precioCoste;
    }

    public String getTalla() {
        return talla;
    }
    public void setTalla(String talla) {
        this.talla = talla;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
