package com.epam.lab.BattleOfDroids;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public abstract class Droid {
    Integer power;
    String name;
    public abstract void walk();
    public Integer getPower(){
        return power;
    }
    public void setPower(Integer power){
        this.power = power;
    }

    Droid(String name){
        this.name = name;
    }
}
