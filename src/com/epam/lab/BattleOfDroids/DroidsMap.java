package com.epam.lab.BattleOfDroids;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Andriana_Yarmoliuk on 5/10/2016.
 */
public class DroidsMap implements Serializable{
    public HashMap<Droid, double[]> occupied = new HashMap<>();
}
