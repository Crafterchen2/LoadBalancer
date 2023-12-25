package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

public abstract class AbstractSpeed {

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
        if (speed <= 0.0) throw new IllegalArgumentException("Target speed must be bigger than 0.");
    }

    //Getter
    public double get(){
        return get(Unit.selected);
    }

    public double get(Unit unit){
        return getPerSec() * unit.getFactor();
    }

    public abstract double getPerSec();

    //Setter

    //Overrides from
    ////<class>

}
