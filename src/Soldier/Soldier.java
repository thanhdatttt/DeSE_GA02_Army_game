package Soldier;

import Equipment.Equipment;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    boolean isAlive();
    int getDamage();
    int getHealth();
    String getName();
    void addEquipment(Equipment equipment);
    int getSize();
}
