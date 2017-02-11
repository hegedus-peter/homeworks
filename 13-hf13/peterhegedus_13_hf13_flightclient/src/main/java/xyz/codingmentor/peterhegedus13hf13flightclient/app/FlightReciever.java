package xyz.codingmentor.peterhegedus13hf13flightclient.app;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;


/**
 *
 * @author Péter
 */
@MessageDriven(mappedName = "jms/flightTopic")
public class FlightReciever implements MessageListener{
    
    private static final Logger LOG = Logger.getLogger(FlightReciever.class.getName());

    @Override
    public void onMessage(Message message) {
        try {
            LOG.log(Level.INFO, message.getBody(String.class));
        } catch (JMSException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
    }

}
