package com.company;

public class Rocket implements SpaceShip{
    int cost;
    int currentWeight;
    int maxWeight;
    int weight;//rocket itselft

    @Override
    public boolean launch(){
        return true;
    }
    @Override
    public boolean land(){
        return true;
    }
    //carry and canCarry is not implemented in U1 u2 -> final method
    @Override
    public final void carry(Item item){
        //weight+weight?
        currentWeight=currentWeight+item.weight;
    }
    public int getCost(){
        return cost;
    }
    public final boolean canCarry(Item item){
        if (currentWeight+item.weight<=maxWeight) {
            return true;
        } else {
            return false;
        }
    }


}
