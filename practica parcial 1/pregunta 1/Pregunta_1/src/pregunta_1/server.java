/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pregunta_1;

import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Asus
 */
public class server {
    public static void main (String args[]) throws IOException {
        
        try {
            int port=6789;
            String resp="";
            DatagramSocket socketUDP = new DatagramSocket(port);
            byte[] bufer = new byte[1000];
            while (true) {
                
                // Construimos el DatagramPacket para recibir peticiones
                DatagramPacket peticion = new DatagramPacket(bufer, bufer.length);
                
                try {
                    // Leemos una petición del DatagramSocket
                    socketUDP.receive(peticion);
                } catch (IOException ex) {
                    java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
                
                System.out.print("Datagrama recibido del host: " +
                        peticion.getAddress());
                System.out.println(" desde enl puerto remoto: " +
                        peticion.getPort());
                int puertoCliente = peticion.getPort();
                InetAddress direccion =peticion.getAddress();
                
                
                String cadena =new String (peticion.getData());
                
                
                int valor=Integer.parseInt(cadena.trim());
                System.out.print("el numero es :" + valor);
                if (valor == 0 || valor == 1 || valor == 4) {
                    resp="el numero NO es primo";
                }
                int contador = 0;
                
                for(int i = 1; i <= valor; i++)
                {
                    if((valor % i) == 0)
                    {
                        contador++;
                    }
                }
                if(contador <= 2)
                {
                    resp="el numero SI es primo";
                    System.out.println("El numero SI es primo");
                }else{
                    resp="el numero NO es primo";
                    System.out.println("El numero NO es primo");
                }
                
                
                
                
                bufer = resp.getBytes();
                
                
                DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length,direccion, puertoCliente);
                
                // Enviamos la respuesta, que es un eco
                socketUDP.send(respuesta);
                
                
                
            }       } catch (SocketException ex) {
            java.util.logging.Logger.getLogger(server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}


