package Soldier;

public abstract class Horseman {
    int hit() {
        return 0;
    }

    boolean wardOff(int strength) {
        return false;
    }

    boolean isAlive() {
        return false;
    }

    int getHealth() {
        return 0;
    }
}
