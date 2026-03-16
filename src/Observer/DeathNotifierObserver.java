package Observer;

import Soldier.Soldier;

public class DeathNotifierObserver implements Observer {
    private void printDeathMessage(String name, String type) {
        System.out.println(name + " the " + type + " died in glory!");
        System.out.println("Sending compensation email to " + name + "'s relative...");
    }

    @Override
    public void update(Soldier soldier) {
        printDeathMessage(soldier.getName(), soldier.getType());
    }
}
