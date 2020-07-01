package com.company;

import  java.util.ArrayList;
import  java.io.File;
import  java.util.Scanner;
import java.io.FileNotFoundException;
public class Stimulation {
    ArrayList<Item> arrayitem;

    ArrayList<Item> loadItemsP1() throws FileNotFoundException {

        ArrayList<Item> loadManifest = new ArrayList();
        Scanner fileScanner = new Scanner(new File("phase-1.txt"));

        while (fileScanner.hasNextLine()) {
            Item newItem = new Item();
            String[] list = fileScanner.nextLine().split("=");
            newItem.name=list[0];
            newItem.weight=Integer.parseInt(list[list.length-1]);//index -1
            //debug
            loadManifest.add(newItem);
        }
        return loadManifest;
    }
    ArrayList<Item> loadItemsP2() throws FileNotFoundException {

        ArrayList<Item> loadManifest = new ArrayList();
        Scanner fileScanner = new Scanner(new File("phase-2.txt"));

        while (fileScanner.hasNextLine()) {
            Item newItem = new Item();
            String[] list = fileScanner.nextLine().split("=");
            newItem.name=list[0];
            newItem.weight=Integer.parseInt(list[list.length-1]);//index -1
            loadManifest.add(newItem);
        }
        return loadManifest;
    }
    ArrayList<Rocket> LoadU1(ArrayList<Item> list) {
        //to fill list of rocket
        ArrayList<Rocket> newlistofU1 = new ArrayList();
        Rocket newEachRocket = new U1(); //type of U1
        for (Item item:list){
            //each item, fill to list U1
            if(newEachRocket.canCarry(item)){
                //add item
                //debug
                newEachRocket.carry(item);
            } else {
                //close this rocket
                newlistofU1.add(newEachRocket);
                //create new for carrying this one
                newEachRocket = new U1(); //type of U1
                newEachRocket.carry(item);
            }
        }
        if (list.size()!=0) {
            //the last item need to add
            newlistofU1.add(newEachRocket);
        }

        return newlistofU1;
    }
    ArrayList<Rocket> LoadU2(ArrayList<Item> list) {
        //to fill list of rocket
        ArrayList<Rocket> newlistofU1 = new ArrayList();
        Rocket newEachRocket = new U2(); //type of U1
        for (Item item:list){
            //each item, fill to list U1
            if(newEachRocket.canCarry(item)){
                //add item
                newEachRocket.carry(item);
            } else {
                //close this rocket
                newlistofU1.add(newEachRocket);
                //create new for carrying this one
                newEachRocket = new U2(); //type of U1
                newEachRocket.carry(item);
            }
        }
        if (list.size()!=0) {
            //the last item need to add
            newlistofU1.add(newEachRocket);
        }

        return newlistofU1;
    }

    /**
     * Takes an ArrayList of Rockets and attempts launching and landing them until both are successful for each rocket
     * and keeps track of the total budget required to send all the rockets safely to Mars and returns it
     *
     * @param rocketsListToBeChecked an ArrayList of Rockets to be sent to Mars
     * @return an integer depicting total budget required to send all rockets (including the crashed ones) to Mars
     */
    long runSimulation (ArrayList<Rocket> rocketsListToBeChecked) {
        long budget = 0;
        int x=0;
        for (Rocket rocket:rocketsListToBeChecked){
            do {
                budget+=rocket.getCost();
                x++;
                System.out.println("so ten lua su dung: "+x);
            } while( !( rocket.launch() && rocket.land() ) );//while land OR launch fail -> do again
        }
        return budget;
    }
}
