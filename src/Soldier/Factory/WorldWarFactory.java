package Soldier.Factory;

import Soldier.Horseman.Horseman;
import Soldier.Horseman.WorldWarHorseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Infantryman.WorldWarInfantryman;

public class WorldWarFactory implements  SoldierFactory {
    @Override
    public Horseman createHorseman() {
        return new WorldWarHorseman();
    }

    @Override
    public Infantryman createInfantryman() {
        return new WorldWarInfantryman();
    }
}
