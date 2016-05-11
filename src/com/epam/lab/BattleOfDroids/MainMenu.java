package com.epam.lab.BattleOfDroids;

import static java.lang.System.*;

/**
 * Created by Andriana_Yarmoliuk on 5/11/2016.
 */
public class MainMenu {
    private static MainMenu instance;
    private MainMenu(){

    }
    public static synchronized MainMenu getInstance() {
        if (instance == null) {
            instance = new MainMenu();
        }
        return instance;
    }



    public void mainMenu(DroidsMap map){
        out.println("1 - create new droid \n2 - load droids map \n3 - delete droid \n4 - exit");
        String param = null;
        //todo: parse input
        switch (param){
            case "1": {CreateNewDroidMenu.getInstance(); CreateNewDroidMenu.newDroid(map);}
            case "2": {LoadDroidsMapMenu.getInstance();}
        }

    }

    public static class CreateNewDroidMenu{
        private static CreateNewDroidMenu instance;
        private CreateNewDroidMenu(){

        }
        public static synchronized CreateNewDroidMenu getInstance() {
            if (instance == null) {
                instance = new CreateNewDroidMenu();
            }
            return instance;
        }

        public static Droid newDroid(DroidsMap map){

            System.out.println("input name, type and coordinates");
            //todo: implement console input
            //todo: create droid

            return new SuperDroid("super1", new double[]{50.0, 50.0}, map);
        }

    }

    public static class LoadDroidsMapMenu{
        private static LoadDroidsMapMenu instance;
        private LoadDroidsMapMenu(){

        }
        public static synchronized LoadDroidsMapMenu getInstance() {
            if (instance == null) {
                instance = new LoadDroidsMapMenu();
            }
            return instance;
        }
    }

}
