package equipment.Decorator;

import Soldier.Soldier;

// decorator class for equipment
public abstract class EquipmentDecorator implements Soldier {
    protected Soldier soldier;

    public EquipmentDecorator(Soldier soldier) { this.soldier = soldier; }

    @Override
    public int hit() { return soldier.hit(); }

    @Override
    public boolean wardOff(int strength) { return soldier.wardOff(strength); }

    @Override
    public boolean isAlive() { return soldier.isAlive(); }

    @Override
    public int getDamage() { return soldier.getDamage(); }

    @Override
    public int getHealth() {
        return soldier.getHealth();
    }

    @Override
    public String getName() {
        return soldier.getName();
    }

    public abstract String getEquipmentType();
}
