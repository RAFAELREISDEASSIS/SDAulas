package sd_aula07;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Chat {
    
    private final static String QUEUE_NAME = "SV";

    public static void main(String[] args) throws IOException, TimeoutException {
     //-----------------CONEXÃO COM SERVIDOR-----------------------------
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("reindeer.rmq.cloudamqp.com");
        factory.setUsername("jmodzuaw");
        factory.setPassword("Kwuy7kd81ED1fIj9gxEti1J4FTPBj2Jz");
        factory.setVirtualHost("jmodzuaw");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

     //-----------------------------RECEIVE------------------------------
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Consumer consumer = new DefaultConsumer(channel) {
        @Override
        public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
          throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("diz: " + message);
            }
        };
        channel.basicConsume(QUEUE_NAME, true, consumer);
        
     //-------------------------SEND-----------------------------
        
            Scanner sc = new Scanner(System.in);
            
            String msg;
            
            System.out.println("USER NAME: " + QUEUE_NAME);
            System.out.print(">");
        do{
            msg = sc.nextLine();
        
            String destinatario = "";
            int iniMsg = 0;
        
            if (msg.charAt(0) == '@') {
                int i = 1;
                while (msg.charAt(i) != ':'){
                    destinatario = destinatario + msg.charAt(i);
                    i++;
                    iniMsg = i+1;
                }
                msg = msg.substring(iniMsg, msg.length());
            }
        
            //System.out.println("Destino: " + destinatario);
            //System.out.println("Mensagem: " + msg);

            //channel.queueDeclare(destinatario, false, false, false, null);
            
//            String message = "Mensagem";
//            channel.basicPublish("", "RafaelReis", null, message.getBytes("UTF-8"));
//            System.out.println(" [x] Sent '" + message + "'");
            
            
            String message = "@" + QUEUE_NAME + msg;
            channel.basicPublish("", destinatario, null, message.getBytes("UTF-8"));
            //System.out.println(" [x] Sent '" + message + "'");
    
        }while(!msg.equals("#SAIR"));
        
            channel.close();
            connection.close();
    }
    
}
