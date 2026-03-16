package Soldier.Proxy;

import Equipment.Equipment;
import Soldier.Soldier;
import Visitor.SoldierVisitor;

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

    public void addEquipment(Equipment equipment) {
        if (!equipments.contains(equipment.getClass())) {
            System.out.println(soldier.getName() + " successfully added " + equipment.getName());
            soldier = equipment.equip(soldier);
            equipments.add(equipment.getClass());
        }
            System.out.println("!!!  " + soldier.getName() + " already has " + equipment.getName());
    }

    @Override
    public int getSize() {
        return soldier.getSize();
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        soldier.accept(visitor);
    }

    public Soldier getInnerSoldier() {
        return this.soldier;
    }
}
