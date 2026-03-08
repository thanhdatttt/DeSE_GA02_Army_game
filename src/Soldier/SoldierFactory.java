package Soldier;

public interface SoldierFactory {
    abstract Horseman createHorseman();
    abstract Infantryman createInfantryman();
}
