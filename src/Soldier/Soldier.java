package Soldier;

import Soldier.Visitor.SoldierVisitor;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    boolean isAlive();
    int getDamage();
    int getHealth();
    String getName();
    int getSize();

    void accept(SoldierVisitor visitor);
}
