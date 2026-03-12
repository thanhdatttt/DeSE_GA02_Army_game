
import Soldier.Factory.MedievalFactory;
import Soldier.Factory.SoldierFactory;
import Soldier.Group.Group;
import Equipment.Decorator.ShieldDecorator;
import Equipment.Decorator.SwordDecorator;
import Soldier.Proxy.SoldierProxy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CREATE SOLDIER & EQUIPMENT ===");

        SoldierFactory medievalFactory = new MedievalFactory();
        Group medievalInfantrymanGroup = new Group(medievalFactory.createInfantryman(), medievalFactory.createHorseman());

        SoldierProxy infantry = new SoldierProxy(medievalInfantrymanGroup);

        infantry.addEquipment(ShieldDecorator::new);
        infantry.addEquipment(ShieldDecorator::new);
        infantry.addEquipment(SwordDecorator::new);
        infantry.addEquipment(SwordDecorator::new);

        SoldierProxy horseman = new SoldierProxy(medievalFactory.createHorseman());
        horseman.addShield();
        horseman.addSword();
        

        System.out.println("\n=== BATTLE TEST ===");
        System.out.println("Battle start!");
        System.out.println("Soldier 1: " + infantry.getName() + " has " + infantry.getHealth() + " health.");
        System.out.println("Soldier 2: " + horseman.getName() + " has " + horseman.getHealth() + " health.");
        System.out.println("------------------------- \n");

        int round = 1;
        while (infantry.isAlive() && horseman.isAlive()) {
            System.out.println("--- Round " + round + " ---");

            int damage1 = infantry.hit();
            boolean cavSurvives = horseman.wardOff(damage1);
            if (!cavSurvives) break;

            int damage2 = horseman.hit();
            boolean infSurvives = infantry.wardOff(damage2);
            if (!infSurvives) break;

            System.out.println("\n");
            round++;
        }

        System.out.println("------------------------- \n");
        if (infantry.isAlive()) {
            System.out.println("Infantry win!");
        } else {
            System.out.println("Horseman win!");
        }
    }
}
