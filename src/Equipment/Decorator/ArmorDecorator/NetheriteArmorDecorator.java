package Equipment.Decorator.ArmorDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class NetheriteArmorDecorator extends EquipmentDecorator {
    public NetheriteArmorDecorator(Soldier soldier) {super(soldier, "Netherite Armor", 5);}

    @Override
    public boolean wardOff(int strength) {
        int blockDmg = 75 * soldier.getSize();
        if (getDurability() > 0) {
            System.out.println(soldier.getName() + " use netherite armor to reduce " + blockDmg + " damage.");
            this.useDurability();
            return soldier.wardOff(strength - blockDmg);
        }
        else{
            return soldier.wardOff(strength);
        }
    }

    @Override
    public String getEquipmentType() {
        return "netherite armor";
    }
}
