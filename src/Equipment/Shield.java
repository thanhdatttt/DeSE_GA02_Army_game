package Equipment;

import Decorator.ShieldDecorator;
import Soldier.Soldier;

public class Shield implements Equipment {
    @Override
    public Soldier equip(Soldier soldier) {
        return new ShieldDecorator(soldier);
    }
}
