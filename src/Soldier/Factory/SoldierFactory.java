package Soldier.Factory;

import Soldier.Horseman.Horseman;
import Soldier.Infantryman.Infantryman;

public interface SoldierFactory {
    abstract Horseman createHorseman();
    abstract Infantryman createInfantryman();
}
