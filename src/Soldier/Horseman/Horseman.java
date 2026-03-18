package Soldier.Horseman;

import Equipment.Equipment;
import Observer.ObserverManager;
import Soldier.Soldier;
import Visitor.SoldierVisitor;
import Generator.NameGenerator;

public abstract class Horseman implements Soldier {
    protected String name;
    protected int health;
    protected int damage;
    protected boolean isAlive;
    protected ObserverManager manager = null;

    Horseman() {
        name = NameGenerator.getName();
    }

    @Override
    public int hit() {
        System.out.println(getName() + " deals " + damage + " damage.");
        return this.damage;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println(getName() + " takes " + strength + " damage.");
        if (strength < this.health) {
            this.health -= strength;
            return true;
        }
        this.isAlive = false;
        onDeath();
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
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean setManager(ObserverManager manager) {
        this.manager = manager;
        return true;
    }

    @Override
    public void heal(int amount) {
        this.health += amount;
    }

    @Override
    public Soldier addEquipment(Equipment equipment){
        return equipment.equip(this);
    }

}