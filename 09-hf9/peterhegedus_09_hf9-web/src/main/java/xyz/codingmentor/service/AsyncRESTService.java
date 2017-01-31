package xyz.codingmentor.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Péter
 */
@Path("/async")
@Produces(MediaType.TEXT_PLAIN)
public class AsyncRESTService {

    private final AsyncService asyncService = new AsyncService();

    /**
     * http://localhost:8080/peterhegedus_09_hf9-web/asyncrest/async/void      *
     * A metódus várakozik, majd jelzi, hogy végzett
     *
     */
    @Path("/void")
    @GET
    public String voidMethod() {
        asyncService.voidMethod();
        return "Void method finished";
    }

    /** http://localhost:8080/peterhegedus_09_hf9-web/asyncrest/async/future/{num1}/{num2}
     * A metódus várakozás után visszaadja a paraméterben kapott 2 szám összegét
     */
    @GET
    @Path("/future/{num1}/{num2}")
    @Consumes(MediaType.TEXT_PLAIN)
    public String futureMethod(@PathParam("num1") Integer num1, @PathParam("num2") Integer num2) {
        String retVal = null;
        Future<Integer> result = asyncService.futureMethod(num1, num2);
        try {
            retVal = "Future method finished with result: " + result.get().toString();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(AsyncRESTService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retVal;
    }
}
