//clase lista prendas

package boutique;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jaume
 */
public class ListaPrendas implements Serializable {

    private ArrayList<Prendas> lista;

    public ListaPrendas() {
        lista = new ArrayList<>();
    }

    public boolean existe(Prendas p) {
        return lista.contains(p);
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

    public ArrayList<Prendas> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Prendas> lista) {
        this.lista = lista;
    }
}
