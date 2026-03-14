package Equipment.Decorator;

import Soldier.Soldier;
import Visitor.SoldierVisitor;

// decorator class for equipment
public abstract class EquipmentDecorator implements Soldier {
    protected Soldier soldier;
    protected String equipmentName;
    protected int durability;

    public EquipmentDecorator(Soldier soldier, String name,  int durability) {
        this.soldier = soldier;
        this.equipmentName = name;
        this.durability = durability;
    }

    @Override
    public int hit() { return soldier.hit(); }

    @Override
    public boolean wardOff(int strength) { return soldier.wardOff(strength); }

    @Override
    public boolean isAlive() { return soldier.isAlive(); }

    @Override
    public int getDamage() { return soldier.getDamage(); }

    @Override
    public int getHealth() {
        return soldier.getHealth();
    }

    @Override
    public String getName() {
        return soldier.getName();
    }

    @Override
    public int getSize(){
        return soldier.getSize();
    }

    void useDurability() {
        durability--;
        if (durability == 0) {
            System.out.println(this.equipmentName + " has broken.");
        }
    }

    public abstract String getEquipmentType();

    @Override
    public void accept(SoldierVisitor visitor) {
        visitor.visit(this);
    }

    public Soldier getInnerSoldier() {
        return soldier;
    }
}

