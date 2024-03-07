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
        super(perUnit);
        setPerUnit(perUnit, unit);
    }

    public Speed(double perSec, Capacity capacity) {
        super(perSec);
        setCapacity(capacity);
        setPerSec(perSec);
    }

    public Speed(double perUnit, Unit unit, Capacity capacity) {
        super(perUnit);
        setCapacity(capacity);
        setPerUnit(perUnit, unit);
    }

    //Methods
    public void sub(Speed other){
        setPerSec(getPerSec() - other.getPerSec());
    }
    
    public static Speed sub(Capacity capacity, Speed s1, Speed s2){
        return new Speed(s1.getPerSec() - s2.getPerSec(), capacity);
    }
    
    public static Speed sub(Capacity capacity, Speed s1, Speed s2, Speed s3){
        return new Speed(s1.getPerSec() - s2.getPerSec() - s3.getPerSec(), capacity);
    }
    
    public static Speed sub(Capacity capacity, Speed s1, Speed s2, Speed s3, Speed s4){
        return new Speed(s1.getPerSec() - s2.getPerSec() - s3.getPerSec() - s4.getPerSec(), capacity);
    }
    
    public static Speed sub(Capacity capacity, Speed... speeds){
        return switch (speeds.length) {
            case 0 -> null;
            case 1 -> duplicate(speeds[0], capacity);
            case 2 -> sub(capacity, speeds[0], speeds[1]);
            case 3 -> sub(capacity, speeds[0], speeds[1], speeds[2]);
            case 4 -> sub(capacity, speeds[0], speeds[1], speeds[2], speeds[3]);
			default -> {
                Speed rv = speeds[0];
                for (int i = 1; i < speeds.length; i++) {
                    rv.sub(speeds[i]);
                }
                yield rv;
			}
        };
    }
    
    public void add(Speed other){
        setPerSec(getPerSec() + other.getPerSec());
    }
    
    public static Speed add(Capacity capacity, Speed s1, Speed s2){
        return new Speed(s1.getPerSec() + s2.getPerSec(), capacity);
    }
    
    public static Speed add(Capacity capacity, Speed s1, Speed s2, Speed s3){
        return new Speed(s1.getPerSec() + s2.getPerSec() + s3.getPerSec(), capacity);
    }
    
    public static Speed add(Capacity capacity, Speed s1, Speed s2, Speed s3, Speed s4){
        return new Speed(s1.getPerSec() + s2.getPerSec() + s3.getPerSec() + s4.getPerSec(), capacity);
    }
    
    public static Speed add(Capacity capacity, Speed... speeds){
        return switch (speeds.length) {
            case 0 -> null;
            case 1 -> duplicate(speeds[0], capacity);
            case 2 -> add(capacity, speeds[0], speeds[1]);
            case 3 -> add(capacity, speeds[0], speeds[1], speeds[2]);
            case 4 -> add(capacity, speeds[0], speeds[1], speeds[2], speeds[3]);
            default -> {
                Speed rv = speeds[0];
                for (int i = 1; i < speeds.length; i++) {
                    rv.add(speeds[i]);
                }
                yield rv;
            }
        };
    }
    
    public static Speed duplicate(Speed toDuplicate){
        return duplicate(toDuplicate, toDuplicate.capacity);
    }
    
    public static Speed duplicate(Speed toDuplicate, Capacity capacity){
        return new Speed(toDuplicate.getPerSec(), capacity);
    }
    
    public Capacity toCapacity(){
        return new Capacity(getPerSec());
    }

    //Getter
    public Capacity getCapacity() {
        return capacity;
    }

    //Setter
    public void setPerUnit(double perDefaultUnit){
        setPerUnit(perDefaultUnit, null);
    }

    public void setPerUnit(double perUnit, Unit unit){
        if (unit == null) unit = Unit.selected;
        checkPerUnit(perUnit, capacity, unit);
        perSec = unit.unitToSec(perUnit);
    }

    public void setCapacity(Capacity capacity){
        if (capacity == null) throw new NullPointerException("capacity must not be null.");
        this.capacity = capacity;
    }

    public void setPerSec(double perSec) {
        checkPerSec(perSec, capacity);
        this.perSec = perSec;
    }

    //Overrides from
    ////AbstractSpeed
    @Override
    public double getPerSec() {
        return perSec;
    }

}
