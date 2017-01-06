package xyz.codingmentor.peterhegedus03hf3carfactory.sources;

/**
 *
 * @author Péter
 */
public class Transmission extends CarPart{
    
    private final int speed;

    public Transmission(Car carType, String manufacturer,int speed) {
        super(carType, manufacturer);
        this.speed=speed;
        seriesError();
    }

    public int getSpeed() {
        return speed;
    }

}
