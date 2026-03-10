package Soldier.Factory;

import Soldier.Horseman.Horseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Soldier;

public interface SoldierFactory {
    abstract Soldier createHorseman();
    abstract Soldier createInfantryman();
}
