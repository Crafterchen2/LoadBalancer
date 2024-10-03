package com.github.crafterchen2.loadbalancer.buildings;

import com.github.crafterchen2.loadbalancer.enums.ConnectionType;
import com.github.crafterchen2.loadbalancer.enums.Direction;
import com.github.crafterchen2.loadbalancer.util.BuildingPort;
import com.github.crafterchen2.loadbalancer.util.Capacity;
import com.github.crafterchen2.loadbalancer.util.Speed;

import java.util.HashMap;

//Classes {
public class Splitter extends Building {
	
	//Constructor {
	private Splitter(Direction northDirection) {
		super(northDirection);
	}
	//} Constructor
	
	//Overrides {
	@Override
	public void updatePortSpeeds() {
	
	}
	
	@Override
	protected HashMap<Direction, BuildingPort> makeConfig() {
		HashMap<Direction, BuildingPort> rv = new HashMap<>(4);
		for (Direction dir : Direction.values()) {
			rv.put(dir, new BuildingPort((dir == Direction.NORTH) ? ConnectionType.INPUT : ConnectionType.OUTPUT));
		}
		return rv;
	}
	//} Overrides
}
//} Classes
