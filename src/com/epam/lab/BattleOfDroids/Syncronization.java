package com.epam.lab.BattleOfDroids;

import java.io.*;

/**
 * Created by Andriana_Yarmoliuk on 5/11/2016.
 */
public class Syncronization {
    private static Syncronization instance;
    private Syncronization(){

    }
    public static synchronized Syncronization getInstance() {
        if (instance == null) {
            instance = new Syncronization();
        }
        return instance;
    }

    public static DroidsMap loadMap(){
        ObjectInputStream in= null;
        DroidsMap droidsMap = null;

        try {
            in = new ObjectInputStream(
                    new FileInputStream("droidMap.dat"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("there is no map(s)");
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


        if(!(in==null)){
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("cannot close the stream");
            }
        }


        if(droidsMap == null) {
            droidsMap = DroidsMap.getInstance();
        }
        return droidsMap;
    }



    public static void saveMap(DroidsMap map){

        ObjectOutputStream out = null;
        try {

            out = new ObjectOutputStream(
                    new FileOutputStream("droidMap.dat"));

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("file was not created");
        }
        try {

            out.writeObject(map);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("map was not saved");
        }
        if (!(out==null)){
            try {
                out.close();
                System.out.println("closing the stream");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("cannot close stream");
            }
        }

    }
}
