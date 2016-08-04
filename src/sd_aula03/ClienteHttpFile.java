/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula03;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Rafael Reis
 */
public class ClienteHttpFile {
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("www.ufs.br", 80);
        
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        
        String msg = "HEAD /IMG_6365_02.jpg HTTP/1.0" 
                   + "\r\n" 
                   + "Host:www.ufs.br" 
                   + "\r\n" 
                   + "\r\n";
        byte[] buf = msg.getBytes();
        os.write(buf);
        
        File file = new File("C:\\Users\\Rafael Reis\\Desktop\\teste\\logo.jpg");
        FileOutputStream fos = new FileOutputStream(file);
        
        byte[] bufR = new byte[1024];
        int size = 0;
        while ((size = is.read(bufR))>0) {
            fos.write(bufR, 0, size);
        }
        fos.close();
    }
}
