package equipment.Decorator;

import Soldier.Soldier;

// shield class
public class ShieldDecorator extends EquipmentDecorator {
    public ShieldDecorator(Soldier soldier) {
        super(soldier, "Shield", 5);
    }

    @Override
    public boolean wardOff(int strength) {
        if (durability > 0) {
            this.useDurability();
            int bonusDef = 10;
            int damage = Math.max(0, strength - bonusDef);
            System.out.println(" -> " + soldier.getName() + " uses Shield to protect: - " + bonusDef + " dmg.");
            System.out.println(" -> Damage taken: " + damage + " dmg.");
            return soldier.wardOff(damage);
        }
        else
            return soldier.wardOff(strength);
    }

    @Override
    public String getName() {
        return soldier.getName() + " with shield";
    }
}