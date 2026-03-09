package Soldier;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    boolean isAlive();
    int getDamage();
    int getHealth();
    String getName();
}
