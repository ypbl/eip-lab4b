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
import com.rabbitmq.client.QueueingConsumer;

public class TopicConsumerCLI {

    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] argv) {
        Connection connection = null;
        Channel channel = null;
        try {
            // creation of a connection factory using your docker RabbitMQ container
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            // creation of one connection and one channel
            connection = factory.newConnection();
            channel = connection.createChannel();
            // the channel will be using a topic named "topic_logs"
            channel.exchangeDeclare(EXCHANGE_NAME, "topic");
            String queueName = channel.queueDeclare().getQueue();
            // you need to provide a name for your consumer and at least a topic of interest when launching your programm
            if (argv.length < 1) {
                System.err.println("Usage: TopicConsumerCLI ConsumerDescription topic");
                System.exit(1);
            }
            String consumerDesc=argv[0];
            String bindingKey;
            for (int i=1;i<argv.length;i++) {
                bindingKey = argv[i];
                channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
            }
            // the consumer is created and we are ready to receive messages matching the provided binding key
            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(queueName, true, consumer);
            System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message = new String(delivery.getBody(), "UTF-8");
                String routingKey = delivery.getEnvelope().getRoutingKey();
                // a message is received and printed
                System.out.println(" [x] Received by "+consumerDesc+"-"+ routingKey + "':'" + message + "'");
            }
        } catch (Exception e) {
            System.out.println("Error : "+e);
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
