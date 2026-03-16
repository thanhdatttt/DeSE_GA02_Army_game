package Soldier.Infantryman;

public class ScienceFictionInfantryman extends Infantryman {
    public ScienceFictionInfantryman() {
        this.health = 450;
        this.damage = 150;
        this.isAlive = true;
        System.out.println(name + " the science fiction infantryman spawned!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "Science Fiction Infantryman";
    }

    @Override
    public void onDeath(){
        if(manager != null){
            manager.notifyObservers(this);
        }
    }
}
