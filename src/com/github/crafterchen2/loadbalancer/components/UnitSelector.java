package com.github.crafterchen2.loadbalancer.components;

import com.github.crafterchen2.loadbalancer.enums.Unit;

import javax.swing.*;

//Classes {
public class UnitSelector extends JComboBox<Unit> {
	
	//Constructor {
	public UnitSelector() {
		super(Unit.values());
	}
	//} Constructor
	
	//Getter {
	public Unit getSelectedUnit() {
		return Unit.values()[getSelectedIndex()];
	}
	//} Getter
	
}
//} Classes
