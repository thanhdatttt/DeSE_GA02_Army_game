package Soldier.Proxy;

import Equipment.Equipment;
import Observer.ObserverManager;
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

    @Override
    public String getType() {
        return soldier.getType();
    }


    @Override
    public Soldier addEquipment(Equipment equipment) {
        if (!equipments.contains(equipment.getClass())) {
            System.out.println(soldier.getName() + " successfully added " + equipment.getClass().getSimpleName());
            equipments.add(equipment.getClass());
            soldier = soldier.addEquipment(equipment);
        }
        else {
            System.out.println("!!!  " + soldier.getName() + " already has " + equipment.getClass().getSimpleName());
        }
        return soldier;
    }

    @Override
    public int getSize() {
        return soldier.getSize();
    }

    @Override
    public boolean setManager(ObserverManager manager) {
        return soldier.setManager(manager);
    }

    @Override
    public void onDeath() {
        soldier.onDeath();
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        soldier.accept(visitor);
    }

    @Override
    public void heal(int amount) {
        soldier.heal(amount);
    }

    public Soldier getInnerSoldier() {
        return this.soldier;
    }
}
