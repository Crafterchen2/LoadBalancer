package com.github.crafterchen2.loadbalancer.enums;

public enum Direction {

    //Entries
    NORTH,
    EAST,
    SOUTH,
    WEST,
    ;

    //Fields

    //Constructor

    //Methods
    public Direction rotate(int rotateAmount){
        return switch (rotateAmount % 4) {
            case 1, -3 -> next();
            case 2, -2 -> opposite();
            case 3, -1 -> previous();
            default -> this;
        };
    }

    public Direction next(){
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }

    public Direction opposite(){
        return switch (this) {
            case NORTH -> SOUTH;
            case EAST -> WEST;
            case SOUTH -> NORTH;
            case WEST -> EAST;
        };
    }

    public Direction previous(){
        return switch (this) {
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
    }

    //Getter

    //Setter

    //Overrides from
    ////<class>

}
