package com.github.crafterchen2.loadbalancer.enums;

import com.github.crafterchen2.loadbalancer.util.Capacity;

import java.awt.image.BufferedImage;

public enum Belt {

    //Entries
    NO_BELT(0,Capacity.zero,null,Translation.NO_BELT),
    MK1(1,new Capacity(60 ,Unit.MIN),null,Translation.BELT_MK_1),
    MK2(2,new Capacity(120,Unit.MIN),null,Translation.BELT_MK_2),
    MK3(3,new Capacity(270,Unit.MIN),null,Translation.BELT_MK_3),
    MK4(4,new Capacity(480,Unit.MIN),null,Translation.BELT_MK_4),
    MK5(5,new Capacity(780,Unit.MIN),null,Translation.BELT_MK_5),
    ;

    //Fields
    public final int mk;
    public final Capacity capacity;
    private final BufferedImage img;
    public final Translation key;

    //Constructor
    Belt(int mk, Capacity capacity, BufferedImage img, Translation key) {
        this.mk = mk;
        this.capacity = capacity;
        this.img = img;
        this.key = key;
    }

    //Methods

    //Getter
    private BufferedImage getImg() {
        return img;
    }

    //Setter

    //Overrides from
    ////<class>

}
