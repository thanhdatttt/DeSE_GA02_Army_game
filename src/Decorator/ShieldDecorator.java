package Decorator;

import Soldier.Soldier;

// shield class
public class ShieldDecorator extends EquipmentDecorator {
    public ShieldDecorator(Soldier soldier) {
        super(soldier, "Shield", 5);
    }

    @Override
    public boolean wardOff(int strength) {
        int bonusDef = 10 * soldier.getSize();
        if (durability > 0) {
            System.out.println(soldier.getName() + " uses shield to block " +  bonusDef + " damage.");
            this.useDurability();
            int damage = Math.max(0, strength - bonusDef);
            return soldier.wardOff(damage);
        }
        else{
            return soldier.wardOff(strength);
        }
    }

    @Override
    public String getName() {
        return soldier.getName() + " with shield";
    }
}