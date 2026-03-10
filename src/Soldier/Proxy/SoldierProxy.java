package Soldier.Proxy;

import Equipment.Equipment;
import Soldier.Soldier;

import java.util.HashSet;
import java.util.Set;

public class SoldierProxy implements Soldier {
    private Soldier soldier;
    private final Set<Class<?>> equipments =  new HashSet<Class<?>>();

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength);
    }

    @Override
    public boolean isAlive() {
        return soldier.isAlive();
    }

    @Override
    public int getDamage() {
        return soldier.getDamage();
    }

    @Override
    public int getHealth() {
        return soldier.getHealth();
    }

    @Override
    public String getName() {
        return soldier.getName();
    }

    @Override
    public void addEquipment(Equipment equipment) {
        if (!equipments.contains(equipment.getClass())) {
            soldier = equipment.equip(soldier);
            equipments.add(equipment.getClass());
        }
    }

    @Override
    public int getSize() {
        return soldier.getSize();
    }
}
