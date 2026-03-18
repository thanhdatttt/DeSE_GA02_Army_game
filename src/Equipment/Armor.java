package Equipment;

import Equipment.Decorator.ArmorDecorator.DiamondArmorDecorator;
import Equipment.Decorator.ArmorDecorator.IronArmorDecorator;
import Equipment.Decorator.ArmorDecorator.NetheriteArmorDecorator;
import Soldier.Soldier;

public class Armor implements Equipment {
    @Override
    public Soldier equip(Soldier soldier) {
        String type = soldier.getType().strip().split(" ")[0];

        return switch (type) {
            case "Medieval" -> new IronArmorDecorator(soldier);
            case "World" -> new DiamondArmorDecorator(soldier);
            case "Science" -> new NetheriteArmorDecorator(soldier);
            default -> soldier;
        };
    }
}
