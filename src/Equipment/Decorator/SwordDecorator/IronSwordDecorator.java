package Equipment.Decorator.SwordDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

// sword class
public class IronSwordDecorator extends EquipmentDecorator {
    public IronSwordDecorator(Soldier soldier) {
        super(soldier, "Iron Sword", 5);
    }

    @Override
    public int hit() {
        int bonusAtk = 5 * soldier.getSize();
        if (getDurability() > 0) {
            int total_dmg = 0;
            total_dmg = soldier.hit() + bonusAtk;
            System.out.println(soldier.getName() + " uses iron sword to deal " + bonusAtk + " more damage.");
            this.useDurability();
            return total_dmg;
        }
        else {
            return soldier.hit();
        }
    }

    @Override
    public String getEquipmentType() {
       return "iron sword";
    }
}