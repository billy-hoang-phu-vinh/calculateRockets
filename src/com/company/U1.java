package com.company;

public class U1 extends Rocket {
    //default constructor
    U1(){
        weight=10000;
        cost=100;
        currentWeight=10000; //include weight cargo and itself
        maxWeight=18000;
    }
    @Override
    public boolean launch(){
        boolean result;
        //generate random
        //check random -> return the result
        double randomNum = ((Math.random())*100);

        double crit = 5*((double)(currentWeight-weight)/(maxWeight-weight));

        if(randomNum<=crit) {
            result=false;
            System.out.println("No? ten lua1 o Launch()");
        } else{result=true;
        }

        return result;
    }
    @Override
    public boolean land(){
        boolean result;
        //generate random
        //check random -> return the result
        double randomNum = ((Math.random())*100);
        double crit = 1*((double)(currentWeight-weight)/maxWeight-weight);

        if(randomNum<=crit) {
            result=false;
            System.out.println("debug critFail "+crit+" soRandom "+randomNum);
        } else{result=true;}

        return result;
    }
}
