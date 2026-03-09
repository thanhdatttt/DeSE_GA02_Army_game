import core.HorsemanSoldier;
import core.InfantrymanSoldier;
import core.Soldier;
import equipment.Decorator.ShieldDecorator;
import equipment.Decorator.SwordDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CREATE SOLDIER & EQUIPMENT ===");

        // infantry with sword and shield
        Soldier infantry = new InfantrymanSoldier();
        infantry = new SwordDecorator(infantry);
        infantry = new ShieldDecorator(infantry);
        
        // horseman with sword
        Soldier cavalry = new HorsemanSoldier();
        cavalry = new SwordDecorator(cavalry);
        cavalry = new SwordDecorator(cavalry);

        System.out.println("\n=== BATTLE TEST ===");
        System.out.println("Battle start!");
        System.out.println("soldier 1 inrantry: " + infantry.getHealth());
        System.out.println("Soldier 2 horseman: " + cavalry.getHealth());
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
