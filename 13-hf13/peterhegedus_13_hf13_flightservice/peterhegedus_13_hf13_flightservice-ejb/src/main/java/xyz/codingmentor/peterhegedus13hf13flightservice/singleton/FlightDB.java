package xyz.codingmentor.peterhegedus13hf13flightservice.singleton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.ejb.Singleton;
import xyz.codingmentor.peterhegedus13hf13flightservice.entity.Flight;
import xyz.codingmentor.peterhegedus13hf13flightservice.exception.FlightAlreadyAddedException;
import xyz.codingmentor.peterhegedus13hf13flightservice.exception.FlightListEmptyException;
import xyz.codingmentor.peterhegedus13hf13flightservice.exception.FlightNotFoundException;

/**
 *
 * @author Péter
 */
@Singleton
public class FlightDB implements Serializable{
    
    private final Map<String,Flight> flights = new HashMap<>();
    
    public void addFlight(Flight flight){
        if(flights.containsKey(flight.getFlightID())){
            throw new FlightAlreadyAddedException(flight.getFlightID());
        }
        else{
            flights.put(flight.getFlightID(), flight);
        }
    }
    
    public Flight getFlight(String flightID){
        if(flights.containsKey(flightID)){
            return flights.get(flightID);
        }
        else{
            throw new FlightNotFoundException(flightID);
        }
    }
    
    public List<Flight> getAllFlights(){
        if(!flights.isEmpty()){
            return new ArrayList<>(flights.values());
        }
        else{
            throw new FlightListEmptyException();
        }
    }
    
    public void editFlight(Flight flight){
        if(flights.containsKey(flight.getFlightID())){
            flights.put(flight.getFlightID(), flight);
        }
        else{
            throw new FlightNotFoundException(flight.getFlightID());
        }
    }
    
    public void deleteFlight(String flightID){
        if(flights.containsKey(flightID)){
            flights.remove(flightID);
        }
        else{
            throw new FlightNotFoundException(flightID);
        }
    }
    
    public boolean isEmpty(){
        return flights.isEmpty();
    }

}
