package xyz.codingmentor.peterhegedus13hf13flightservice.bean;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Topic;

/**
 *
 * @author Péter
 */
@Stateless
public class FlightMessageBean {
    
    @Inject
    private JMSContext context;
    
    @Resource(lookup = "jms/flightTopic")
    private Topic flightTopic;
    
    public void produceMessageToTopic(String message){
        context.createProducer().send(flightTopic, message);
    }

}
