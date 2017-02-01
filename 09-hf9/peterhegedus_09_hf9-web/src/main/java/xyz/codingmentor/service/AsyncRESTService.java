package xyz.codingmentor.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.exception.AsyncMethodFailedException;

/**
 *
 * @author Péter
 */
@Path("/async")
@Produces(MediaType.TEXT_PLAIN)
public class AsyncRESTService {

    @Inject
    private AsyncService asyncService;

    /**
     * http://localhost:8080/peterhegedus_09_hf9-web/asyncrest/async/void      *
     * A metódus elindít egy hosszú folyamatot(szál altatás), de ennek nem várja meg a végét, hanem egyől visszatér
     *
     */
    @Path("/void")
    @GET
    public String voidMethod() {
        asyncService.voidMethod();
        return "Void method finished";
    }

    /** http://localhost:8080/peterhegedus_09_hf9-web/asyncrest/async/future/{num1}/{num2}
     * A metódus elindít egy hosszú műveletet(paraméterben kapott 2 szám összege szál alvása után), amíg erre vár, addig mást csinál(log), majd a kapott Future<Integer> típusú eredményből kinyert összeggel kiegészített üzenettel visszatér
     * Az aszinkron hívás után azért altatom 1 másodpercig, mert túl gyorsan tudta kiírni a "doing something..." üzenetet, így a doing something->start->finished helyett a szemléletesebb start->doing something->finished üzenetsor íródik ki
     */
    @GET
    @Path("/future/{num1}/{num2}")
    @Consumes(MediaType.TEXT_PLAIN)
    public String futureMethod(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        
        Future<Integer> result = asyncService.futureMethod(num1, num2);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncRESTService.class.getName()).log(Level.SEVERE, null, ex);
        }
        Logger.getLogger(AsyncRESTService.class.getName()).log(Level.INFO, "Doing something while async call working.");
        try {
            return "Future method finished with result: " + result.get().toString();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(AsyncRESTService.class.getName()).log(Level.SEVERE, null, ex);
        }
        throw new AsyncMethodFailedException("AsyncService.futureMethod");
    }
}
