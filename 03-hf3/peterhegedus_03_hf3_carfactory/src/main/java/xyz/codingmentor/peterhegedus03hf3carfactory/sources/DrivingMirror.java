package xyz.codingmentor.peterhegedus03hf3carfactory.sources;
/**
 *
 * @author Péter
 */

public class DrivingMirror extends CarPart{

    private final Side side;
    
    public DrivingMirror(Car carType, String factoryName,Side side) {
       super(carType,factoryName);
       this.side=side;
       seriesError();
    }

    public Side getSide() {
        return side;
    }


}
