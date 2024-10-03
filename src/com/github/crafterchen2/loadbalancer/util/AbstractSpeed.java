package com.github.crafterchen2.loadbalancer.util;

import com.github.crafterchen2.loadbalancer.enums.Unit;

//Classes {
public abstract class AbstractSpeed implements Comparable<AbstractSpeed> {
	
	//Constructor {
	protected AbstractSpeed(double perSec) {
		checkSpeed(perSec);
	}
	//} Constructor
	
	//Methods {
	public static void checkSpeed(double speed) {
		if (speed < 0.0) throw new IllegalArgumentException("Target speed must be at least 0.");
	}
	
	public static void checkSpeed(double speed, double capacity) {
		checkSpeed(speed, capacity, "");
	}
	
	private static void checkSpeed(double speed, double capacity, String hint) {
		checkSpeed(speed);
		if (speed > capacity) throw new IllegalArgumentException("Target speed must not exceed the set capacity." + hint);
	}
	
	public static void checkPerSec(double perSec, Capacity capacity) {
		checkSpeed(perSec, capacity.getPerSec(), " (capacity.getPerSec())");
	}
	
	public static void checkPerUnit(double perUnit, Capacity capacity) {
		checkSpeed(perUnit, capacity.getPerUnit(), " (capacity.getPerUnit())");
	}
	
	public static void checkPerUnit(double perUnit, Capacity capacity, Unit unit) {
		checkSpeed(perUnit, capacity.getPerUnit(unit), " (capacity.getPerUnit(unit))");
	}
	
	public double getPerUnit(Unit unit) {
		return unit.secToUnit(getPerSec());
	}
	//} Methods
	
	//Getter {
	public double getPerUnit() {
		return getPerUnit(Unit.selected);
	}
	
	public abstract double getPerSec();
	//} Getter
	
	//Overrides {
	@Override
	public int compareTo(AbstractSpeed o) {
		return Double.compare(getPerSec(), o.getPerSec());
	}
	//} Overrides
	
}
//} Classes
