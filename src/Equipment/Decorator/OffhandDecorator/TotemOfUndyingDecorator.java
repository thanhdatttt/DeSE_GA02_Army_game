package Equipment.Decorator.OffhandDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class TotemOfUndyingDecorator extends EquipmentDecorator {
    public TotemOfUndyingDecorator(Soldier soldier) {
        super(soldier, "Totem Of Undying", 1);
    }

    @Override
    public boolean wardOff(int strength) {
        int currentHealth = soldier.getHealth();
        if (getDurability() > 0 && currentHealth < strength) {
            System.out.println("Totem of Undying popped...");
            this.useDurability();
            return true;
        }
        else {
            return soldier.wardOff(strength);
        }
    }

    @Override
    public String getEquipmentType() {
        return "totem of undying";
    }
}
