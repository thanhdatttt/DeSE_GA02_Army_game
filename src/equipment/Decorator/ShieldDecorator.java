package equipment.Decorator;

import core.Soldier;

// shield class
public class ShieldDecorator extends EquipementDecorator {
    private final int bonusDef  = 10;

    public ShieldDecorator(Soldier soldier) {
        super(soldier);
    }
    
    @Override
    public boolean wardOff(int strength) {
        int damage = Math.max(0, strength - bonusDef);
        System.out.println(" -> [Equip] use Shield to protect: - " + bonusDef + " dmg.");
        System.out.println(" -> Damage taken: " + damage + " dmg.");
        return soldier.wardOff(damage);
    }
    
    @Override
    public String toString() {
        return soldier.toString() + " + Shield";
    }
}
