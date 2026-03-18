package Equipment.Decorator.SwordDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class NetheriteSwordDecorator extends EquipmentDecorator {
    public NetheriteSwordDecorator(Soldier soldier) {
        super(soldier, "Netherite Sword", 7);
    }

    @Override
    public int hit() {
        int bonusAtk = 9 * soldier.getSize();
        if (getDurability() > 0) {
            int total_dmg;
            total_dmg = soldier.hit() + bonusAtk;
            System.out.println(soldier.getName() + " uses netherite sword to deal " + bonusAtk + " more damage.");
            this.useDurability();
            return total_dmg;
        } else {
            return soldier.hit();
        }
    }

    @Override
    public String getEquipmentType() {
        return "netherite sword";
    }
}