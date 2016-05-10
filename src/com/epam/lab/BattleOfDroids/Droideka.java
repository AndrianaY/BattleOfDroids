package com.epam.lab.BattleOfDroids;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public class Droideka extends Droid implements BattleDroid {
    Droideka(String name, double[] xy, DroidsMap drM){
        super(name, xy, drM);
        power = 50;
        health = 100;
        repairs = 0;
        velocity = 5;
    }
    public void walk(int direction){

    }
    public void shoot(){
        if(power > 0) {
            setPower((power - 10));
            System.out.println("***power - 10***");
        }
        else
            System.out.println("No more ammunition! Run!!!");
    }
}
