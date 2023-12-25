package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

public class Speed extends AbstractSpeed{

    //Fields
    private double perSec;

    //Constructor
    private Speed(double perSec) {
        super(perSec);
        setPerSec(perSec);
    }

    private Speed(double perUnit, Unit unit) {
        super(perUnit, unit);
        set(perUnit, unit);
    }


    //Methods

    //Getter

    //Setter
    private void set(double perDefaultUnit){
        set(perDefaultUnit, Unit.selected);
    }

    private void set(double perUnit, Unit unit){
        checkSpeed(perUnit);
        perSec = Math.max(1, (int) (perUnit * (1/unit.getFactor())));
    }

    private void setPerSec(double perSec) {
        checkSpeed(perSec);
        this.perSec = perSec;
    }

    //Overrides from
    ////Speed
    @Override
    public double getPerSec() {
        return perSec;
    }

}
