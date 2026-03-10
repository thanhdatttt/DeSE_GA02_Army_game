package Equipment;

import Decorator.SwordDecorator;
import Soldier.Soldier;

public class Sword implements Equipment {
    @Override
    public Soldier equip(Soldier soldier) {
        return new SwordDecorator(soldier);
    }
}
