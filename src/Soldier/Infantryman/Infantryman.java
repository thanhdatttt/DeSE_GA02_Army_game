package Soldier.Infantryman;

import Soldier.Soldier;

public abstract class Infantryman implements Soldier {
    int health;
    int damage;
    boolean isAlive;

    Infantryman() {
        isAlive = true;
        System.out.println("Infantryman has been created");
    }

    @Override
    public int hit() { return this.damage; }

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
