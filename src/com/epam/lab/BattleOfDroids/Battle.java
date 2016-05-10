package com.epam.lab.BattleOfDroids;

import java.io.*;

import static javax.swing.SwingConstants.*;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public class Battle {
    public static void main(String[] args) {
        // enter parameters (repair, droideka, super), name, coordinates
        double[] xy = {0.0, 0.0};
        DroidsMap drMap1;

        SuperDroid dr1;

//


        ObjectInputStream in1= null;
        ObjectInputStream in2= null;
        try {
            in1 = new ObjectInputStream(
                    new FileInputStream("droids.dat"));
            in2 = new ObjectInputStream(
                    new FileInputStream("droidMap.dat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            SuperDroid droidFromFile1 = (SuperDroid)in1.readObject();
            dr1 = droidFromFile1;
            DroidsMap droidFromFile2 = (DroidsMap)in2.readObject();
            drMap1 = droidFromFile2;
            System.out.println("name " + droidFromFile1.name + " coordinates " +  droidFromFile1.coordinates[0] + " " + droidFromFile1.coordinates[1]
                    + droidFromFile1.power + " " + droidFromFile1.velocity);
//            if (drMap1 != null) {
//                if (drMap1.occupied.containsValue(xy)) {
//                    System.out.println("cannot create at x = " + xy[0] + " y = " + xy[1] + " coordinates. they are occupied");
//                }
//            }
            System.out.println("occupied " + droidFromFile2.occupied);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in1.close();
            in2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }








//        if (drMap != null) {
//            if (drMap.occupied.containsKey(xy)) {
//                System.out.println("cannot create at x = " + xy[0] + " y = " + xy[1] + " coordinates. they are occupied");
//            }
//        }
//
//                drMap.occupied.put(dr1, xy);
//        dr1.droidsMap = drMap;
        // enter arrow keys to move
        dr1.walk(RIGHT);
        //enter 's' to shoot
        dr1.shoot();




        ObjectOutputStream out1 = null;
        ObjectOutputStream out2 = null;
        try {
            out1 = new ObjectOutputStream(
                    new FileOutputStream("droids.dat"));
            out2 = new ObjectOutputStream(
                    new FileOutputStream("droidMap.dat"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out1.writeObject(dr1);
            out2.writeObject(drMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out1.close();
            out2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


}
