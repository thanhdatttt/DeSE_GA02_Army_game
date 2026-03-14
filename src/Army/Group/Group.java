package Army.Group;

import Soldier.Soldier;
import Visitor.SoldierVisitor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Group implements Soldier {
    private List<Soldier> soldiers = new ArrayList<Soldier>();


    public Group(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }
    public Group(Soldier... Soldiers) {
        Collections.addAll(this.soldiers, Soldiers);
    }

    @Override
    public int hit() {
        int total_dmg = 0;
        for(Soldier soldier : soldiers) {
            total_dmg += soldier.getDamage();
        };
        System.out.println(getName() + " deals " + total_dmg + " damage.");
        return total_dmg;
    }

    @Override
    public boolean wardOff(int strength) {
        System.out.println(getName() + " takes " + strength + " damage.");
        int intake_dmg = strength / soldiers.size();
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
    public String getName() {
        return "Group Soldier";
    }

    public void addSoldier(Soldier soldier){
        soldiers.add(soldier);
    }

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
        for (Soldier soldier : this.soldiers) {
            soldier.accept(visitor);
        }
        visitor.exitGroup();
    }
}
