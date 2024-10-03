package com.github.crafterchen2.loadbalancer.enums;

//Enums {
public enum Direction {
	
	NORTH,
	EAST,
	SOUTH,
	WEST,
	;
	
	//Methods {
	public Direction rotate(int rotateAmount) {
		return switch (rotateAmount % 4) {
			case 1, -3 -> rotate(EAST);
			case 2, -2 -> rotate(SOUTH);
			case 3, -1 -> rotate(WEST);
			default -> rotate(NORTH);
		};
	}
	
	public Direction rotate(Direction northDirection) {
		return switch (this) {
			case NORTH -> this;
			case EAST -> next();
			case SOUTH -> opposite();
			case WEST -> previous();
		};
	}
	
	public Direction next() {
		return switch (this) {
			case NORTH -> EAST;
			case EAST -> SOUTH;
			case SOUTH -> WEST;
			case WEST -> NORTH;
		};
	}
	
	public Direction opposite() {
		return switch (this) {
			case NORTH -> SOUTH;
			case EAST -> WEST;
			case SOUTH -> NORTH;
			case WEST -> EAST;
		};
	}
	
	public Direction previous() {
		return switch (this) {
			case NORTH -> WEST;
			case EAST -> NORTH;
			case SOUTH -> EAST;
			case WEST -> SOUTH;
		};
	}
	//} Methods
}
//} Enums
