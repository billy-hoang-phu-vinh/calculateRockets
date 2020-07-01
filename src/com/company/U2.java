package com.company;

public class U2 extends Rocket {
    //default constructor
    U2(){
        weight=18000;
        cost=120;
        currentWeight=18000;
        maxWeight=29000;
    }
    @Override
    public boolean launch(){
        boolean result;
        //generate random
        //check random -> return the result
        double randomNum = ((Math.random())*100);
        double crit = 4*((double)(currentWeight-weight)/(maxWeight-weight));

        if(randomNum<=crit) {
            result=false;
            System.out.println("debug No launch "+crit+" soRandom "+randomNum);
        } else{result=true;}

        return result;
    }
    @Override
    public boolean land(){
        boolean result;
        //generate random
        //check random -> return the result
        double randomNum = ((Math.random())*100);

        double crit = 8*((double)(currentWeight-weight)/(maxWeight-weight));

        if(randomNum<=crit) {
            result=false;
            System.out.println("debug no? land()"+crit+" soRandom "+randomNum);
        } else{result=true;}

        return result;
    }
}
