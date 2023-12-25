package com.github.crafterchen2.loadbalancer.enums;

public enum Unit {

    //Entries
    SEC(1),
    MIN(SEC.factor*60),
    HOUR(MIN.factor*60),
    DAY(HOUR.factor*24),
    WEEK(DAY.factor*7),
    MONTH(WEEK.factor*4),
    YEAR(MONTH.factor*12),
    ;

    //Fields
    public static final Unit defaultUnit = MIN;

    public static Unit selected = defaultUnit;

    private final int factor;

    //Constructor
    Unit(int factor) {
        this.factor = factor;
    }

    //Methods

    //Getter
    public double getFactor(){
        return 1.0 / (double) factor;
    }

    //Setter

    //Overrides from
    ////<class>

}
