/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pregunta_1;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author Asus
 */
public class Practica_parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            int puerto = 6789;
            String dato="8";
            String ip="localhost";
            try (DatagramSocket socketUDP = new DatagramSocket()) {
                byte[] mensaje = dato.getBytes();
                InetAddress hostServidor = null;
                try {
                    hostServidor = InetAddress.getByName(ip);
                } catch (UnknownHostException ex) {
                    java.util.logging.Logger.getLogger(Practica_parcial1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                // Construimos un datagrama para enviar el mensaje al servidor
                DatagramPacket peticion =
                        new DatagramPacket(mensaje, dato.length(), hostServidor,
                                puerto);
                try {
                    // Enviamos el datagrama
                    socketUDP.send(peticion);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Practica_parcial1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                // Construimos el DatagramPacket que contendrÃ¡ la respuesta
                byte[] bufer = new byte[1000];
                DatagramPacket respuesta =
                        new DatagramPacket(bufer, bufer.length);
                try {
                    socketUDP.receive(respuesta);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(Practica_parcial1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                // Enviamos la respuesta del servidor a la salida estandar
                System.out.println("Respuesta: " + new String(respuesta.getData()));
                // Cerramos el socket
            } catch (SocketException ex) {
            java.util.logging.Logger.getLogger(Practica_parcial1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
    }
    
}

