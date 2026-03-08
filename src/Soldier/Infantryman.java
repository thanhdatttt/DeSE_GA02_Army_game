package Soldier;

public abstract class Infantryman {
    int health;
    int damage;
    boolean isAlive;

    Infantryman() {
        isAlive = true;
        System.out.println("Infantryman has been created");
    }

    int hit() {
        return this.damage;
    }

    boolean wardOff(int strength) {
        return strength >= this.health;
    }

    boolean isAlive() {
        return this.isAlive;
    }

    int getDamage() {
        return this.damage;
    }

    int getHealth() {
        return this.health;
    }
}
