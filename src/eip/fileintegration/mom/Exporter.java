package eip.fileintegration.mom;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ernestoexposito
 */
public class Exporter {

    // the name of the topic to be used to communicate
    private static final String EXCHANGE_NAME = "topic_logs";
    // the routing key to export to France
    public static final String EXPORT_FRANCE = ".fr";
    // the routing key to export to Spain
    public static final String EXPORT_SPAIN = ".es";
    // the connection to the broker
    Connection connection = null; 
    // the channel to communicate with the broker
    Channel channel = null;
    

    public Exporter() throws Exception {
        // Create a factory of connections to the MOM
        
        // Specify the address of the MOM server
        
        // Create a new connection to the MOM
        
        // Create a new channel within this connection
        // to consume and to produce messages
        
        // Declare the exchange of topic type
        // channel.exchangeDeclare(EXCHANGE_NAME, "topic");
       
    }

    public void exportObject(Product p, String export)  {
        
        // send a String representation of the product to the Queue
        try {
            // channel.basicPublish(EXCHANGE_NAME, export, null, p.productToString().getBytes("UTF-8"));
            
        } catch (Exception ex) {
            System.out.println("Error encoding "+ex);
        }
        
    }
    
    public void close()  
    {
        try {
            
        } catch (Exception ex) {
            Logger.getLogger(Exporter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
    }

}
