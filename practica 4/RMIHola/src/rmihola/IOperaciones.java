package rmihola;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public interface IOperaciones extends Remote {
    
    Operaciones sumatoria(String n)throws RemoteException;
    Operaciones factorial (String n) throws RemoteException;
    Operaciones fibonacci(String n)throws RemoteException;
    
    
    
}

