package core;

// infantryman class
public class InfantrymanSoldier implements Soldier {
    private int health = 100;
    private final int baseAtk = 10;

    @Override
    public int hit() {
        System.out.println("  -> [Base] Infantryman use fists to punch, base damage: " + baseAtk + " dmg.");
        return baseAtk;
    }

    @Override
    public boolean wardOff(int strength) {
        this.health -= strength;
        System.out.println("  -> [Base] Infantryman take damage: " + strength + " dmg.");
        System.out.println("=> Infantry HP: " + Math.max(0, this.health));
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
