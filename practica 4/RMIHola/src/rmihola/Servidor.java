/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmihola;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class Servidor {
     public static void main(String[] args) {
         try {
             Operaciones saludo=new Operaciones();
             LocateRegistry.createRegistry(1099); //levantar el servidor de registro;
             Naming.bind("Saludo",saludo);
         } catch (AlreadyBoundException | MalformedURLException | RemoteException ex) {
             Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
