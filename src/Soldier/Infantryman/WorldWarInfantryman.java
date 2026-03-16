package Soldier.Infantryman;

public class WorldWarInfantryman extends Infantryman {
    public WorldWarInfantryman() {
        this.health = 300;
        this.damage = 100;
        this.isAlive = true;
        System.out.println(name + " the world war infantryman spawned!");
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getType() {
        return "World War Infantryman";
    }

    @Override
    public void onDeath(){
        if(manager != null){
            manager.notifyObservers(this);
        }
    }
}
