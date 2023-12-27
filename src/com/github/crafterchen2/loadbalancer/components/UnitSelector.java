package com.github.crafterchen2.loadbalancer.components;

import com.github.crafterchen2.loadbalancer.enums.Unit;

import javax.swing.*;

public class UnitSelector extends JComboBox<Unit> {

    //Fields

    //Constructor
    public UnitSelector() {
        super(Unit.values());
    }

    //Methods

    //Getter
    public Unit getSelectedUnit(){
        return Unit.values()[getSelectedIndex()];
    }

    //Setter

    //Overrides from
    ////<class>

}
