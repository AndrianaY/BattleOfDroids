package com.epam.lab.BattleOfDroids;

import java.io.*;

import static javax.swing.SwingConstants.*;

/**
 * Created by Andriana_Yarmoliuk on 5/4/2016.
 */
public class Battle {
    public static void main(String[] args) {

        MainMenu menu = MainMenu.getInstance();

        DroidsMap map = Syncronization.readMap();

        if(map ==null){

            map = DroidsMap.getInstance();
        }

        menu.mainMenu(map);


        Syncronization.saveMap(map);











    }


}
