package Soldier.Infantryman;

public class ScienceFictionInfantryman extends Infantryman {
    public ScienceFictionInfantryman() {
        this.health = 450;
        this.damage = 150;
        this.isAlive = true;
    }
    @Override
    public String getName() {
        return "Science Fiction Infantryman";
    }
}
