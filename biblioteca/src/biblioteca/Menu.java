/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteca;

import java.util.ArrayList;
import utilidades.EntrdaDatos;
import utilidades.Fichero;

/**
 *
 * @author jaume
 */
public class Menu {

    private ListaLibros misLibros;
    private Fichero miFichero;

    public Menu() {
        miFichero = new Fichero("libros.xml");

        misLibros = (ListaLibros) miFichero.leer();
        if (misLibros == null) {
            misLibros = new ListaLibros();
        }

        int opcion;
//        Libro l = new Libro("1234", "carrie", "stephen king", 288, "terror", 4.95, false);misLibros.altaLibro(l);
//        l = new Libro("2345", "de la tierra a la luna", "julio verne", 304, "aventuras", 11.25, true);misLibros.altaLibro(l);
//        l = new Libro("3456", "cosmos", "carl sagan", 333, "didactico", 32.45, true);misLibros.altaLibro(l);
//        l = new Libro("4567", "el gran libro de catia", "eduardo torrecilla", 696, "didactico", 39.99, false);misLibros.altaLibro(l);
//        l = new Libro("5678", "it (eso)", "stephen king", 1213, "terror", 11.12, false);misLibros.altaLibro(l);
//        l = new Libro("6789", "el hobbit", "j.r.r. tolkien", 360, "aventuras", 14.95, false);misLibros.altaLibro(l);
//        l = new Libro("7890", "jurassic park", "michael crichton", 474, "novela", 17.55, true);misLibros.altaLibro(l);
//        l = new Libro("8901", "el juego de gerald", "stephem king", 456, "terror", 8.55, false);misLibros.altaLibro(l);
//        miFichero.grabar(misLibros);

        do {
            mostrarMenu();
            opcion = (int) EntrdaDatos.demanarNumeroDec("Escoge una opcion: ", "", Double.NEGATIVE_INFINITY, Double.MAX_VALUE, 0);
            System.out.println();
            switch (opcion) {
                case 1:
                    crearLibro();
                    System.out.println("\nLibro dado de alta.");
                    break;
                case 2:
                    consulDatosLibro();
                    break;
                case 3:
                    listLibrosGenero();
                    break;
                case 4:
                    listMasPaginas();
                    break;
                case 5:
                    listTotales();
                    break;
                case 6:
                    System.out.println("Programa finalizado\n");
                    break;
                default:
                    System.out.println("Opcion incorrecta.");
            }
        } while (opcion != 6);
    }

    //funcio totales
    public void listTotales() {
        int enPrestamo = 0;
        double precioTotal = 0;
        if (misLibros.buida()) {
            System.out.println("No disponemos de ningun libro en la biblioteca");
        } else {
            for (int i = 0; i < misLibros.quantitat(); i++) {
                Libro actual = misLibros.obtenerLibro1(i);
                precioTotal += actual.getPrecio();
                if (actual.isEnPrestamo()) {
                    enPrestamo++;
                }
            }
            System.out.println("Libros que la biblioteca tiene en prestamo: " + enPrestamo);
            System.out.println("Total de libros que tiene la biblioteca   : " + misLibros.quantitat());
            System.out.printf("El total de los precios es de             : %.2f euros\n", precioTotal);
        }
    }

    //funcio llistar llibra amb mes pagines
    public void listMasPaginas() {
        if (misLibros.buida()) {
            System.out.println("No disponemos de ningun libro en la biblioteca");
        } else {
            Libro mayor = null;
            mayor = misLibros.obtenerLibro1(0);
            for (int i = 0; i < misLibros.quantitat(); i++) {
                Libro actual = misLibros.obtenerLibro1(i);
                if (actual.getNumPag() > mayor.getNumPag()) {
                    mayor = actual;
                }
            }
            System.out.println("El libro con mas paginas es: '" + EntrdaDatos.mayuscules(mayor.getTitulo(), 0) + "' con " + mayor.getNumPag() + " paginas");
        }
    }

