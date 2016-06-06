//
package lectura;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lectura {

    public static void main(String[] args) {

        // Fichero del que queremos leer
        File fichero = new File("fichero_leer.txt");
        Scanner s = null;

        int lineas = 0;
        String values[] = null;
        int c1 = 0;
        int c2 = 0;
        //Arrays de primera y segunda columna
        List<Integer> a = new ArrayList<Integer>();
        List<Integer> b = new ArrayList<Integer>();

        try {
            // Leemos el contenido del fichero
            System.out.println("... Leemos el contenido del fichero ...");
            s = new Scanner(fichero);

            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                lineas++;
                String linea = s.nextLine();    // Guardamos la linea en un String
                values = linea.split("\t");
                //System.out.print(values[0]);
                a.add(Integer.parseInt(values[0]));
                b.add(Integer.parseInt(values[1]));
                c1 += Integer.parseInt(values[0]);
                c2 += Integer.parseInt(values[1]);

                System.out.println(linea);      // Imprimimos la linea
            }
            //El maximo de la primera columna
            int maxa = Collections.max(a);
            //El maximo de la segunda columna
            int maxb = Collections.max(b);
            System.out.println("El maximo de la primera columna es: " + maxa);
            System.out.println("El maximo de la segunda columna es: " + maxb);
            System.out.println("La media total de col1 es " + c1 / lineas);
            System.out.println("La media total de col1 es " + c2 / lineas);

        } catch (Exception ex) {
            System.out.println("Excepcion Mensaje 1: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }
}
