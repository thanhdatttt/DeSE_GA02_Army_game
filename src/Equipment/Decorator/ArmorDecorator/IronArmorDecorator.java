package Equipment.Decorator.ArmorDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class IronArmorDecorator extends EquipmentDecorator {
    public IronArmorDecorator(Soldier soldier) {super(soldier, "Iron Armor", 5);}

    @Override
    public boolean wardOff(int strength) {
        int blockDmg = 25 * soldier.getSize();
        if (getDurability() > 0) {
            System.out.println(soldier.getName() + " use iron armor to reduce " + blockDmg + " damage.");
            this.useDurability();
            return soldier.wardOff(strength - blockDmg);
        }
        else{
            return soldier.wardOff(strength);
        }
    }

    @Override
    public String getEquipmentType() {
        return "iron armor";
    }
}
