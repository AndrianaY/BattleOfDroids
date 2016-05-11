package com.epam.lab.BattleOfDroids;

import java.io.*;

import static javax.swing.SwingConstants.*;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public class Battle {
    public static void main(String[] args) {



        ObjectInputStream in= null;
        DroidsMap droidsMap = null;

        try {
            in = new ObjectInputStream(
            new FileInputStream("droidMap.dat"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("there is no file(s)");
        }
        if(!(in == null)) {
            try {
                droidsMap = (DroidsMap) in.readObject();
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace();
                System.out.println("something wrong with reading map");
            }
        }


        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(droidsMap == null) {
            droidsMap = DroidsMap.getInstance();
        }

        System.out.println("1 - create new droid \n 2 - load saved droid \n 3 - delete droid \n 4 - exit");











        ObjectOutputStream out = null;
        try {

            out = new ObjectOutputStream(
                    new FileOutputStream("droidMap.dat"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {

            out.writeObject(droidsMap);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }




    }


}
