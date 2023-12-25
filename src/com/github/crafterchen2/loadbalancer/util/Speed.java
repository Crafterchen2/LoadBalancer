package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

public class Speed extends AbstractSpeed{

    //Fields
    private double perSec;
    private Capacity capacity = Capacity.infinite;

    //Constructor
    public Speed(double perSec) {
        super(perSec);
        setPerSec(perSec);
    }

    public Speed(double perUnit, Unit unit) {
        super(perUnit, unit);
        set(perUnit, unit);
    }

    public Speed(double perSec, Capacity capacity) {
        super(perSec);
        setCapacity(capacity);
        setPerSec(perSec);
    }

    public Speed(double perUnit, Unit unit, Capacity capacity) {
        super(perUnit, unit);
        setCapacity(capacity);
        set(perUnit, unit);
    }

    //Methods

    //Getter
    public Capacity getCapacity() {
        return capacity;
    }

    //Setter
    public void set(double perDefaultUnit){
        set(perDefaultUnit, Unit.selected);
    }

    public void set(double perUnit, Unit unit){
        checkSpeed(perUnit);
        perSec = Math.min(capacity.get(unit), Math.max(1, (int) (perUnit * (1/unit.getFactor()))));
    }

    public void setCapacity(Capacity capacity){
        if (capacity == null) throw new NullPointerException("capacity must not be null.");
        this.capacity = capacity;
    }

    public void setPerSec(double perSec) {
        checkSpeed(perSec);
        if (perSec > capacity.getPerSec()) throw new IllegalArgumentException("perSec must not exceed the set capacity.");
        this.perSec = perSec;
    }

    //Overrides from
    ////Speed
    @Override
    public double getPerSec() {
        return perSec;
    }

}
