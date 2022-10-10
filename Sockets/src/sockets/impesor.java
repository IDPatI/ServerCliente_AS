/*

 */
package sockets;

import java.io.IOException;

/**
 *
 * @author picar
 */
public class impesor extends Thread{
    private SaludarCliente a;
    
    public impesor(SaludarCliente a){
        this.a = a;
        
    }
    @Override
    public void run(){
        while(true){
            try {
                System.out.println(a.in.readLine());
            } catch (IOException ex) {
                break;
            }
        }
    }
    
}
