/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

/*
 * Javier Abell�n. 19 de noviembre de 2003
 *
 * SocketServidor.java
 * Ejemplo de un socket servidor m�nimo en java.
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class SocketServidor {    
    private int contador;
    private int aleatorio;
    
    public SocketServidor() {
        // Número de petición incremental.
        contador = 0;
        // Número aleatorio que tendrán que adivinar los clientes.
        aleatorio = new Random().nextInt(11); 
        
        try {
            // Se crea un socket servidor atendiendo a un determinado puerto
            // (por ejemplo, el 35557).
            ServerSocket socket = new ServerSocket(35557);
            
            // Se acepata una conexión con un cliente. Esta llamada se queda bloqueada
            // hasta que se arranque el cliente.
            while (true) {
                System.out.println("Número Aleatorio --> " + aleatorio);
                System.out.println("Esperando cliente...");
                Socket cliente = socket.accept();                
                System.out.println("Conectado con cliente de " + cliente.getInetAddress());
                System.out.println("Petición --> " + ++contador + "\n");
                
                // Se prepara un flujo de entrada de objetos.
                ObjectInputStream ois = new ObjectInputStream(cliente.getInputStream());
                DatoSocket objetoCliente = (DatoSocket) ois.readObject();
                
                // Se hace que el cierre del socket sea "gracioso". Esta llamada sólo
                // es necesaria si cerramos el socket inmediatamente después de
                // enviar los datos (como en este caso).
                // setSoLinger() a true hace que el cierre del socket espere a que
                // el cliente lea los datos, hasta un máximo de 10 segundos de espera.
                // Si no ponemos esto, el socket se cierra inmediatamente y si el 
                // cliente no ha tenido tiempo de leerlos, los datos se pierden.
                cliente.setSoLinger(true, 10);
                
                // Se prepara un flujo de salida para objetos y un objeto para enviar.
                ObjectOutputStream bufferObjetos = new ObjectOutputStream(cliente.getOutputStream());
                DatoSocket objetoServidor = new DatoSocket(objetoCliente.getNumero(), objetoCliente.getNombre());
                if (objetoCliente.getNumero() == aleatorio){
                    objetoServidor.setAcertado(true);
                    aleatorio = new Random().nextInt(11); 
                }else{
                    objetoServidor.setAcertado(false);
                }
                bufferObjetos.writeObject(objetoServidor);            
                // Se cierra el socket con el cliente.
                cliente.close();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new SocketServidor();
    }
}


// Se prepara un flujo de salida para objetos y un objeto para enviar.
// ObjectOutputStream bufferObjetos = new ObjectOutputStream(cliente.getOutputStream());

// Se envía el objeto.
// DatoSocket objetoServidor = new DatoSocket(objetoCliente.getNombre(), objetoCliente.getNumero());
// bufferObjetos.writeObject(objetoServidor);


// Se prepara un flujo de salida de datos simples.
// DataOutputStream buffer = new DataOutputStream(cliente.getOutputStream());
                
// Se envía un mensaje al cliente informándolo de si ha o no ha
// adivinado el número aleatorio.
// boolean acertado = false;
// if (objetoCliente.getNumero() == aleatorio)
//      buffer.writeUTF(objetoCliente.getNombre() + ", HAS ACERTADO.");
// else
//      buffer.writeUTF(objetoCliente.getNombre() + ", NO HAS ACERTADO.");
