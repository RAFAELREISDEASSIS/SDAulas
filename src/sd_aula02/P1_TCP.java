/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula02;

import java.net.Socket;
import java.io.*;

/**
 *
 * @author Rafael Reis
 */
public class P1_TCP {
    public static void main(String args[]) throws IOException{
        Socket socket = new Socket("localhost",30000); //bloqueante
        
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        String msg = "Ola";
        byte[] buf = msg.getBytes();
        os.write(buf);
        
        ///////////////////////////////////////////////////
        
        int size = is.read(buf);  //bloqueante
        msg = new String(buf, 0, size);
        System.out.println(msg); 
        
        ///////////////////////////////////////////////////
        
        socket.close();
    }
}
