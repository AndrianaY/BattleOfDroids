package com.epam.lab.BattleOfDroids;

import java.util.HashMap;
import java.util.Map;

import static javax.swing.SwingConstants.*;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public class SuperDroid extends Droid implements RepairDroid, BattleDroid {


    SuperDroid(String name, double[] xy, DroidsMap drM){
        super(name, xy, drM);
        power = 100;
        health = 100;
        repairs = 5;
        velocity = 10;
    }
    public void repair(){
        if(repairs > 0) {
            health =  health + 10;
            repairs = repairs - 1;
            System.out.println("***health + 10***");
        }
        else
            System.out.println("Your superdroid is not able to medicine anymore! Take some rest!");

    }
    public void rest(){

    }
    public void walk(int direction){
        double[] newCoord = new double[2];
        System.arraycopy(coordinates, 0, newCoord, 0, 2);

        this.direction = direction;
        switch (direction){
            case (LEFT): {
               newCoord[0] = (this.coordinates[0] - velocity);
                if(this.droidsMap.occupied.containsKey(newCoord)){
                    System.out.println("cannot move to x = " + newCoord[0] + " coordinate. it is occupied");
                    break;
                }
                else {
                    this.coordinates[0] = newCoord[0];
                    this.droidsMap.occupied.replace(this, this.coordinates);
                }
            }
            case (RIGHT): {
                newCoord[0] = (newCoord[0] + velocity);

                System.out.println("moving to x =  " + newCoord[ 0 ] + " y =  " + newCoord [1]);
                System.out.println("occupied coordinayes before " + this.droidsMap.occupied.get(this)[0] + " " + this.droidsMap.occupied.get(this)[1]);
                for (Map.Entry<Droid, double[]> entry : this.droidsMap.occupied.entrySet()){
                    if(newCoord[0]==entry.getValue()[0]){
                        System.out.println("cannot move to x = " + newCoord[0] + " coordinate. it is occupied");

                    }
                    else {
                        this.coordinates[0] = newCoord[0];
                        entry.setValue(this.coordinates);
                        System.out.println("occupied coordinayes after " + entry.getValue()[0] + " " + entry.getValue()[1]);
                    }
                }


            }
            case (TOP): {
               newCoord[1] = (newCoord[1] + velocity);
                if(newCoord[1]==this.droidsMap.occupied.get(this)[1]){
                    System.out.println("cannot move to y = " + newCoord[1] + " coordinate. it is occupied");
                    break;
                }
                else {
                    this.coordinates[1] = newCoord[1];
                    this.droidsMap.occupied.replace(this, this.coordinates);
                }
            }
            case (BOTTOM): {
                newCoord[1] = (newCoord[1] - velocity);
                if (newCoord[1] == this.droidsMap.occupied.get(this)[1]) {
                    System.out.println("cannot move to y = " + newCoord[1] + " coordinate. it is occupied");
                    break;
                } else {
                    this.coordinates[1] = newCoord[1];
                    this.droidsMap.occupied.replace(this, this.coordinates);
                }
            }
        }
    }
    public void shoot(){
        if(power > 0) {
            setPower((power - 10));
            System.out.println("shooting. power " + getPower());
            if(direction == LEFT){
                //todo: entryset occupied.getkey[0]< this.coordinates[0]
                //occupied value.health = - 10
            }
            else if(direction == RIGHT){
                //todo: entryset occupied.getkey[0]< this.coordinates[0]
            }
            else if (direction == TOP){
                //todo: entryset occupied.getkey[1]< this.coordinates[1]
            }
            else if (direction == BOTTOM){
                //todo: entryset occupied.getkey[1] < this.coordinates[1]
            }
        }


        else
            System.out.println("No more ammunition! Run!!!");
    }
}
