package xyz.codingmentor.service;

import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author Péter
 */
@Stateless
public class AsyncService implements Serializable{
    
    private static final Logger LOG = Logger.getLogger(AsyncService.class.getName());

    @Asynchronous
    public void voidMethod() {
        LOG.log(Level.INFO, "Void method starts.");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncService.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "Void method finished.");
    }

    @Asynchronous
    public Future<Integer> futureMethod(Integer num1, Integer num2) {
        LOG.log(Level.INFO, "Future method starts.");
        Future<Integer> result = null;
        try {
            Thread.sleep(10000);
            result = new AsyncResult<>(num1 + num2);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncService.class.getName()).log(Level.SEVERE, null, ex);
        }
        LOG.log(Level.INFO, "Future method finished.");
        return result;
    }
}
