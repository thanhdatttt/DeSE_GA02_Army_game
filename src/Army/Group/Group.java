package Army.Group;


import Equipment.Equipment;
import Generator.NameGenerator;
import Observer.ObserverManager;
import Soldier.Soldier;
import Visitor.SoldierVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group implements Soldier {
    private final List<Soldier> soldiers = new ArrayList<Soldier>();
    private final String name;

    public Group(Soldier... Soldiers) {
        Collections.addAll(this.soldiers, Soldiers);
        name =  NameGenerator.getArmies();
        System.out.println(name + " established!");
    }

    @Override
    public int hit() {
        int total_dmg = 0;
        for(Soldier soldier : soldiers) {
            total_dmg += soldier.hit();
        };
        System.out.println(getName() + " deals " + total_dmg + " damage.");
        return total_dmg;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println(getName() + " takes " + strength + " damage.");
        int intake_dmg = strength / this.getSize();
        soldiers.removeIf(soldier -> !soldier.wardOff(intake_dmg));
        return isAlive();
    }

    @Override
    public boolean isAlive() {
        return !soldiers.isEmpty();
    }

    @Override
    public int getDamage() {
        int total_dmg = 0;
        for (Soldier soldier : soldiers) {
            total_dmg += soldier.getDamage();
        }
        return  total_dmg;
    }

    @Override
    public int getHealth() {
        int total_health = 0;
        for(Soldier soldier : soldiers) {
            total_health += soldier.getHealth();
        };
        return total_health;
    }

    @Override
    public int getSize(){
        int total_size = 0;
        for(Soldier soldier : soldiers) {
            total_size += soldier.getSize();
        }
        return total_size;
    }

    @Override
    public String getType() {
        return "Group Soldier";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
        for (Soldier soldier : this.soldiers) {
            soldier.accept(visitor);
        }
        visitor.exitGroup();
    }

    @Override
    public boolean setManager(ObserverManager manager) {
        for  (Soldier soldier : soldiers) {
            soldier.setManager(manager);
        }
        return true;
    }

    @Override
    public void onDeath() {}

    @Override
    public void heal(int amount) {
        for (Soldier soldier : soldiers) {
            soldier.heal(amount);
        }
    }

    @Override
    public Soldier addEquipment(Equipment equipment) {
        soldiers.replaceAll(soldier -> soldier.addEquipment(equipment));
        return this;
    }
}
