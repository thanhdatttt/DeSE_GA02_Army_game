package Soldier.Infantryman;

import Equipment.Equipment;
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

    @Override
    public void addEquipment(Equipment equipment) {
        // do nothing
    }
}
