package Soldier.Horseman;

public class MedievalHorseman extends Horseman {
    public MedievalHorseman() {
        this.health = 200;
        this.damage = 75;
        this.isAlive = true;
        System.out.println(name + " the medieval horseman spawned!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Medieval Horseman";
    }

    @Override
    public void onDeath(){
        if(manager != null){
            manager.notifyObservers(this);
        }
    }
}
