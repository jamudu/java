//

package sockets;

/*
 * Javier Abell�n. 27 de noviembre de 2003
 *
 * SocketCliente.java
 *
 */
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class SocketCliente {

    public SocketCliente() {
        int entrada=0;
        do {
            try {
                // Se crea un socket cliente.
                //Socket socket = new Socket("192.168.21.96", 35557);   //david casanovas
                Socket socket = new Socket("localhost", 35557);
                System.out.println("Conectado");

            // Se prepara un flujo de salida de objetos y se le envía el objeto
                // al servidor.
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                System.out.print("Introduce numero apuesta: ");
                Scanner scan = new Scanner(System.in);
                entrada=scan.nextInt();
//                DatoSocket.fromByteArray()
                oos.writeObject(new DatoSocket(entrada, "jaume"));

                // Se obtiene un flujo de lectura de objetos.
                ObjectInputStream bufferObjetos = new ObjectInputStream(socket.getInputStream());
                // Se lee un DatoSocket enviado por el servidor y se muestra por pantalla.
                DatoSocket dato = (DatoSocket) bufferObjetos.readObject();
                System.out.println(dato);
                if (dato.isAcertado()){
                    System.out.println("\n\n-------------------------\n"
                            +"ENHORABUENA, HAS ACERTADO\n"
                            + "-------------------------\n");
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } while (entrada>=0);
    }

    public static void main(String[] args) {
        new SocketCliente();
    }
}
