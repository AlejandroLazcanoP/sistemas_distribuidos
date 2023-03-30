/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package socket_preguntas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServidorTCP {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
 int port = 5000;
        int suma=0;
        int resta=0;
        int multiplicacion=0;
        
        
        String messageOut="";
        String messageIn ="";
        
        String numero_pregunta="";
        String [] lista_suma={"2+2","3+3","4+4"};
        String [] lista_resta={"4-3","5-2","6-4"};
        String [] lista_multi={"5*5","3*3","7*7"};
        
        ArrayList<String> lista_resultados =new ArrayList<String>();
        int [] resul_suma={4,6,8};
        int [] resul_resta={1,3,2};
        int [] resul_multi={25,9,49};
        int buenas=0;
        int malas=0;
        int resul=0;
        ServerSocket server;
        
        try {
            server = new ServerSocket(port);
            System.out.println( "Se inicio el servidor con éxito");
            Socket client;
            PrintStream toClient;
            
            client = server.accept(); //conexion
            toClient = new PrintStream(client.getOutputStream());
            while(true){
                
            while(messageIn != "close" )
            {
               
                toClient.println("envie pregutas/suma/resta/multiplicacion separada por /    o envie respuestas separadas por /"); 
                 
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(client.getInputStream())); // el lector
                messageIn=fromClient.readLine();
                
                String[] conver=messageIn.split("/");
                if("preguntas".equalsIgnoreCase(conver[0])){
                
                
                for(int i=0;i<conver.length;i++)
                {
                    
                if("suma".equalsIgnoreCase(conver[i]))
                {
                 suma++;
                 System.out.println(conver[i]);
                 if(suma>3){
                 toClient.println("error: solo se permiten 3 datos de cada operacion");
                 }
                }
                    
                        
                if("resta".equalsIgnoreCase(conver[i]))
                {
                    resta++;
                    System.out.println(conver[i]);
                    if(resta>3){
                    toClient.println("error: solo se permiten 3 datos de cada operacion");
                    
                    }
                }
                    
                if("multiplicacion".equalsIgnoreCase(conver[i]))
                {
                    multiplicacion++;
                    System.out.println(conver[i]);
                    if(multiplicacion>3){
                      toClient.println("error: solo se permiten 3 datos de cada operacion");   
                      
                    }
                }
                
                    
                }
                //System.out.println( suma);
                
                int i=0;
                int j=0;
                int k=0;
                while(suma-1>=i){
                    
                    //System.out.println( lista_suma[i]);
                    toClient.println(lista_suma[i]);
                    i++;
                    toClient.println("presione enter"); 
                    
                }
                
                
                while(resta-1>=j)
                {
                    
                    //System.out.println( "exito2");
                    //System.out.println( lista_resta[j]);
                    toClient.println(lista_resta[j]);
                    j++;
                }
                
                
           
                while(multiplicacion-1>=k)
                {
                    
                    //System.out.println( lista_multi[k]);
                    toClient.println(lista_multi[k]);
                    k++;
                }
               
                }
                if("respuestas".equalsIgnoreCase(conver[0]))
               {
               //messageIn=fromClient.readLine();
               //String[] respuestas=messageIn.split("/");
                System.out.println( conver.length);
                toClient.println("respuestas buenas");
                for(int n=1;n>=conver.length;n++)
                {
                    System.out.println( "etapa respuestas");
                    resul=Integer.parseInt(conver[n]);
                    for (int m=0;m>=suma;m++ )
                    {
                        if(resul==resul_suma[m])
                            buenas++;
                        else
                            malas++;
                    }
                    for (int m=0;m>=resta;m++ )
                    {
                        if(resul==resul_resta[m])
                            buenas++;
                        else
                            malas++;
                    }
                    for (int m=0;m>=multiplicacion;m++ )
                    {
                        if(resul==resul_multi[m])
                            buenas++;
                        else
                            malas++;
                    }
                    
                }
                
                
               }
            }
            
            
            }
    
            
           

        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(ServidorTCP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
