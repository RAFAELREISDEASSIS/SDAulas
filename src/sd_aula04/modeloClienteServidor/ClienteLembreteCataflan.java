/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula04.modeloClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author Rafael Reis
 */
public class ClienteLembreteCataflan {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("localhost", 44111);
        InputStream is = s.getInputStream();
        OutputStream os = s.getOutputStream();
        
        DataInputStream dis = new DataInputStream(is);
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("Cataflan");
        dos.writeInt(6);
        dos.writeInt(6);
        for (int i = 0; i < 10; i++) {
            System.out.println(dis.readUTF());
        }
    }
}
