package xyz.codingmentor.peterhegedus13hf13flightservice.iface;

import java.util.List;
import xyz.codingmentor.peterhegedus13hf13flightservice.entity.Flight;

/**
 *
 * @author Péter
 */
public interface FlightServiceInterface {
    
    public Flight getFlight(String flightID);
    
    public List<Flight> getAllFlights();
    
    public void addFlight(Flight flight);
    
    public void editFlight(Flight flight);
    
    public void deleteFlight(String flightID);
    
    public void flightNotify();
    
    
    
}
