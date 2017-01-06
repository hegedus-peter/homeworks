package xyz.codingmentor.peterhegedus03hf3carfactory.sources;

/**
 *
 * @author Péter
 */
public class TurnSignal extends CarPart{

    private final Side side;

    public TurnSignal(Car carType, String manufacturer,Side side) {
        super(carType, manufacturer);
        this.side=side;
        seriesError();
    }

    public Side getSide() {
        return side;
    }
    
    
    
    
}
