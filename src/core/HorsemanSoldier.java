package core;

public class HorsemanSoldier implements Soldier {
    private int health = 150;
    private final int baseAtk = 20;

    @Override
    public int hit() {
        System.out.println("  -> [Base] Horseman attacks with horse, base damage: " + baseAtk + " dmg.");
        return baseAtk;
    }

    @Override
    public boolean wardOff(int strength) {
        this.health -= strength;
        System.out.println("  -> [Base] Horseman take damage: " + strength + " dmg.");
        System.out.println("=> Horseman HP: " + Math.max(0, this.health));
        return isAlive();
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public int getHealth() {
        return health;
    }
}
