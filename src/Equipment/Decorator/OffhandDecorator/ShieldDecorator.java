package Equipment.Decorator.OffhandDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

// shield class
public class ShieldDecorator extends EquipmentDecorator {
    public ShieldDecorator(Soldier soldier) {
        super(soldier, "Shield", 2);
    }

    @Override
    public boolean wardOff(int strength) {
        if (getDurability() > 0) {
            System.out.println(soldier.getName() + " uses shield to block half damage.");
            this.useDurability();
            return soldier.wardOff(strength / 2);
        }
        else{
            return soldier.wardOff(strength);
        }
    }

    @Override
    public String getEquipmentType() {
        return "shield";
    }
}