package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.ConnectionType;

public class SystemPort extends Port {

    //Fields
    private final Capacity capacity;

    //Constructor
    public SystemPort(){
        this(ConnectionType.NONE, Capacity.zero);
    }

    public SystemPort(ConnectionType io, Capacity capacity) {
        super(io);
        if (capacity == null) throw new NullPointerException("capacity must not be null");
        this.capacity = switch (io) {
            case NONE -> Capacity.zero;
            case INPUT, OUTPUT -> capacity;
        };
    }

    //Methods

    //Getter

    //Setter

    //Overrides from
    ////Port
    @Override
    public AbstractSpeed getSpeed() {
        return capacity;
    }

    @Override
    public ConnectionType getConnectionType() {
        return io;
    }

}
