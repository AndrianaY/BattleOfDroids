package com.epam.lab.BattleOfDroids;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Andriana_Yarmoliuk on 5/10/2016.
 */
public class DroidsMap implements Serializable{
    private static DroidsMap instance;
    private DroidsMap(){

    }
    public static synchronized DroidsMap getInstance() {
        if (instance == null) {
            instance = new DroidsMap();
        }
        return instance;
    }

    public HashMap<Droid, double[]> occupied = new HashMap<>();
}
