package com.company;

interface SpaceShip {
    boolean launch();//method, return true or false
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}
