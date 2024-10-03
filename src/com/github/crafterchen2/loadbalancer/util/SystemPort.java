package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.ConnectionType;

//Classes {
public class SystemPort extends Port {
	
	//Fields {
	private final Capacity capacity;
	//} Fields
	
	//Constructor {
	public SystemPort() {
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
	//} Constructor
	
	//Overrides {
	@Override
	public AbstractSpeed getSpeed() {
		return capacity;
	}
	//} Overrides
	
}
//} Classes
