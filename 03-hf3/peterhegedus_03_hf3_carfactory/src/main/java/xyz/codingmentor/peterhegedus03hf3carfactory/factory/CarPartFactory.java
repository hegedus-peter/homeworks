package xyz.codingmentor.peterhegedus03hf3carfactory.factory;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car;
import static xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car.AUDI;
import static xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car.FORD;
import static xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car.MAZDA;
import static xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car.TOYOTA;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.CarPart;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.CarPartType;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.DrivingMirror;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.ElectricWindow;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.Side;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.Transmission;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.TurnSignal;

/**
 *
 * @author Péter
 */
public class CarPartFactory {
    
    private static CarPartFactory instance;
    private final String factoryName;
    private final Map<Date,String> log;
    String errorMessage="Some of the arguments is invalid";

    public CarPartFactory(String factoryName) {
        this.factoryName = factoryName;
        log = new HashMap<>();
    }
    
    public static CarPartFactory getInstance(){
        if(null==instance){
            instance=new CarPartFactory("Car Part Factory");
        }
        return instance;
    }
    
    public CarPart create(Car type,CarPartType carPartType, Object objectProperty){
        CarPart newPart;
        switch(type){
            case FORD:
                newPart=fordCreate(carPartType,objectProperty);
                break;
            case MAZDA:
                newPart=mazdaCreate(carPartType,objectProperty);
                break;
            case AUDI:
                newPart=audiCreate(carPartType,objectProperty);
                break;
            case TOYOTA:
                newPart=toyotaCreate(carPartType,objectProperty);
                break; 
            default:
                throw new IllegalArgumentException(errorMessage);
        }
        return newPart;
    }
    public CarPart fordCreate(CarPartType carPartType, Object objectProperty){
        switch(carPartType){
                    case DRIVINGMIRROR:
                        log.put(Calendar.getInstance().getTime(), "Ford driving mirror");
                        return new DrivingMirror(FORD,this.factoryName, (Side) objectProperty);
                    case ELECTRICWINDOW:
                        log.put(Calendar.getInstance().getTime(), "Ford electric window");
                        return new ElectricWindow(FORD,this.factoryName, (boolean) objectProperty);
                    case TRANSMISSION:
                        log.put(Calendar.getInstance().getTime(), "Ford transmission");
                        return new Transmission(FORD,this.factoryName, (int) objectProperty);
                    case TURNSIGNAL:
                        log.put(Calendar.getInstance().getTime(), "Ford turn signal");
                        return new TurnSignal(FORD,this.factoryName, (Side) objectProperty);
                    default:
                        throw new IllegalArgumentException(errorMessage);
                }
    }
    
    public CarPart mazdaCreate(CarPartType carPartType, Object objectProperty){
        switch(carPartType){
                    case DRIVINGMIRROR:
                        log.put(Calendar.getInstance().getTime(), "Mazda driving mirror");
                        return new DrivingMirror(MAZDA,this.factoryName, (Side) objectProperty);
                    case ELECTRICWINDOW:
                        log.put(Calendar.getInstance().getTime(), "Mazda electric window");
                        return new ElectricWindow(MAZDA,this.factoryName, (boolean) objectProperty);
                    case TRANSMISSION:
                        log.put(Calendar.getInstance().getTime(), "Mazda transmission");
                        return new Transmission(MAZDA,this.factoryName, (int) objectProperty);
                    case TURNSIGNAL:
                        log.put(Calendar.getInstance().getTime(), "Mazda turn signal");
                        return new TurnSignal(MAZDA,this.factoryName, (Side) objectProperty);
                    default:
                        throw new IllegalArgumentException(errorMessage);
                }
    }
    
    public CarPart audiCreate(CarPartType carPartType, Object objectProperty){
        switch(carPartType){
                    case DRIVINGMIRROR:
                        log.put(Calendar.getInstance().getTime(), "Audi driving mirror");
                        return new DrivingMirror(AUDI,this.factoryName, (Side) objectProperty);
                    case ELECTRICWINDOW:
                        log.put(Calendar.getInstance().getTime(), "Audi electric window");
                        return new ElectricWindow(AUDI,this.factoryName, (boolean) objectProperty);
                    case TRANSMISSION:
                        log.put(Calendar.getInstance().getTime(), "Audi transmission");
                        return new Transmission(AUDI,this.factoryName, (int) objectProperty);
                    case TURNSIGNAL:
                        log.put(Calendar.getInstance().getTime(), "Audi turn signal");
                        return new TurnSignal(AUDI,this.factoryName, (Side) objectProperty);
                    default:
                        throw new IllegalArgumentException(errorMessage);
                }  
    }
    
    public CarPart toyotaCreate(CarPartType carPartType, Object objectProperty){
        switch(carPartType){
                    case DRIVINGMIRROR:
                        log.put(Calendar.getInstance().getTime(), "Toyota driving mirror");
                        return new DrivingMirror(TOYOTA,this.factoryName, (Side) objectProperty);
                    case ELECTRICWINDOW:
                        log.put(Calendar.getInstance().getTime(), "Toyota electric window");
                        return new ElectricWindow(TOYOTA,this.factoryName, (boolean) objectProperty);
                    case TRANSMISSION:
                        log.put(Calendar.getInstance().getTime(), "Toyota transmission");
                        return new Transmission(TOYOTA,this.factoryName, (int) objectProperty);
                    case TURNSIGNAL:
                        log.put(Calendar.getInstance().getTime(), "Toyota turn signal");
                        return new TurnSignal(TOYOTA,this.factoryName, (Side) objectProperty);
                    default:
                        throw new IllegalArgumentException(errorMessage);
                }
    }
    
}
