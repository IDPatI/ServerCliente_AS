/*

 */
package sockets;
import java.net.*;
import java.io.*;
/**
 *
 * @author picar
 */
public class SaludarServer {
    private ServerSocket servidorSocket;
    private Socket clienteSocket;
    
    private PrintWriter out;
    private BufferedReader in;
    
    public void start(int port) throws IOException {
        servidorSocket= new ServerSocket(port);
        clienteSocket = servidorSocket.accept();

        out = new PrintWriter(clienteSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clienteSocket.getInputStream()));
        String mensaje;
        while((mensaje=in.readLine()) != null){
            if(".".equals(mensaje)){
                out.println("adios");
                break;
            }else{
                out.println("Server: "+ mensaje);
            }
        }   
    }
    
    public void stop() throws IOException{
        in.close();
        out.close();
        clienteSocket.close();
        servidorSocket.close();
    }    
}
