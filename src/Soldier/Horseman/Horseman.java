package Soldier.Horseman;

import Soldier.Soldier;

public abstract class Horseman implements Soldier {
    int health;
    int damage;
    boolean isAlive;

    Horseman() {
        isAlive = true;
        System.out.println("Horseman has been created");
    }

    @Override
    public int hit() {
        return this.damage;
    }

    @Override
    public boolean wardOff(int strength) {
        if (strength <= this.health) {
            this.health -= strength;
            return true;
        }
        this.isAlive = false;
        return false;
    }

    @Override
    public boolean isAlive() {
        return this.isAlive;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void addShield(){
        // do nothing
    }

    @Override
    public void addSword(){
        // do nothing
    }
}