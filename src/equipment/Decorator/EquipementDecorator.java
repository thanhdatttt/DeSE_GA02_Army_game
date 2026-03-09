package equipment.Decorator;

import core.Soldier;

// decorator class for equipment
public abstract class EquipementDecorator implements Soldier {
    protected Soldier soldier;

    public EquipementDecorator(Soldier soldier) {
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
}
