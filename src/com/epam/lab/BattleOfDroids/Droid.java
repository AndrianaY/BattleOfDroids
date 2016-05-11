package com.epam.lab.BattleOfDroids;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public abstract class Droid implements Serializable{
    private Ship ship;


    double[] coordinates = new double[2];
    protected double velocity;
    int repairs;
    Integer power;
    Integer health;
    String name;
    int direction;
    DroidsMap droidsMap;


    Droid(String name, double[] xy, DroidsMap drMap){
        this.name = name;
        coordinates = xy;
        drMap.occupied.put(this, xy);

        System.out.println("droid created at " + coordinates[0] + " " + coordinates[1] + " point");


    }



    public abstract void walk(int direction);
    public Integer getPower(){
        return power;
    }
    public void setPower(Integer power){
        this.power = power;
    }

    public void setHealth(Integer health){
        this.health = health;
    }
    public Integer getHealth(){ return health; }
}
