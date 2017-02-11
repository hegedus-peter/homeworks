package xyz.codingmentor.peterhegedus13hf13flightservice.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import xyz.codingmentor.peterhegedus13hf13flightservice.bean.FlightMessageBean;
import xyz.codingmentor.peterhegedus13hf13flightservice.entity.Flight;
import xyz.codingmentor.peterhegedus13hf13flightservice.iface.FlightServiceInterface;
import xyz.codingmentor.peterhegedus13hf13flightservice.qualifier.FlightServiceQualifier;
import xyz.codingmentor.peterhegedus13hf13flightservice.singleton.FlightDB;

/**
 *
 * @author Péter
 */
@FlightServiceQualifier
@Singleton
@Startup
public class FlightService implements FlightServiceInterface{
    
    @Inject
    private FlightDB flightDB;
    
    @Inject
    private FlightMessageBean flightMessageBean;
    
    @Override
    public void addFlight(Flight flight) {
        flightDB.addFlight(flight);
        flightNotify();
    }

    @Override
    public Flight getFlight(String flightID) {
        return flightDB.getFlight(flightID);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDB.getAllFlights();
    }

    @Override
    public void editFlight(Flight flight) {
        flightDB.editFlight(flight);
        String message = "Flight has been edited: " + flight.toString();
        flightMessageBean.produceMessageToTopic(message);
        flightNotify();
    }

    @Override
    public void deleteFlight(String flightID) {
        flightDB.deleteFlight(flightID);
        String message = "Flight " + flightID + " has been deleted.";
        flightMessageBean.produceMessageToTopic(message);
    }

    @Override
    @Schedule(second="*/10",minute = "*", hour = "*")
    public void flightNotify() {
        if(!flightDB.isEmpty()){
            List<Flight> flights = getAllFlights();
            Date now = new Date();
            Calendar oneHourCalendar = new GregorianCalendar();
            oneHourCalendar.add(Calendar.HOUR_OF_DAY,1);
            Date oneHourDate = oneHourCalendar.getTime();
            for(Flight flight : flights){
                if(flight.getStartTime().after(now) && flight.getStartTime().before(oneHourDate)){
                    String message = "Flight starts in less than an hour: " + flight.toString();
                    flightMessageBean.produceMessageToTopic(message);
                }
            }
        }
        
    }

}
