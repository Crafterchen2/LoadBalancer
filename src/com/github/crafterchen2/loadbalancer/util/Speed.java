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
    public static Speed sub(Speed s1, Speed s2){
        return new Speed(s1.perSec - s2.perSec, s1.capacity);
    }

    public Speed sub(Speed s2){
        return sub(this,s2);
    }

    public static Speed add(Speed s1, Speed s2){
        return new Speed(s1.perSec - s2.perSec, s1.capacity);
    }

    public Speed add(Speed s2){
        return sub(this,s2);
    }

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
        perSec = Math.min(capacity.getPerUnit(unit), Math.max(1, (int) (perUnit * unit.getFactor())));
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
