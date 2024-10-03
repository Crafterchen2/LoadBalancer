package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

//Classes {
public class Capacity extends AbstractSpeed {
	
	//Fields {
	public static final Capacity zero = new Capacity(0.0);
	public static final Capacity infinite = new Capacity(Double.MAX_VALUE);
	
	private final double perSec;
	//} Fields
	
	//Constructor {
	public Capacity(double perSec) {
		super(perSec);
		this.perSec = perSec;
	}
	
	public Capacity(double perUnit, Unit unit) {
		super(perUnit);
		this.perSec = unit.unitToSec(perUnit);
	}
	//} Constructor
	
	
	//Overrides {
	@Override
	public double getPerSec() {
		return perSec;
	}
	//} Overrides
	
}
//} Classes
