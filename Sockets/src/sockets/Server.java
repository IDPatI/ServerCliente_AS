/*

 */


package sockets;

import java.io.IOException;

/**
 *
 * @author Pat
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServerMultiCliente server  = new ServerMultiCliente();
        try {
            server.start(6666);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
