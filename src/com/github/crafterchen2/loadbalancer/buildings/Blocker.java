package com.github.crafterchen2.loadbalancer.buildings;

import com.github.crafterchen2.loadbalancer.enums.Direction;
import com.github.crafterchen2.loadbalancer.util.BuildingPort;

import java.util.HashMap;

//Classes {
public class Blocker extends Building {
	
	//Constructor {
	protected Blocker(Direction northDirection) {
		super(northDirection);
	}
	//} Constructor
	
	//Overrides {
	@Override
	public void updatePortSpeeds() {
	
	}
	
	@Override
	public HashMap<Direction, BuildingPort> getRotatedConfig() {
		return getConfig();
	}
	//} Overrides
}
//} Classes
