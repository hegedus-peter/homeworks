package xyz.codingmentor.service;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import xyz.codingmentor.peterhegedus13hf13flightservice.entity.Flight;
import xyz.codingmentor.peterhegedus13hf13flightservice.iface.FlightServiceInterface;
import xyz.codingmentor.peterhegedus13hf13flightservice.qualifier.FlightServiceQualifier;

/**
 * REST Web Service
 *
 * @author Péter
 */
@Path("flights")
@RequestScoped
public class FlightService {
    
    @Inject
    @FlightServiceQualifier
    FlightServiceInterface flightServiceProvider;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Flight getFlight(@PathParam("id") String id)  {
        return flightServiceProvider.getFlight(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Flight> getAllFlights()  {
        return flightServiceProvider.getAllFlights();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFlight(Flight flight) {
        flightServiceProvider.addFlight(flight);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void editFlight(Flight flight) {
        flightServiceProvider.editFlight(flight);
    }
    
    @DELETE
    @Path("/{id}")
    public void deleteFlight(@PathParam("id") String id) {
        flightServiceProvider.deleteFlight(id);
    }
    
    
}
