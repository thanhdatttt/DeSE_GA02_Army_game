package Soldier.Horseman;

public class WorldWarHorseman extends Horseman {
    public WorldWarHorseman() {
        this.health = 300;
        this.damage = 150;
        this.isAlive = true;
        System.out.println(name + " the world war horseman spawned!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "World War Horseman";
    }

    @Override
    public void onDeath(){
        if(manager != null){
            manager.notifyObservers(this);
        }
    }
}
