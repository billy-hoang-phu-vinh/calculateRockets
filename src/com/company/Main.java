package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        Stimulation newStimulation = new Stimulation();

        //load item
        ArrayList<Item> listItem1= new ArrayList<>();
        ArrayList<Item> listItem2= new ArrayList<>();
        //create new rockets
        ArrayList<Rocket> rocket11= new ArrayList<>();
        ArrayList<Rocket> rocket12= new ArrayList<>();
        ArrayList<Rocket> rocket21= new ArrayList<>();
        ArrayList<Rocket> rocket22= new ArrayList<>();

        try{
            listItem1=newStimulation.loadItemsP1();
        } catch (FileNotFoundException fnf) {
            System.out.println("file Not Found");
        }
        try{
            listItem2=newStimulation.loadItemsP2();
        } catch (FileNotFoundException fnf) {
            System.out.println("file Not Found");
        }

        /*phase1*/
        rocket11=newStimulation.LoadU1(listItem1);
        rocket12=newStimulation.LoadU2(listItem1);
        /*phase2*/
        rocket21=newStimulation.LoadU1(listItem2);
        rocket22=newStimulation.LoadU2(listItem2);

        long budget11=0;
        long budget12=0;
        long budget21=0;
        long budget22=0;
        /*phase1*/
        budget11=newStimulation.runSimulation(rocket11);
        budget12=newStimulation.runSimulation(rocket12);
        /*phase2*/
        budget21=newStimulation.runSimulation(rocket21);
        budget22=newStimulation.runSimulation(rocket22);
        System.out.println("test: budget11 la: "+budget11+" million.");
        System.out.println("test: budget12 la: "+budget12+" million.");
        System.out.println("test: budget21 la: "+budget21+" million.");
        System.out.println("test: budget22 la: "+budget22+" million.");

        if (budget11+budget21 > budget12+budget22) {
            System.out.println("U2 is cheaper");
        } else {
            System.out.println("U1 is cheaper");
        }



    }
}
