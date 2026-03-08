package Soldier;

public class WorldWarFactory implements  SoldierFactory {
    @Override
    public Horseman createHorseman() {
        return new WorldWarHorseman();
    }

    @Override
    public Infantryman createInfantryman() {
        return new  WorldWarInfantryman();
    }
}
