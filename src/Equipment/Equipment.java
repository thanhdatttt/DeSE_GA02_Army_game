package Equipment;

import Soldier.Soldier;

public interface Equipment {
    String getName();
    Soldier equip(Soldier soldier);
}
