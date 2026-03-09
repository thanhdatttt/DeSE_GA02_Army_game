import Soldier.Factory.MedievalFactory;
import Soldier.Factory.SoldierFactory;
import Soldier.Soldier;
import equipment.Decorator.ShieldDecorator;
import equipment.Decorator.SwordDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CREATE SOLDIER & EQUIPMENT ===");

        SoldierFactory medievalFactory = new MedievalFactory();

        // infantry with sword and shield
        Soldier infantry = medievalFactory.createInfantryman();
        infantry = new SwordDecorator(infantry);
        infantry = new ShieldDecorator(infantry);
        
        // horseman with sword
        Soldier cavalry = medievalFactory.createHorseman();
        cavalry = new SwordDecorator(cavalry);
        cavalry = new ShieldDecorator(cavalry);

        System.out.println("\n=== BATTLE TEST ===");
        System.out.println("Battle start!");
        System.out.println("Soldier 1: " + infantry.getName() + " has " + infantry.getHealth() + " health.");
        System.out.println("Soldier 2: " + cavalry.getName() + " has " + cavalry.getHealth() + " health.");
        System.out.println("------------------------- \n");

        int round = 1;
        while (infantry.isAlive() && cavalry.isAlive()) {
            System.out.println("--- Round " + round + " ---");
            
            int damage1 = infantry.hit();
            boolean cavSurvives = cavalry.wardOff(damage1);
            if (!cavSurvives) break;

            int damage2 = cavalry.hit();
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