    //funcio llistar llibres d'un genere
    public void listLibrosGenero() {
        boolean cabeceraImprimida = false;
        if (misLibros.buida()) {
            System.out.println("No disponemos de ningun libro en la biblioteca");
        } else {
            boolean existe = false;
            String codigo = EntrdaDatos.demanarCadena("Introduce genero: ", 1, 20);
            for (int i = 0; i < misLibros.quantitat(); i++) {
                Libro actual = misLibros.obtenerLibro1(i);
                if (actual.getGenero().equalsIgnoreCase(codigo)) {
                    cabeceraImprimida = cabecera(cabeceraImprimida);
                    existe = true;
                    System.out.println(actual);
                }
            }
            if (!existe) {
                System.out.println("\nNo disponemos de ningun libro en la biblioteca del genero: " + codigo);
            }
        }
    }

    //funcio imprimir cabecera
    public static boolean cabecera(boolean cabeceraImprimida) {
        if (!cabeceraImprimida) {
            System.out.println("\nCODIGO  TITULO                         AUTOR                GENERO           PAG   PRECIO PRESTADO");
            System.out.println("==================================================================================================");
        }
        return true;
    }

    //funcio consultar datos libro  si se introduce cadena=vacia, se listan todos los libros
    private void consulDatosLibro() {
        String codigo = "";
        Libro l = new Libro();
        if (misLibros.buida()) {
            System.out.println("No disponemos de ningun libro en la biblioteca");
        } else {
            boolean existeix = false;
            codigo = EntrdaDatos.demanarCadena("Introduce codigo del libro a consultar (VACIO = TODOS): ", 0, 6);
            if (codigo.equals("")) {
                cabecera(false);
                for (int i = 0; i < misLibros.quantitat(); i++) {
                    l = misLibros.obtenerLibro1(i);

                    System.out.println(l);
                }
            } else {
                existeix = misLibros.existeLibro(codigo);
                if (existeix) {
                    l = misLibros.obtenerLibro(codigo);
                    cabecera(false);
                    System.out.println(l);
                } else {
                    System.out.println("\nNo disponemos de ningun libro en la biblioteca con el codigo: " + codigo);
                }
            }
        }
    }

    //funcio crear libro
    private void crearLibro() {
        String num = "";
        boolean existe = false;
        do {
            existe = false;
            num = EntrdaDatos.demanarCadena("Introduce codigo libro (de 1 a 6 caracteres): ", 1, 6);
            if (misLibros.existeLibro(num)) {
                System.out.println("El libro " + num + " ja existe\n");
                existe = true;
            }
        } while (existe);
        String titulo = EntrdaDatos.demanarCadena("Introduce el titulo: ", 1, 30).toLowerCase();
        String autor = EntrdaDatos.demanarCadena("Introduce el autor: ", 1, 20).toLowerCase();
        String genero = EntrdaDatos.demanarCadena("Introduce el genero: ", 1, 15).toLowerCase();
        int numPag = (int) EntrdaDatos.demanarNumeroDec("Introduce el numero de paginas: ", "numero de paginas incorrecto\n", 1, 9000, 0);
        double precio = EntrdaDatos.demanarNumeroDec("Introduce el precio: ", "precio incorrecto\n", 0, 900, 1);
        String respuesta = "";
        boolean enPrestamo = false;
        do {
            respuesta = EntrdaDatos.demanarCadena("Esta en prestamo (S/N)?: ", 1, 1);
            enPrestamo = respuesta.equalsIgnoreCase("S");
        } while (!respuesta.equalsIgnoreCase("S") && !respuesta.equalsIgnoreCase("N"));
        Libro l = new Libro(num, titulo, autor, numPag, genero, precio, enPrestamo);
        misLibros.altaLibro(l);
        miFichero.grabar(misLibros);
    }

//funcio menu
    private static void mostrarMenu() {
        System.out.println("\nBIBLIOTECA  'LIBROS PARA CASI TODOS'");
        System.out.println("=====================================");
        System.out.println("1. Nuevo libro");
        System.out.println("2. Consultar datos de un libro");
        System.out.println("3. Listado libros de un genero");
        System.out.println("4. Libro con mayor numero de paginas");
        System.out.println("5. Totales");
        System.out.println("6. Salir\n");
    }
}
