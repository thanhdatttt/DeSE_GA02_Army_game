package Equipment;

import Decorator.SwordDecorator;
import Soldier.Soldier;

public interface Equipment {
    Soldier equip(Soldier soldier);
}
