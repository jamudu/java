/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author usu21
 */
public class Factura implements Serializable{
    
    private int numero;
    private Date fecha;
    private Cliente cliente;
    private Producto producto;
    private int cantidad;

    public Factura() {
//        this (0, new Date(), new Cliente(), new Producto(), 0);     opcio 2: es crida el constructor complet
        fecha=new Date();
        cliente=new Cliente();
        producto=new Producto();
    }

    public Factura(int numero, Date fecha, Cliente cliente, Producto producto, int cantidad) {
        this.numero = numero;
        this.fecha = fecha;
        this.cliente = cliente;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public double total(){
        return cantidad*producto.getPvp();
    }
    
    public static final String PROP_CANTIDAD = "cantidad";

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        int oldCantidad = this.cantidad;
        this.cantidad = cantidad;
        propertyChangeSupport.firePropertyChange(PROP_CANTIDAD, oldCantidad, cantidad);
    }

    public static final String PROP_PRODUCTO = "producto";

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        Producto oldProducto = this.producto;
        this.producto = producto;
        propertyChangeSupport.firePropertyChange(PROP_PRODUCTO, oldProducto, producto);
    }

    public static final String PROP_CLIENTE = "cliente";

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        Cliente oldCliente = this.cliente;
        this.cliente = cliente;
        propertyChangeSupport.firePropertyChange(PROP_CLIENTE, oldCliente, cliente);
    }

    public static final String PROP_FECHA = "fecha";

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        Date oldFecha = this.fecha;
        this.fecha = fecha;
        propertyChangeSupport.firePropertyChange(PROP_FECHA, oldFecha, fecha);
    }

    public static final String PROP_NUMERO = "numero";

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        int oldNumero = this.numero;
        this.numero = numero;
        propertyChangeSupport.firePropertyChange(PROP_NUMERO, oldNumero, numero);
    }

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

}
