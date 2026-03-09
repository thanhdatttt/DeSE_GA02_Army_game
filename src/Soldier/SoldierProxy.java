package Soldier;

import equipment.Decorator.ShieldDecorator;
import equipment.Decorator.SwordDecorator;

public class SoldierProxy implements Soldier{
    private Soldier soldier;
    private boolean hasShield = false;
    private boolean hasSword = false;

    public SoldierProxy(Soldier soldier) {
        this.soldier = soldier;
    }

    @Override
    public int hit() {
        return soldier.hit();
    }

    @Override
    public boolean wardOff(int strength) {
        return soldier.wardOff(strength);
    }

    @Override
    public boolean isAlive() {
        return soldier.isAlive();
    }

    @Override
    public int getHealth() {
        return soldier.getHealth();
    }

    @Override
    public String getName() {
        return "Soldier Proxy";
    }

    @Override
    public void addShield() {
        if (!hasShield) {
            soldier = new ShieldDecorator(soldier);
            hasShield = true;
        }
    }

    @Override
    public void addSword() {
        if (!hasSword) {
            soldier = new SwordDecorator(soldier);
            hasSword = true;
        }
    }
}
