package equipment.Decorator;

import Soldier.Soldier;

// sword class
public class SwordDecorator extends EquipmentDecorator {
    public SwordDecorator(Soldier soldier) {
        super(soldier, "Sword", 5);
    }

    @Override
    public int hit() {
        if (durability > 0) {
            useDurability();
            int bonusAtk = 20;
            int damage = this.soldier.hit() + bonusAtk;
            System.out.println(" -> " + soldier.getName() + " uses Sword to slash: +" + bonusAtk + " dmg.");
            System.out.println(" -> Total damage: " + damage + " dmg.");
            return damage;
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