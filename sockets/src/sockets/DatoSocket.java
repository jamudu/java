/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/*
 * Javier Abell�n. 1 de diciembre de 2003
 *
 * DatoSocket.java
 *
 */

import java.io.*;

/**
 * Dato para enviar por el socket. Sus atributos son simples y una Clase Atributo
 */
public class DatoSocket implements Serializable
 {
//     /** Primer atributo, un int */
//     public int edad = 45;
//     
//     /** Segundo atributo, un String */
//     public String nombre = "DatoSocket.d";

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isAcertado() {
        return acertado;
    }

    public void setAcertado(Boolean acertado) {
        this.acertado = acertado;
    }
//    public Atributo getE() {
//        return e;
//    }
//
//    public void setE(Atributo e) {
//        this.e = e;
//    }
    private int edad;
    private String nombre;    
    private int numero;
    private boolean acertado;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public DatoSocket() {
        this.edad=18;
        this.nombre="jaume";
        this.numero=12;
        this.acertado=false;
    }

    public DatoSocket(int edad, String nombre, int numero, boolean acertado) {
        this.edad = edad;
        this.nombre = nombre;
        this.numero = numero;
        this.acertado = acertado;
    }

    public DatoSocket(int numero, String nombre) {
        this.numero = numero;
        this.nombre = nombre;
    }

    public DatoSocket(int edad, String nombre, int numero) {
        this.edad = edad;
        this.nombre = nombre;
        this.numero = numero;
    }
     
     
     
//     /** Tercer atributo, una clase Serializable */
//     Atributo e = new Atributo();
     
     /** M�todo para devolver un String en el que se represente el valor de
      * todos los atributos. */
     public String toString ()
     {
         String resultado;
         resultado = "Edad: " + edad +
            " -- " + nombre + " -- has acertado?: "+acertado+" ";
         return resultado;
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
         out.writeInt (edad);
         out.writeUTF (nombre);
         out.writeInt (e.a);
         out.writeUTF (e.b);
     }*/
     
     /*
     private void readObject(java.io.ObjectInputStream in)
     throws IOException, ClassNotFoundException
     {
         edad = in.readInt();
         nombre = in.readUTF();
         if (e==null) e = new Atributo();
         e.a = in.readInt();
         e.b = in.readUTF();
     }*/
}