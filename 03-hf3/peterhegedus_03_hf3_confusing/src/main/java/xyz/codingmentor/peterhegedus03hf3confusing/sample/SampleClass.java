package xyz.codingmentor.peterhegedus03hf3confusing.sample;

import xyz.codingmentor.peterhegedus03hf3confusing.source.Confusing;

/**
 *
 * @author Péter
 */
@Confusing
public class SampleClass {
    @Confusing
    private int a;
    private double radius;
    @Confusing
    private String s;

    public double getRadius() {
        return radius;
    }
    
    @Confusing
    public double myConfusingMethod1(int a, int b, double c){
        return a+b/c;
    }
    
    public int myNotConfusingMethod(int number){
        return number*number;
    }
    
    @Confusing
    public String myConfusingMethod2(String a, Integer b){
        return a.concat(b.toString());
    }

}
