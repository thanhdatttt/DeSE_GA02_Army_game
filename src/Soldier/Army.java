package Soldier;

import java.util.List;

public class Army implements Soldier {
    private final List<Soldier> soldiers;


    Army(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    @Override
    public int hit() {
        int total_dmg = 0;
        for(Soldier soldier : soldiers) {
            total_dmg += soldier.hit();
        };
        return total_dmg;
    }

    @Override
    public boolean wardOff(int strength) {
        int intake_dmg = strength / soldiers.size();
        soldiers.removeIf(soldier -> !soldier.wardOff(intake_dmg));
        return isAlive();
    }

    @Override
    public boolean isAlive() {
        return !soldiers.isEmpty();
    }

    @Override
    public int getHealth() {
        int total_health = 0;
        for(Soldier soldier : soldiers) {
            total_health += soldier.hit();
        };
        return total_health;
    }

    @Override
    public String getName() {
        return "Army";
    }

    @Override
    public void addShield() {
        for (Soldier soldier : soldiers) {
            soldier.addShield();
        }
    }

    @Override
    public void addSword() {
        for (Soldier soldier : soldiers) {
            soldier.addSword();
        }

    }

    public void addSoldier(Soldier soldier){
        soldiers.add(soldier);
    }
}
