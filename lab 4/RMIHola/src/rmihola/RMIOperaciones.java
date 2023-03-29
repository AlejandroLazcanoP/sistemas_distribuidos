/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rmihola;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class RMIOperaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner sc=new Scanner(System.in);
            System.out.print("Introduzca su nombre");
            String nombre=sc.next();
            IHola hola;
            
            hola = (IHola)Naming.lookup("rmi://localhost/Operaciones"); // instanciar un objeto remoto
            System.out.println(hola.HolaMundo(nombre));
        } catch (RemoteException | NotBoundException | MalformedURLException ex) {
            Logger.getLogger(RMIHola.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
