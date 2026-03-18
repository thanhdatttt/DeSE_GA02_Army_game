package Equipment.Decorator.ArmorDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class DiamondArmorDecorator extends EquipmentDecorator {
    public DiamondArmorDecorator(Soldier soldier) {super(soldier, "Diamond Armor", 5);}

    @Override
    public boolean wardOff(int strength) {
        int blockDmg = 50 * soldier.getSize();
        if (getDurability() > 0) {
            System.out.println(soldier.getName() + " use diamond armor to reduce " + blockDmg + " damage.");
            this.useDurability();
            return soldier.wardOff(strength - blockDmg);
        }
        else{
            return soldier.wardOff(strength);
        }
    }

    @Override
    public String getEquipmentType() {
        return "diamond armor";
    }
}
