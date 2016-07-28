package sd_aula01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class P2_UDP {
    public static void main(String[] args) throws SocketException, IOException{
        DatagramSocket socket = new DatagramSocket(4040);
        byte[] buf = new byte[144];
        DatagramPacket pack = new DatagramPacket(buf, buf.length);
        socket.receive(pack); //bloqueante
        String msg = new String(pack.getData());
        int portOr = pack.getPort();
        InetAddress addrOr = pack.getAddress();
        System.out.println("Endereço Remetente: " + addrOr);
        System.out.println("Porta Remetente: " + portOr);
        System.out.println("Mensagem: " + msg);
                
                
    }
    
}
