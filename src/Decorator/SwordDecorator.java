package Decorator;

import Soldier.Soldier;

// sword class
public class SwordDecorator extends EquipmentDecorator {
    public SwordDecorator(Soldier soldier) {
        super(soldier, "Sword", 5);
    }

    @Override
    public int hit() {
        int bonusAtk = 20 * soldier.getSize();

        if (durability > 0) {
            useDurability();
            int total_dmg = 0;
            total_dmg = soldier.hit() + bonusAtk;
            System.out.println(soldier.getName() + " uses sword to deal " + bonusAtk + " more damage.");
            return total_dmg;
        }
        else {
            return soldier.hit();
        }
    }

    @Override
    public String getName() {
        return soldier.getName() + " with sword";
    }
}