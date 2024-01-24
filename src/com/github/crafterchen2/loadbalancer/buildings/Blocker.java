package com.github.crafterchen2.loadbalancer.buildings;

import com.github.crafterchen2.loadbalancer.enums.Direction;
import com.github.crafterchen2.loadbalancer.util.BuildingPort;

import java.util.HashMap;

public class Blocker extends Building{

    //Fields

    //Constructor
    protected Blocker(Direction northDirection) {
        super(northDirection);
    }

    //Methods

    //Getter

    //Setter

    //Overrides from
    ////Building
    @Override
    public void updatePortSpeeds() {

    }

    @Override
    public HashMap<Direction, BuildingPort> getRotatedConfig() {
        return getConfig();
    }
}
