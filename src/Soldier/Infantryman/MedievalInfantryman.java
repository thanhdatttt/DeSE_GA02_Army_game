package Soldier.Infantryman;

public class MedievalInfantryman extends Infantryman {
    public MedievalInfantryman() {
        this.health = 150;
        this.damage = 50;
        this.isAlive = true;
    }
    @Override
    public String getName() {
        return "Medieval Infantryman";
    }
}
