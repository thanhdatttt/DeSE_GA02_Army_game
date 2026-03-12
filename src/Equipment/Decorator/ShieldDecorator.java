package Equipment.Decorator;

import Soldier.Soldier;

// shield class
public class ShieldDecorator extends EquipmentDecorator {
    public ShieldDecorator(Soldier soldier) {
        super(soldier);
    }
    
    @Override
    public String getName() {
        return soldier.getName() + " with shield";
    }

    @Override
    public boolean wardOff(int strength) {
        int bonusDef = 10;
        int damage = Math.max(0, strength - bonusDef);
        System.out.println(" -> " + soldier.getName() + " uses shield to protect: - " + bonusDef + " dmg.");
        System.out.println(" -> Damage taken: " + damage + " dmg.");
        return soldier.wardOff(damage);
    }


    @Override
    public String getEquipmentType() {
        return "shield";
    }
}