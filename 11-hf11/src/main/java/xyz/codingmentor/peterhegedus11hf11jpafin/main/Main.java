package xyz.codingmentor.peterhegedus11hf11jpafin.main;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

/**
 *
 * @author Péter
 */
public class Main {

    private Main() {
        //generated
    }
    
    

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        Application application = container.instance().select(Application.class).get();
        application.run();

        weld.shutdown();
    }

}
