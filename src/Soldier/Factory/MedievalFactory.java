package Soldier.Factory;

import Soldier.Horseman.Horseman;
import Soldier.Horseman.MedievalHorseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Infantryman.MedievalInfantryman;

public class MedievalFactory implements SoldierFactory {
    @Override
    public Horseman createHorseman() {
        return new MedievalHorseman();
    }

    @Override
    public Infantryman createInfantryman() {
        return new MedievalInfantryman();
    }
}
