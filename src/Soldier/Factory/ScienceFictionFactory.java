package Soldier.Factory;

import Soldier.Horseman.ScienceFictionHorseman;
import Soldier.Infantryman.ScienceFictionInfantryman;
import Soldier.Soldier;

public class ScienceFictionFactory implements SoldierFactory {
    @Override
    public Soldier createHorseman() {
        return new ScienceFictionHorseman();
    }

    @Override
    public Soldier createInfantryman() {
        return new ScienceFictionInfantryman();
    }
}
