package eip.fileintegration.mom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ernestoexposito
 */
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

public class TopicProducerCLI {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) {
        // creation of a connection factory using your docker RabbitMQ container
        Connection connection = null;
        Channel channel = null;
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            // creation of one connection and one channel
            connection = factory.newConnection();
            channel = connection.createChannel();
            // the channel will be using a topic named "topic_logs"
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            // you need to provide a name for your producer, the routing key topic to be used for the publication and the message
             if (argv.length < 1) {
                System.err.println("Usage: TopicProducerCLI"+
                    " topic-routing-key message");
                System.exit(1);
            }
            String routingKey = argv[0];
            String message = argv[1];
            // the message is published to the topics_logs topic using the routing key
            channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception ignore) {
                }
            }
        }
    }
}