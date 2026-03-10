package Soldier.Factory;

import Soldier.Horseman.WorldWarHorseman;
import Soldier.Infantryman.WorldWarInfantryman;
import Soldier.Soldier;

public class WorldWarFactory implements  SoldierFactory {
    @Override
    public Soldier createHorseman() {
        return new WorldWarHorseman();
    }

    @Override
    public Soldier createInfantryman() {
        return new WorldWarInfantryman();
    }
}
