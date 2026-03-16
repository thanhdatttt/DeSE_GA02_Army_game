import Soldier.Factory.MedievalFactory;
import Soldier.Factory.SoldierFactory;
import Soldier.Factory.WorldWarFactory;
import Army.Group.Group;
import Equipment.Shield;
import Equipment.Sword;
import Soldier.Proxy.SoldierProxy;
import Visitor.CountVisitor;
import Visitor.DisplayVisitor;

public class Main {
    public static void main(String[] args) {
        // System.out.println("=== BUILD ARMY ===");

        // SoldierFactory medievalFactory = new MedievalFactory();
        // Group medievalInfantrymanGroup = new Group(medievalFactory.createInfantryman(), medievalFactory.createHorseman());

        // SoldierProxy infantry = new SoldierProxy(medievalInfantrymanGroup);

        // infantry.addEquipment(ShieldDecorator::new);
        // infantry.addEquipment(ShieldDecorator::new);
        // infantry.addEquipment(SwordDecorator::new);
        // infantry.addEquipment(SwordDecorator::new);

        // SoldierProxy horseman = new SoldierProxy(medievalFactory.createHorseman());
        // horseman.addShield();
        // horseman.addSword();
        
        // System.out.println("\n=== BATTLE TEST ===");
        // System.out.println("Battle start!");
        // System.out.println("Soldier 1: " + infantry.getName() + " has " + infantry.getHealth() + " health.");
        // System.out.println("Soldier 2: " + horseman.getName() + " has " + horseman.getHealth() + " health.");
        // System.out.println("------------------------- \n");

        // int round = 1;
        // while (infantry.isAlive() && horseman.isAlive()) {
        //     System.out.println("--- Round " + round + " ---");

        //     int damage1 = infantry.hit();
        //     boolean cavSurvives = horseman.wardOff(damage1);
        //     if (!cavSurvives) break;

        //     int damage2 = horseman.hit();
        //     boolean infSurvives = infantry.wardOff(damage2);
        //     if (!infSurvives) break;

        //     System.out.println("\n");
        //     round++;
        // }

        // System.out.println("------------------------- \n");
        // if (infantry.isAlive()) {
        //     System.out.println("Infantry win!");
        // } else {
        //     System.out.println("Horseman win!");
        // }

        // BUILD AMRY ----------------------------------------------
        System.out.println("=== BUILD ARMY ===");
        SoldierFactory medievalFactory = new MedievalFactory();
        SoldierFactory wwFactory       = new WorldWarFactory();

        // medieval army
        SoldierProxy mInf1 = new SoldierProxy(medievalFactory.createInfantryman());
        mInf1.addEquipment(new Sword());
        mInf1.addEquipment(new Shield());
        SoldierProxy mInf2 = new SoldierProxy(medievalFactory.createInfantryman());
        mInf2.addEquipment(new Sword());
        mInf2.addEquipment(new Shield());

        Group mInfantrySquad = new Group(mInf1, mInf2);

        SoldierProxy mHr1 = new SoldierProxy(medievalFactory.createHorseman());
        mHr1.addEquipment(new Sword());
        SoldierProxy mHr2 = new SoldierProxy(medievalFactory.createHorseman());
        mHr2.addEquipment(new Shield());

        Group mHorsemanSquad = new Group(mHr1, mHr2);

        Group medievalArmy = new Group(mInfantrySquad, mHorsemanSquad);

        // ww army
        SoldierProxy wHr1 = new SoldierProxy(wwFactory.createHorseman());
        wHr1.addEquipment(new Sword());
        wHr1.addEquipment(new Shield());

        SoldierProxy wHr2 = new SoldierProxy(wwFactory.createHorseman());
        wHr2.addEquipment(new Sword());
        wHr2.addEquipment(new Shield());

        Group wHorsemanSquad = new Group(wHr1, wHr2);

        Group wwArmy = new Group(wHorsemanSquad);

        System.out.println("-------------------------");

        // DISPLAY AND COUNT ----------------------------------------------
        System.out.println("\n=== DISPLAY AND COUNT ARMY ===");
        DisplayVisitor displayer = new DisplayVisitor();
        CountVisitor counter = new CountVisitor();

        System.out.println("Medieval Amry summary:");
        medievalArmy.accept(displayer);
        medievalArmy.accept(counter);
        counter.printSummary();
        System.out.println("\n");

        System.out.println("World War Amry summary:");
        wwArmy.accept(displayer);
        wwArmy.accept(counter);
        counter.printSummary();

        System.out.println("-------------------------");


        System.out.println("\n=== BATTLE ===");
        System.out.println("Battle start!");
        System.out.println("------------------------- \n");
    }
}
