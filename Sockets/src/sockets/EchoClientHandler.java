/*

 */
package sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 *
 * @author picar
 */
public class EchoClientHandler extends Thread{
    private Socket clienteSocket;
    private PrintWriter out;
    private BufferedReader in;

    public EchoClientHandler(Socket aceptar) {
        this.clienteSocket = aceptar;
        System.out.println("Conección echa: "+ clienteSocket.getPort());
    }
    
    @Override
    public void run(){
        try {
            out = new PrintWriter(clienteSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
            String mensaje;
            while((mensaje=in.readLine()) != null){
                if(".".equals(mensaje)){
                    out.println("adios cliente" +clienteSocket.getPort());
                    break;
                }else{
                    out.println("Server: "+ mensaje.toUpperCase() +"["+clienteSocket.getPort()+"]");
                }
            }
            out.println("Cerrando...");
            in.close();
            out.close();
            clienteSocket.close();
        } catch (IOException ex) { 
            System.out.println("Echo server: "+ ex.getMessage());
        }    
    }
    
    public String parseMensaje(String mensaje){
        String[] separar = mensaje.split(" ");
        return switch (separar[0]) {
            case "1" -> separar[1].toUpperCase();
            case "2" -> separar[1].toLowerCase();
            default -> separar[0] +": Operación invalida";
        };
    }
    
}
