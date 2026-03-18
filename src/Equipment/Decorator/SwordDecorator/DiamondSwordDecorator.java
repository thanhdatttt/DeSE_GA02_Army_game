package Equipment.Decorator.SwordDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class DiamondSwordDecorator extends EquipmentDecorator {
    public DiamondSwordDecorator(Soldier soldier) {
        super(soldier, "Diamond Sword", 6);
    }

    @Override
    public int hit() {
        int bonusAtk = 7 * soldier.getSize();

        if (getDurability() > 0) {
            int total_dmg = 0;
            total_dmg = soldier.hit() + bonusAtk;
            System.out.println(soldier.getName() + " uses diamond sword to deal " + bonusAtk + " more damage.");
            this.useDurability();
            return total_dmg;
        }
        else {
            return soldier.hit();
        }
    }


    @Override
    public String getEquipmentType() {
        return "diamond sword";
    }
}
