package Soldier.Factory;

import Soldier.Soldier;

public interface SoldierFactory {
    abstract Soldier createHorseman();
    abstract Soldier createInfantryman();
}
