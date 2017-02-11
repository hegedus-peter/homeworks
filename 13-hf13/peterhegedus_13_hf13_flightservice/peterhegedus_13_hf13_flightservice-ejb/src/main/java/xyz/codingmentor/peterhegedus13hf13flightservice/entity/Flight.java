package xyz.codingmentor.peterhegedus13hf13flightservice.entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Péter
 */
public class Flight implements Serializable{
    
    private String flightID;
    private String startDestination;
    private String finDestination;
    private Date startTime;
    private Date finTime;

    public Flight() {
        //generated
    }

    public Flight(String flightID, String startDestination, String finDestination, Date startTime, Date finTime) {
        this.flightID = flightID;
        this.startDestination = startDestination;
        this.finDestination = finDestination;
        this.startTime = startTime;
        this.finTime = finTime;
    }

    public String getFlightID() {
        return flightID;
    }

    public void setFlightID(String flightID) {
        this.flightID = flightID;
    }

    public String getStartDestination() {
        return startDestination;
    }

    public void setStartDestination(String startDestination) {
        this.startDestination = startDestination;
    }

    public String getFinDestination() {
        return finDestination;
    }

    public void setFinDestination(String finDestination) {
        this.finDestination = finDestination;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getFinTime() {
        return finTime;
    }

    public void setFinTime(Date finTime) {
        this.finTime = finTime;
    }

    @Override
    public String toString() {
        return "Flight{" + "flightID=" + flightID + ", startDestination=" + startDestination + ", finDestination=" + finDestination + ", startTime=" + startTime + ", finTime=" + finTime + '}';
    }
    
    

}
