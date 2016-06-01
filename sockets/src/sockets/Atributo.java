/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/**
 *
 * @author usu21
 */
import java.io.*;
/**
 * Clase Serializable para enviar por el socket.
 */
public class Atributo implements Serializable
 {
     /** Primer atributo, un int */
     int a = 3;
     
     /** Segundo atributo, un String */
     String b = "Atributo.d";
     
     /**  M�todo para devolver un String que represente los valores de los
      * atributos */
     public String toString()
     {
         return Integer.toString(a) + " -- " + b;
     }

     /*******
      *
      * LOS SIGUIENTES M�TODOS SON INNECESARIOS SALVO QUE QUERAMOS QUE SE
      * ENVIEN Y RECIBAN LOS DATOS DE FORMA NO STANDARD.
      * Puedes descomentarlos y todo funcionar� exactamente igual
      *
      *******/
     /*
     private void writeObject(java.io.ObjectOutputStream out)
         throws IOException
     {
         out.writeInt (a);
         out.writeUTF (b);
     }*/
     
     /*
     private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException
     {
         a = in.readInt();
         b = in.readUTF();
     }*/
}