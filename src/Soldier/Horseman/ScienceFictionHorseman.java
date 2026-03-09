package Soldier.Horseman;

public class ScienceFictionHorseman extends Horseman {
    public ScienceFictionHorseman() {
        this.health = 600;
        this.damage = 225;
        this.isAlive = true;
    }
    @Override
    public String getName() {
        return "Science Fiction Horseman";
    }
}
