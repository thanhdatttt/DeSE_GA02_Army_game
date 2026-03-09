package Soldier.Infantryman;

public class WorldWarInfantryman extends Infantryman {
    public WorldWarInfantryman() {
        this.health = 300;
        this.damage = 100;
        this.isAlive = true;
    }
    @Override
    public String getName() {
        return "World War Infantryman";
    }
}
