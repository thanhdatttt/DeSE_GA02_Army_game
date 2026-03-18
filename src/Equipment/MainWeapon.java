package Equipment;

import Equipment.Decorator.SwordDecorator.DiamondSwordDecorator;
import Equipment.Decorator.SwordDecorator.IronSwordDecorator;
import Equipment.Decorator.SwordDecorator.NetheriteSwordDecorator;
import Soldier.Soldier;

public class MainWeapon implements Equipment {
    @Override
    public Soldier equip(Soldier soldier) {
        String type = soldier.getType().strip().split(" ")[0];

        return switch (type) {
            case "Medieval" -> new IronSwordDecorator(soldier);
            case "World" -> new DiamondSwordDecorator(soldier);
            case "Science" -> new NetheriteSwordDecorator(soldier);
            default -> soldier;
        };
    }
}
