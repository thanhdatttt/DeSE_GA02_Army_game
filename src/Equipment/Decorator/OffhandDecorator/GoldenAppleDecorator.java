package Equipment.Decorator.OffhandDecorator;

import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;

public class GoldenAppleDecorator extends EquipmentDecorator {
    public GoldenAppleDecorator(Soldier soldier) {
        super(soldier, "Golden Apple", 3);
    }

    @Override
    public boolean wardOff(int strength) {
        if(getDurability() > 0) {
            System.out.println("Eating Golden Apple... (+100 health)");
            this.useDurability();
            soldier.heal(100);
        }
        return soldier.wardOff(strength);
    }

    @Override
    public String getEquipmentType() {
        return "golden apple";
    }
}
