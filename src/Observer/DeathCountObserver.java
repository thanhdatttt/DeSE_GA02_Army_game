package Observer;

import Soldier.Soldier;

public class DeathCountObserver implements Observer {
    private int deathCount = 0;
    private static final DeathCountObserver instance = new DeathCountObserver();

    private DeathCountObserver() {}

    @Override
    public void update(Soldier soldier) {
        deathCount++;
        System.out.println("Death count: " + deathCount);
    }

    public static DeathCountObserver getInstance() {
        return instance;
    }
}
