package equipment.Decorator;

import Soldier.Soldier;

// sword class
public class SwordDecorator extends EquipmentDecorator {

    public SwordDecorator(Soldier soldier) {
        super(soldier);
    }

    @Override
    public int hit() {
        int bonusAtk = 20;
        int damage = soldier.hit() + bonusAtk;
        System.out.println(" -> " + soldier.getName() + " uses Sword to slash: +" + bonusAtk + " dmg.");
        System.out.println(" -> Total damage: " + damage + " dmg.");
        return damage;
    }

    @Override
    public String getName() {
        return soldier.getName() + " with sword";
    }
}