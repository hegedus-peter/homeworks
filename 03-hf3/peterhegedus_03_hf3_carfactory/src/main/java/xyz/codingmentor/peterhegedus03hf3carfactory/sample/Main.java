package xyz.codingmentor.peterhegedus03hf3carfactory.sample;

import xyz.codingmentor.peterhegedus03hf3carfactory.factory.CarPartFactory;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.Car;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.CarPart;
import xyz.codingmentor.peterhegedus03hf3carfactory.sources.CarPartType;

/**
 *
 * @author Péter
 */
public class Main {
    private Main(){
        
    }
    
    public static void main(String[] args) {
        CarPartFactory carfactory = CarPartFactory.getInstance();
        CarPart mazdaWindow1 = carfactory.create(Car.MAZDA, CarPartType.ELECTRICWINDOW, true);
        CarPart mazdaWindow2 = carfactory.create(Car.MAZDA, CarPartType.ELECTRICWINDOW, true);
        CarPart mazdaWindow3 = carfactory.create(Car.MAZDA, CarPartType.ELECTRICWINDOW, true);
        CarPart mazdaWindow4 = carfactory.create(Car.MAZDA, CarPartType.ELECTRICWINDOW, true);
        CarPart mazdaWindow5 = carfactory.create(Car.MAZDA, CarPartType.ELECTRICWINDOW, true);
        
        CarPart toyotaTransmission1 = carfactory.create(Car.TOYOTA, CarPartType.TRANSMISSION, 5);
        CarPart toyotaTransmission2 = carfactory.create(Car.TOYOTA, CarPartType.TRANSMISSION, 5);
        CarPart toyotaTransmission3 = carfactory.create(Car.TOYOTA, CarPartType.TRANSMISSION, 5);
        CarPart toyotaTransmission4 = carfactory.create(Car.TOYOTA, CarPartType.TRANSMISSION, 5);
        CarPart toyotaTransmission5 = carfactory.create(Car.TOYOTA, CarPartType.TRANSMISSION, 5);
        
        mazdaWindow1.listErrors();
        mazdaWindow2.listErrors();
        mazdaWindow3.listErrors();
        mazdaWindow4.listErrors();
        mazdaWindow5.listErrors();
        
        toyotaTransmission1.listErrors();
        toyotaTransmission2.listErrors();
        toyotaTransmission3.listErrors();
        toyotaTransmission4.listErrors();
        toyotaTransmission5.listErrors();
       
    }
}
