/*

 */
package sockets;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author picar
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       SaludarCliente cliente = new SaludarCliente();
       SaludarCliente cliente2 = new SaludarCliente();
        try {
            cliente.empezaConeccion("192.168.56.1", 6666);
            cliente2.empezaConeccion("148.209.68.92", 6666);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner lector = new Scanner(System.in);
        String linea="";
        while(!linea.equals(".")){
            linea = lector.nextLine();
            System.out.println(cliente.enviar(linea));
        }
//        System.out.println(cliente.enviar("hola server"));
//        System.out.println(cliente2.enviar("hola server2"));
//        System.out.println(cliente.enviar("como estamos hoy"));
//        System.out.println(cliente2.enviar("como estamos hoy2"));
//        System.out.println(cliente.enviar("adios"));
//        System.out.println(cliente.enviar("."));
//        System.out.println(cliente2.enviar("adios2"));
//        System.out.println(cliente2.enviar("."));

//          cliente.prueba("hola server");
//          cliente2.prueba("hola server2");
//          cliente.prueba(".");
//          cliente2 .prueba(".");
          
    }
    
}
