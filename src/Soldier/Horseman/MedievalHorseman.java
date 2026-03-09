package Soldier.Horseman;

public class MedievalHorseman extends Horseman {
    public MedievalHorseman() {
        this.health = 200;
        this.damage = 75;
        this.isAlive = true;
    }

    @Override
    public String getName() {
        return "Medieval Horseman";
    }
}
