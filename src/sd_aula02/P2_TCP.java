/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula02;

import java.io.*;
import java.net.*;

/**
 *
 * @author Rafael Reis
 */
public class P2_TCP {
    public static void main(String args[]) throws IOException{
        ServerSocket ss = new ServerSocket(30000);
        Socket socket = ss.accept();  //bloqueante
        
        InputStream is = socket.getInputStream();
        OutputStream os = socket.getOutputStream();
        
        byte[] buf = new byte[20];
        
        int size = is.read(buf);  //bloqueante
        
        String msg = new String(buf, 0, size);
        System.out.println(msg);        
        
        ///////////////////////////////////////////////////
        
        byte[] buf_resp = new byte[20];
        String msg_resp = new String(buf_resp, 0, size);
        os.write(buf_resp);
        
        ///////////////////////////////////////////////////
        
        socket.close();
    }
}
