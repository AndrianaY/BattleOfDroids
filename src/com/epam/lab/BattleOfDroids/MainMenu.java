package com.epam.lab.BattleOfDroids;

import javax.management.relation.Role;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;

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
        String choise = "";

        out.println("1 - create new droid\n2 - show list of droids (in saved map)\n3 - delete droid\n4 - exit");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            choise = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("cannot read the input");
        }
        if (choise.equals("1") || choise.equalsIgnoreCase("create")){
            {CreateNewDroidMenu.getInstance(); CreateNewDroidMenu.newDroid(map);}
        }
        else if(choise.equals("2") || choise.equalsIgnoreCase("show")){
            {LoadDroidsMapMenu.getInstance(); LoadDroidsMapMenu.showMapList(map);}
        }
        else if(choise.equals("3") || choise.equalsIgnoreCase("delete")){
            {DeleteDroidsMenu.getInstance(); DeleteDroidsMenu.deleteDroid("super1", map);}
        }
        else
            System.out.println("enter correct parameter");


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
            //todo: create appropriate droid

            return new SuperDroid("super3", new double[]{150.0, 200.0}, map);
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
        public static void showMapList(DroidsMap map){
            System.out.println("there is the list of available droids");
            for(Map.Entry <Droid, double[]> entry : map.occupied.entrySet()) {
                System.out.println(entry.getKey().name + " is at " + entry.getValue()[0] + " " + entry.getValue()[1] + " position");
            }
        }
    }

    public static class DeleteDroidsMenu {
        private static DeleteDroidsMenu instance;

        private DeleteDroidsMenu() {

        }

        public static synchronized DeleteDroidsMenu getInstance() {
            if (instance == null) {
                instance = new DeleteDroidsMenu();
            }
            return instance;
        }

        public static DroidsMap deleteDroid(String name, DroidsMap map){


            return map;
        }
    }


}
