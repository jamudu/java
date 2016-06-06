/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escritura;
 
import java.io.FileWriter;
 
public class Escritura {
 
    public static void main(String[] args) {
 
        String[] lineas = { "Uno", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "..." };
 
        /** FORMA 1 DE ESCRITURA **/
        FileWriter fichero = null;
        try {
 
            fichero = new FileWriter("fichero_escritura.txt");
 
            // Escribimos linea a linea en el fichero
            for (String linea : lineas) {
                fichero.write(linea + "\n");
            }
 
            fichero.close();
 
        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
                 
                 
                //Lo volvemos a abrir pero en modo APPEND
                String[] lineas2 = { "Ocho", "Nueve", "Diez", "Once", "Doce", "Trece", "Catorce", "..." };
        try {
 
            fichero = new FileWriter("fichero_escritura.txt", true);
 
            // Escribimos linea a linea en el fichero
            for (String linea : lineas2) {
                fichero.write(linea + "\n");
            }
 
            fichero.close();
 
        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
}