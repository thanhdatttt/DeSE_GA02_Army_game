package Equipment.Decorator;

import Equipment.Equipment;
import Observer.ObserverManager;
import Soldier.Soldier;
import Visitor.SoldierVisitor;

// decorator class for equipment
public abstract class EquipmentDecorator implements Soldier {
    protected Soldier soldier;
    protected String equipmentName;
    private int durability;

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
    public String getType() {
        return soldier.getType();
    }

    @Override
    public int getSize(){
        return soldier.getSize();
    }

    protected int getDurability() {
        return durability;
    }

    protected void useDurability() {
        this.durability--;
        if (this.durability == 0) {
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

    @Override
    public boolean setManager(ObserverManager manager) {
        return soldier.setManager(manager);
    }

    @Override
    public void onDeath() {
        soldier.onDeath();
    }

    @Override
    public void heal(int amount) {
        soldier.heal(amount);
    }

    @Override
    public Soldier addEquipment(Equipment equipment){
        return equipment.equip(this);
    }

}

