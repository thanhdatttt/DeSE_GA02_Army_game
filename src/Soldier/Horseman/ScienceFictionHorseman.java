package Soldier.Horseman;

public class ScienceFictionHorseman extends Horseman {
    public ScienceFictionHorseman() {
        this.health = 600;
        this.damage = 225;
        this.isAlive = true;
        System.out.println(name + " the science fiction horseman spawned!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Science Fiction Horseman";
    }

    @Override
    public void onDeath(){
        if(manager != null){
            manager.notifyObservers(this);
        }
    }
}
