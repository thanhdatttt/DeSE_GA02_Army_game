package Visitor;

import Army.Group.Group;
import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;
import Soldier.Horseman.Horseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Proxy.SoldierProxy;

public class CountVisitor implements SoldierVisitor {
    private int infantryCount = 0;
    private int horsemanCount  = 0;

    @Override
    public void visit(Infantryman infantryman) {
        infantryCount++;
    }

    @Override
    public void visit(Horseman horseman) {
        horsemanCount++;
    }

    @Override
    public void visit(Group group) {
    }

    @Override
    public void visit(SoldierProxy proxy) {
        // Unwrap the decorator chain to reach the real soldier type.
        Soldier inner = proxy.getInnerSoldier();
 
        // If proxy wraps a Group, let the group traverse its own children.
        if (inner instanceof Group) {
            inner.accept(this);
            return;
        }
 
        // Walk past any equipment decorators to find the base type.
        while (inner instanceof EquipmentDecorator) {
            inner = ((EquipmentDecorator) inner).getInnerSoldier();
        }
 
        if (inner instanceof Infantryman) {
            infantryCount++;
        } else if (inner instanceof Horseman) {
            horsemanCount++;
        }
    }

    @Override
    public void visit(EquipmentDecorator decorator) {
        // Reached when a bare EquipmentDecorator is accepted directly.
        // Unwrap to count the underlying soldier.
        Soldier inner = decorator.getInnerSoldier();
        while (inner instanceof EquipmentDecorator) {
            inner = ((EquipmentDecorator) inner).getInnerSoldier();
        }
        if (inner instanceof Infantryman) 
            infantryCount++;
        else if (inner instanceof Horseman) 
            horsemanCount++;
    }

    @Override
    public void exitGroup() {   
    }

    public int getInfantryCount() { return infantryCount; }
    public int gethorsemanCount()  { return horsemanCount; }
 
    public void printSummary() {
        System.out.println("=== Count Summary ===");
        System.out.println("  Infantry : " + infantryCount);
        System.out.println("  Horseman : " + horsemanCount);
        System.out.println("  Total    : " + (infantryCount + horsemanCount));
        reset();
    }
 
    // Reset counters
    private void reset() {
        infantryCount = 0;
        horsemanCount  = 0;
    }
}
