/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd_aula06;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

  private final static String QUEUE_NAME = "SammuelVilanova";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("reindeer.rmq.cloudamqp.com");
    factory.setUsername("jmodzuaw");
    factory.setPassword("Kwuy7kd81ED1fIj9gxEti1J4FTPBj2Jz");
    factory.setVirtualHost("jmodzuaw");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
      
            String message = "RafaelReis: VSF!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'"); 
      


    channel.close();
    connection.close();
  }
}