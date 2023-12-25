package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

public class Capacity extends AbstractSpeed {

    //Fields
    private final double perSec;

    //Constructor
    public Capacity(double perSec) {
        super(perSec);
        this.perSec = perSec;
    }

    public Capacity(double perUnit, Unit unit) {
        super(perUnit, unit);
        this.perSec = Math.max(1, (int) (perUnit * (1/unit.getFactor())));
    }


    //Methods

    //Getter

    //Setter

    //Overrides from
    ////Speed
    @Override
    public double getPerSec() {
        return perSec;
    }

}
