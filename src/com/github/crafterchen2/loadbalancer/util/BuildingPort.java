package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Belt;
import com.github.crafterchen2.loadbalancer.enums.ConnectionType;

public class BuildingPort extends Port {

    //Fields
    private final Speed speed = new Speed(0);
    private Belt belt;

    //Constructor
    public BuildingPort(ConnectionType io) {
        this(io,Belt.NO_BELT);
    }

    public BuildingPort(ConnectionType io, Belt belt) {
        super(io);
        setBelt(belt);
        switch (this.io) {
            case NONE -> speed.setCapacity(Capacity.zero);
            case INPUT, OUTPUT -> speed.setCapacity(belt.capacity);
        }
    }

    //Methods

    //Getter
    public Belt getBelt() {
        return belt;
    }

    public Capacity getCapacity(){
        return belt.capacity;
    }

    //Setter
    public void setBelt(Belt belt) {
        if (belt == null) throw new NullPointerException("belt must not be null.");
        if (belt != Belt.NO_BELT && io == ConnectionType.NONE) throw new IllegalArgumentException("Can't place a belt where placing a belt is not possible.");
        this.belt = belt;
    }

    //Overrides from
    ////Port
    @Override
    public AbstractSpeed getSpeed() {
        return speed;
    }
	
}
