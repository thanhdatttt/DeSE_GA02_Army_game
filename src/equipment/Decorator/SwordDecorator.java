package equipment.Decorator;

import core.Soldier;

// sword class
public class SwordDecorator extends EquipementDecorator {
    private final int bonusAtk = 20;

    public SwordDecorator(Soldier soldier) {
        super(soldier);   
    }
    
    @Override
    public int hit() {
        int damage = soldier.hit() + bonusAtk;
        System.out.println(" -> [Equip] use Sword to slash: +" + bonusAtk + " dmg.");
        System.out.println(" -> Total damage: " + damage + " dmg.");
        return damage;
    }
    
    @Override
    public String toString() {
        return soldier.toString() + " + Sword";
    }
}
