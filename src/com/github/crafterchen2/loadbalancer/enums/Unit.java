package com.github.crafterchen2.loadbalancer.enums;

//Enums {
public enum Unit {
	
	SEC(1),
	MIN(SEC.factor * 60),
	HOUR(MIN.factor * 60),
	DAY(HOUR.factor * 24),
	WEEK(DAY.factor * 7),
	MONTH(WEEK.factor * 4),
	YEAR(MONTH.factor * 12),
	;
	
	//Fields {
	public static final Unit defaultUnit = MIN;
	
	public static Unit selected = defaultUnit;
	
	private final int factor;
	//} Fields
	
	//Constructor {
	Unit(int factor) {
		this.factor = factor;
	}
	//} Constructor
	
	//Methods {
	public static double per(Unit unit, double perSec) {
		return unit.secToUnit(perSec);
	}
	
	public double secToUnit(double perSec) {
		return perSec / (double) factor;
	}
	
	public double unitToSec(double perUnit) {
		return perUnit * (double) factor;
	}
	//} Methods
	
	//Getter {
	public int getFactor() {
		return factor;
	}
	
	public double getInvertedFactor() {
		return 1.0 / (double) factor;
	}
	//} Getter
	
	//Overrides {
	@Override
	public String toString() {
		return Translation.valueOf(super.toString()).translate();
	}
	//} Overrides
	
}
//} Enums
