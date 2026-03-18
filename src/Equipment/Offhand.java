package Equipment;

import Equipment.Decorator.OffhandDecorator.GoldenAppleDecorator;
import Equipment.Decorator.OffhandDecorator.ShieldDecorator;
import Equipment.Decorator.OffhandDecorator.TotemOfUndyingDecorator;
import Soldier.Soldier;

public class Offhand implements Equipment {
    @Override
    public Soldier equip(Soldier soldier) {
        String type = soldier.getType().strip().split(" ")[0];

        return switch (type) {
            case "Medieval" -> new ShieldDecorator(soldier);
            case "World" -> new GoldenAppleDecorator(soldier);
            case "Science" -> new TotemOfUndyingDecorator(soldier);
            default -> soldier;
        };
    }
}
