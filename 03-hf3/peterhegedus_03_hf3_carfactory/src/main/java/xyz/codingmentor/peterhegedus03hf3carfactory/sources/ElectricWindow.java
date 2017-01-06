package xyz.codingmentor.peterhegedus03hf3carfactory.sources;

import xyz.codingmentor.peterhegedus03hf3carfactory.annotation.BrokenWindowAnnotation;

/**
 *
 * @author Péter
 */
@BrokenWindowAnnotation
public class ElectricWindow extends CarPart{

    private final boolean isCentral;
    
    public ElectricWindow(Car carType, String manufacturer,boolean isCentral) {
        super(carType, manufacturer);
        this.isCentral=isCentral;
        seriesError();
    }

    public boolean isIsCentral() {
        return isCentral;
    }

}
