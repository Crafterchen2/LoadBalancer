package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.ConnectionType;

public abstract class Port {

    //Fields
    protected final ConnectionType io;

    //Constructor
    protected Port(ConnectionType io){
        if (io == null) throw new NullPointerException("io must not be null.");
        this.io = io;
    }

    //Methods

    //Getter
    public abstract AbstractSpeed getSpeed();

    public abstract ConnectionType getConnectionType();

    //Setter

    //Overrides from
    ////<class>

}
