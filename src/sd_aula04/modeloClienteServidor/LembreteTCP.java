/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula04.modeloClienteServidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Reis
 */
public class LembreteTCP extends Thread{
    
    private Socket socket;

    public LembreteTCP(Socket socket) {
        this.socket = socket;
    }
    
    public void run(){
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String nome = dis.readUTF();
            int intervalo = dis.readInt();
            int total = dis.readInt();
            
            for (int i = 0; i <= total; i++) {
                dos.writeUTF("Tomar " + nome + " " + i);
                try {
                    Thread.sleep(intervalo*1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(LembreteTCP.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(LembreteTCP.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
