package Equipment;

import Equipment.Decorator.SwordDecorator;
import Soldier.Soldier;

public class Sword implements Equipment {

    @Override 
    public String getName() {
        return "Sword";
    }

    @Override
    public Soldier equip(Soldier soldier) {
        return new SwordDecorator(soldier);
    }
}
