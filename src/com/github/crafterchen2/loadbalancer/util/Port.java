package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.ConnectionType;

//Classes {
public abstract class Port {
	
	//Fields {
	protected final ConnectionType io;
	//} Fields
	
	//Constructor {
	protected Port(ConnectionType io) {
		if (io == null) throw new NullPointerException("io must not be null.");
		this.io = io;
	}
	//} Constructor
	
	//Getter {
	public abstract AbstractSpeed getSpeed();
	
	public ConnectionType getConnectionType() {
		return io;
	}
	//} Getter
	
}
//} Classes
