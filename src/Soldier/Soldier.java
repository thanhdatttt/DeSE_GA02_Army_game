package Soldier;

import Observer.ObserverManager;
import Visitor.SoldierVisitor;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    boolean isAlive();
    int getDamage();
    int getHealth();
    String getName();
    String getType();
    int getSize();

    boolean setManager(ObserverManager manager);
    void onDeath();
    void accept(SoldierVisitor visitor);
}
