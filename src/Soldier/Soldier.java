package Soldier;

public interface Soldier {
    int hit();
    boolean wardOff(int strength);
    boolean isAlive();
    int getHealth();
    String getName();
    void addShield();
    void addSword();
}
