//clase lista peliculas
package videoclubfichero;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author usu21
 */
public class ListaPeliculas implements Serializable {

    private ArrayList<Pelicula> lista;

    public ListaPeliculas() {
        lista = new ArrayList<>();
    }

    public boolean existe(Pelicula p) {
        return lista.contains(p);
//        for (Pelicula aux: lista){
//            if (p.getCodigo().equalsIgnoreCase(aux.getCodigo())){
//                return true;
//            }
//        }
//        return false;
    }

    public Pelicula favorita() {
        if (lista.isEmpty()) {
            return null;
        } else {
            Pelicula fav = lista.get(0);
            for (Pelicula p : lista) {
                if (p.getValoracion() > fav.getValoracion()) {
                    fav = p;
                }
            }
            return fav;
        }
    }

    public void altaPelicula(Pelicula p) {
        lista.add(p);
    }

    public void borrarPelicula(Pelicula p) {
        lista.remove(p);
    }

    public int cantidad() {
        return lista.size();
    }

    public boolean visto(int posicion) {
        return lista.get(posicion).isVisto();
    }

    public Pelicula obtenerPelicula(int posicion) {
        return lista.get(posicion);
    }

    //obcio B
    public ArrayList<Pelicula> peliculasPorGenero(String genero) {
        ArrayList<Pelicula> pelisPorGenero = new ArrayList<>();
        for (Pelicula p : lista) {
            if (p.getGenero().equalsIgnoreCase(genero)) {
                pelisPorGenero.add(p);
            }
        }
        return pelisPorGenero;
    }

    public ListaPeliculas peliculasPorGenero1(String genero) {
        ListaPeliculas porGenero = new ListaPeliculas();
        for (Pelicula p : lista) {
            if (p.getGenero().equalsIgnoreCase(genero)) {
                porGenero.altaPelicula(p);
            }
        }
        return porGenero;
    }

    public ListaPeliculas generos() {
        boolean existe=false;
        ListaPeliculas gen = new ListaPeliculas();
        for (Pelicula p : lista) {
            existe=false;
            for (int i=0;i<gen.cantidad();i++) {
                Pelicula p1=gen.obtenerPelicula(i);
                if (p1.getGenero().equalsIgnoreCase(p.getGenero())) {
                    existe=true;
                }
            }
            if (!existe) gen.altaPelicula(p);
        }
        return gen;
    }

    public ListaPeliculas peliculasPorVer() {
        ListaPeliculas porVer = new ListaPeliculas();
        for (Pelicula p : lista) {
            if (!p.isVisto()) {
                porVer.altaPelicula(p);
            }
        }
        return porVer;
    }

    public ListaPeliculas peliculasAprobadas() {
        ListaPeliculas aprob = new ListaPeliculas();
        for (Pelicula p : lista) {
            if (p.getValoracion() > 4) {
                aprob.altaPelicula(p);
            }
        }
        return aprob;
    }

    public int numeroPeliculasPorVer() {
        return peliculasPorVer().cantidad();
//        int total=0;
//        for (Pelicula p:lista){
//            if (p.isVisto()==false){
//                total++;
//            }
//        }
//        return total;
    }

    public int totalMinutos() {
        int min = 0;
        for (Pelicula p : lista) {
            min += p.getDuracion();
        }
        return min;
    }

    public Pelicula peliculaPorCodigo(String codigo) {
        for (Pelicula p : lista) {
            if (p.getCodigo().equalsIgnoreCase(codigo));
            return p;
        }
        return null;
    }

    //opcio B
    public Pelicula peliculaPorCodigoOpcionB(String codigo) {
        Pelicula aux = new Pelicula();
        aux.setCodigo(codigo);
        int posicion = lista.indexOf(aux);
        if (posicion == -1) {
            return null;
        } else {
            return lista.get(posicion);
        }
    }

    public ArrayList<Pelicula> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Pelicula> lista) {
        this.lista = lista;
    }
}
