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
        System.out.println(getName() + " deals " + damage + " damage.");
        return this.damage;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println(getName() + " takes " + strength + " damage.");
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
    public int getDamage() {
        return this.damage;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getSize(){
        return 1;
    }
}