package Decorator;

import Equipment.Equipment;
import Soldier.Soldier;

// decorator class for equipment
public abstract class EquipmentDecorator implements Soldier {
    protected String equipmentName;
    protected Soldier soldier;
    protected int durability;

    public EquipmentDecorator(Soldier soldier, String name, int durability) {
        this.soldier = soldier;
        this.equipmentName = name;
        this.durability = durability;
    }

    @Override
    public int hit() { return soldier.hit(); }

    @Override
    public boolean wardOff(int strength) { return soldier.wardOff(strength); }

    @Override
    public boolean isAlive() { return soldier.isAlive(); }

    @Override
    public int getDamage() {
        return soldier.getDamage();
    }

    @Override
    public int getHealth() {
        return soldier.getHealth();
    }

    @Override
    public int getSize(){
        return soldier.getSize();
    }

    void useDurability() {
        durability--;
        if (durability == 0) {
            System.out.println(this.equipmentName + " has broken.");
        }
    }

    @Override
    public void addEquipment(Equipment equipment) {
        // do nothing
    }
}
