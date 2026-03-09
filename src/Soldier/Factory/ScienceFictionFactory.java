package Soldier.Factory;

import Soldier.Horseman.Horseman;
import Soldier.Horseman.ScienceFictionHorseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Infantryman.ScienceFictionInfantryman;

public class ScienceFictionFactory implements SoldierFactory {
    @Override
    public Horseman createHorseman() {
        return new ScienceFictionHorseman();
    }

    @Override
    public Infantryman createInfantryman() {
        return new ScienceFictionInfantryman();
    }
}
