import Army.Group.Group;
import Equipment.*;
import Observer.*;
import Soldier.Factory.MedievalFactory;
import Soldier.Factory.ScienceFictionFactory;
import Soldier.Factory.SoldierFactory;
import Soldier.Factory.WorldWarFactory;
import Soldier.Proxy.SoldierProxy;
import Soldier.Soldier;
import Visitor.CountVisitor;
import Visitor.DisplayVisitor;


public class Main {
    public static void main(String[] args) {
        // SETUP ENVIRONMENT
        SoldierFactory medievalFactory = new MedievalFactory();
        SoldierFactory wwFactory       = new WorldWarFactory();
        SoldierFactory sfFactory       = new ScienceFictionFactory();

        Equipment mainWeapon = new MainWeapon();
        Equipment offhand = new Offhand();
        Equipment armor = new Armor();

        DeathCountObserver deathCountObserver = DeathCountObserver.getInstance();
        DeathNotifierObserver deathNotifierObserver = DeathNotifierObserver.getInstance();
        ObserverManager manager = new ObserverManager();
        manager.subscribe(deathNotifierObserver);
        manager.subscribe(deathCountObserver);


        // BUILD ARMY ----------------------------------------------
        System.out.println("=== BUILD ARMY ===");

        Soldier mInfantry = medievalFactory.createInfantryman();
        Soldier mHorseman = medievalFactory.createHorseman();
        Soldier wwInfantry = wwFactory.createInfantryman();
        Soldier wwHorseman = wwFactory.createHorseman();
        Soldier sfInfantry = sfFactory.createInfantryman();
        Soldier sfHorseman1 = sfFactory.createHorseman();
//        Soldier sfHorseman2 = sfFactory.createHorseman();

        Group m_wwGroup = new Group(mInfantry, mHorseman, wwInfantry, wwHorseman);
        Group sfGroup = new Group(sfInfantry, sfHorseman1);

        Soldier m_ww_Proxy = new SoldierProxy(m_wwGroup);
        Soldier sf_Proxy = new SoldierProxy(sfGroup);

        m_ww_Proxy = m_ww_Proxy.addEquipment(mainWeapon);
        m_ww_Proxy = m_ww_Proxy.addEquipment(offhand);
        m_ww_Proxy = m_ww_Proxy.addEquipment(armor);

        sf_Proxy = sf_Proxy.addEquipment(offhand);

        m_ww_Proxy.setManager(manager);
        sf_Proxy.setManager(manager);

        System.out.println("-------------------------");

        // DISPLAY AND COUNT ----------------------------------------------
        System.out.println("\n=== DISPLAY AND COUNT ARMY ===");
        DisplayVisitor displayer = new DisplayVisitor();
        CountVisitor counter = new CountVisitor();

        System.out.println(m_ww_Proxy.getName() + " Army summary:");
        m_ww_Proxy.accept(displayer);
        m_ww_Proxy.accept(counter);
        counter.printSummary();
        System.out.println("\n");

        System.out.println(sf_Proxy.getName() + " Army summary:");
        sf_Proxy.accept(displayer);
        sf_Proxy.accept(counter);
        counter.printSummary();

        System.out.println("-------------------------");
        System.out.println("\n=== BATTLE TEST ===");
        System.out.println("Battle start!");
        System.out.println("Army 1: " + m_ww_Proxy.getName() + " has " + m_ww_Proxy.getHealth() + " health.");
        System.out.println("Army 2: " + sf_Proxy.getName() + " has " + sf_Proxy.getHealth() + " health.");
        System.out.println("------------------------- \n");

        int round = 1;
        while (m_ww_Proxy.isAlive() && sf_Proxy.isAlive()) {
            System.out.println("--- Round " + round + " ---");

            int damage = m_ww_Proxy.hit();
            boolean isAlive = sf_Proxy.wardOff(damage);
            if (!isAlive) break;
            damage = sf_Proxy.hit();
            isAlive = m_ww_Proxy.wardOff(damage);
            if (!isAlive) break;
            System.out.println("\n");
            round++;
        }
        System.out.println("------------------------- \n");
        if (m_ww_Proxy.isAlive()) {
            System.out.println(m_ww_Proxy.getName() +" Army win!");
        } else {
            System.out.println(sf_Proxy.getName() + " Army win!");
        }
    }
}
