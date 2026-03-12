package Soldier.Proxy;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import Soldier.Soldier;
import Equipment.Decorator.EquipmentDecorator;
import Equipment.Decorator.ShieldDecorator;
import Equipment.Decorator.SwordDecorator;

public class SoldierProxy implements Soldier {

    private Soldier soldier;
    private Set<String> equipments = new HashSet<>();

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    public void addEquipment(Function<Soldier, EquipmentDecorator> creator) {
        EquipmentDecorator equipment = creator.apply(soldier);
        String type = equipment.getEquipmentType();

        if (this.equipments.contains(type)) {
            System.out.println(soldier.getName() + " already has " + type);
            return;
        }

        equipments.add(type);
        System.out.println(soldier.getName() + " successfully added " + type);
        soldier = equipment;
        
    }

    public void addShield() {
        if (this.equipments.contains("shield")) {
            System.out.println(soldier.getName() + " already has shield");
            return;
        } else {
            System.out.println(soldier.getName() + " successfully added shield");
            soldier = new ShieldDecorator(soldier);
            equipments.add("shield");
        }
    }

    public void addSword() {
        if (this.equipments.contains("sword")) {
            System.out.println(soldier.getName() + " already has sword");
            return;
        } else {
            System.out.println(soldier.getName() + " successfully added sword");
            soldier = new SwordDecorator(soldier);
            equipments.add("sword");
        }
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
    public int getSize() {
        return soldier.getSize();
    }
}
