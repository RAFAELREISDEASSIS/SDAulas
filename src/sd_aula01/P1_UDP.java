package sd_aula01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class P1_UDP {
    //Socket + Bind
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        try (DatagramSocket socket = new DatagramSocket(3030)) {
            String msg = "Olá!";
            byte[] buf = msg.getBytes();
            int portDest = 4040;
            InetAddress addrDest = InetAddress.getLocalHost(); //InetAddress.getByName(nome_do_servidor)
            DatagramPacket pack = new DatagramPacket(buf, buf.length, addrDest, portDest);
            
            socket.send(pack);
            socket.close();
        }
    }
    
}
