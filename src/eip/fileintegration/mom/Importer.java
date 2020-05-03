package eip.fileintegration.mom;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ernestoexposito
 */
public class Importer extends Thread {
    
     // the name of the topic to be used to communicate
    private static final String EXCHANGE_NAME = "topic_logs";
    // the routing key to import from France
    public static final String IMPORT_FRANCE = "*.fr";
    // the routing key to import from Spain
    public static final String IMPORT_SPAIN = "*.es";
    // the connection to the broker
    Connection connection = null; 
    // the channel to communicate with the broker
    Channel channel = null;
    // the channel consumer
    QueueingConsumer consumer = null;
    // the consumer appliction in order to add the received products
    private Consumer c=null;
    

   public Importer(Consumer c, String importer) throws Exception {
       
        // the consumer reference is stored
        
        // Create a factory of connections to the MOM
       
        // Specify the address of the MOM server
        
        // Create a new connection to the MOM
       
        // Create a new channel within this connection
        // to consume and to produce messages
        
        // Declare the queue to be used with the parameters:
        // durable:false, exclusive: false, autodelete:false,
        // additional-arguments:null
        
        // a queue consumer is created on the chanel
        
        // the consumer is associated is associate with the queue
        
        this.start();
    }

    @Override
    public void run() {
        
        while (true) {
            
                // receive products from the topic from the specified importer
                
                
                // add the products to the GUI
                
            }
    }

    public void close() {
        try {
            this.interrupt();
            channel.close();
            connection.close();
        } catch (IOException ex) {
            Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TimeoutException ex) {
            Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
}
