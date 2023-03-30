/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package socket_preguntas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
class ClienteTCP {
public static void main(String[] args) {
        {
            Scanner sc=new Scanner(System.in);
            int port = 5000;
            //System.out.println("introduzca un numero");
           // n= sc.nextLine();
            String initMessage="chat iniciado";
            String messageIn="";
            String messageOut="";
            try {
                Socket client = new Socket("127.0.0.1", port);
                PrintStream toServer = new PrintStream(client.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
                while(messageOut != "close" || messageIn != "close"){
                messageIn=fromServer.readLine();
                System.out.println(messageIn);
                
                messageOut=sc.nextLine();
                toServer.println(messageOut);
                }

            } catch (IOException ex) {
                Logger.getLogger(ClienteTCP.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }    
}

