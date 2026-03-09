package Soldier.Horseman;

public class WorldWarHorseman extends Horseman {
    public WorldWarHorseman() {
        this.health = 300;
        this.damage = 150;
        this.isAlive = true;
    }
    @Override
    public String getName() {
        return "World War Horseman";
    }
}
