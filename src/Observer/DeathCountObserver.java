package Observer;

import Soldier.Soldier;

public class DeathCountObserver implements Observer {
    int deathCount = 0;

    private void printDeathCount() {
        System.out.println("Death count: " + deathCount);
    }

    @Override
    public void update(Soldier soldier) {
        deathCount++;
        printDeathCount();
    }
}
