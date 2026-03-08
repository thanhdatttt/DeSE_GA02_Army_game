package Soldier;

public class ScienceFictionFactory implements SoldierFactory {
    @Override
    public Horseman createHorseman() {
        return new ScienceFictionHorseman();
    }

    @Override
    public Infantryman createInfantryman() {
        return new  ScienceFictionInfantryman();
    }
}
