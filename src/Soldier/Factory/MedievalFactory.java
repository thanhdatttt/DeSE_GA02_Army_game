package Soldier.Factory;

import Soldier.Horseman.MedievalHorseman;
import Soldier.Infantryman.MedievalInfantryman;
import Soldier.Soldier;

public class MedievalFactory implements SoldierFactory {
    @Override
    public Soldier createHorseman() {
        return new MedievalHorseman();
    }

    @Override
    public Soldier createInfantryman() {
        return new MedievalInfantryman();
    }
}
