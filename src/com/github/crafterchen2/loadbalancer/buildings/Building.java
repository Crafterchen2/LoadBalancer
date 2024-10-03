package com.github.crafterchen2.loadbalancer.buildings;

import com.github.crafterchen2.loadbalancer.enums.ConnectionType;
import com.github.crafterchen2.loadbalancer.enums.Direction;
import com.github.crafterchen2.loadbalancer.util.BuildingPort;

import java.util.HashMap;

//Classes {
public abstract class Building {
	
	//Fields {
	protected final HashMap<Direction, BuildingPort> config = makeConfig();
	protected final HashMap<Direction, Direction> rotated = new HashMap<>(4);
	protected final Direction northDirection;
	//} Fields
	
	//Constructor {
	protected Building(Direction northDirection) {
		if (northDirection == null) throw new NullPointerException("northDirection must not be null.");
		this.northDirection = northDirection;
		rotateConfig();
	}
	//} Constructor
	
	//Methods {
	private void rotateConfig() {
		rotated.clear();
		config.forEach((direction, buildingPort) -> rotated.put(direction, direction.rotate(northDirection)));
	}
	
	public abstract void updatePortSpeeds();
	
	protected HashMap<Direction, BuildingPort> makeConfig() {
		HashMap<Direction, BuildingPort> rv = new HashMap<>(4);
		for (Direction dir : Direction.values()) {
			rv.put(dir, new BuildingPort(ConnectionType.NONE));
		}
		return rv;
	}
	//} Methods
	
	//Getter {
	public HashMap<Direction, BuildingPort> getConfig() {
		return config;
	}
	
	public HashMap<Direction, BuildingPort> getRotatedConfig() {
		HashMap<Direction, BuildingPort> rv = new HashMap<>(4);
		rotated.forEach((direction, direction2) -> rv.put(direction, config.get(direction2)));
		return rv;
	}
	//} Getter
	
}
//} Classes
