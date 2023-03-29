package rmihola;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */

    public class Operaciones extends UnicastRemoteObject implements IOperaciones {

    public Operaciones() throws RemoteException {
        super();
    }

    
    public String sumatoria (String n) throws RemoteException {
        
        
        return "hola mundo";
    }
    public String factorial(String n) throws RemoteException{
    return "";
    }
    public String fibonacci(String n) throws RemoteException{
    return"";
    }

}
