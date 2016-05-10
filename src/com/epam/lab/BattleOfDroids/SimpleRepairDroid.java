package com.epam.lab.BattleOfDroids;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public class SimpleRepairDroid extends Droid implements RepairDroid {
    SimpleRepairDroid(String name, double[] xy, DroidsMap drM){
        super(name, xy, drM);
        power = 0;
        health = 50;
        repairs = 5;
        velocity = 5;
    }
    public void walk(int directions){

    }
    public void rest(){

    }
    public void repair(){
        if(repairs > 0) {
            health =  health + 10;
            repairs = repairs - 1;
            System.out.println("***health + 10***");
        }
        else
            System.out.println("Your repairdroid is no able to medicine anymore! Take some rest!");

    }

//    public void repair(Droid droidToRepair){
//        if(repairs > 0) {
//            droidToRepair.health =  droidToRepair.health + 10;
//            repairs = repairs - 1;
//        }
//    }
}
