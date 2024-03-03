package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

public abstract class AbstractSpeed implements Comparable<AbstractSpeed> {

    //Fields

    //Constructor
    protected AbstractSpeed(double perSec){
        checkSpeed(perSec);
    }

    protected AbstractSpeed(double perUnit, Unit unit){
        checkSpeed(perUnit);
    }

    //Methods
    public static void checkSpeed(double speed) {
        if (speed < 0.0) throw new IllegalArgumentException("Target speed must be at least 0.");
    }

    //Getter
    public double getPerUnit(){
        return getPerUnit(Unit.selected);
    }

    public double getPerUnit(Unit unit){
        return getPerSec() * unit.getInvertedFactor();
    }

    public abstract double getPerSec();

    //Setter

    //Overrides from
    ////Comparable<AbstractSpeed>
    @Override
    public int compareTo(AbstractSpeed o) {
        return Double.compare(getPerSec(), o.getPerSec());
    }

}
