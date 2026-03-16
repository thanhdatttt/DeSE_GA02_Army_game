package Soldier.Infantryman;

public class MedievalInfantryman extends Infantryman {
    public MedievalInfantryman() {
        this.health = 150;
        this.damage = 50;
        this.isAlive = true;
        System.out.println(name + " the medieval infantryman spawned!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Medieval Infantryman";
    }

    @Override
    public void onDeath(){
        if(manager != null){
            manager.notifyObservers(this);
        }
    }
}
