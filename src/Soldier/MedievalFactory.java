package Soldier;

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
