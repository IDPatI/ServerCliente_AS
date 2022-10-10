/*

 */
package sockets;

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author picar
 */
public class SaludarCliente {
    private Socket clienteSocket;
    private PrintWriter out;
    public BufferedReader in;
    
    public void empezaConeccion(String ip, int port) throws IOException{
        clienteSocket = new Socket(ip, port);
        out =new PrintWriter(clienteSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        //new impesor(this);
    }
    
    public String enviar(String mensaje){
        out.println(mensaje);
        try {
            return in.readLine();
        } catch (IOException ex) {
            return "Sin respuesta: "+ mensaje;
        }
    }
    public void prueba(String mensaje){
        out.println(mensaje);
    }
    
    public void stop(){
        try {
            in.close();
            out.close();
            clienteSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(SaludarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }
    
}
