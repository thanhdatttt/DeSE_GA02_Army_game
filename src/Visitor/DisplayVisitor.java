package Visitor;

import java.util.ArrayList;
import java.util.List;

import Army.Group.Group;
import Equipment.Decorator.EquipmentDecorator;
import Soldier.Soldier;
import Soldier.Horseman.Horseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Proxy.SoldierProxy;

public class DisplayVisitor implements SoldierVisitor {
    private int groupDepth = 0;
    private List<String> equipments = new ArrayList<>();

    @Override
    public void visit(Group group) {
        String indent = "  ".repeat(groupDepth);
        System.out.println(indent + group.getName()
                + " — size: " + group.getSize()
                + ", base HP: " + group.getHealth()
                + ", base DMG: " + group.getDamage());
        groupDepth++;
    }

    @Override
    public void visit(Infantryman infantryman) {
        String indent = "  ".repeat(groupDepth);
        String eq = equipments.isEmpty() ? "none" : String.join(", ", equipments);
        System.out.println(indent + infantryman.getName()
                + " | HP: " + infantryman.getHealth()
                + " | DMG: " + infantryman.getDamage()
                + " | Equipment: " + eq);
    }

    @Override
    public void visit(Horseman horseman) {
        String indent = "  ".repeat(groupDepth);
        String eq = equipments.isEmpty() ? "none" : String.join(", ", equipments);
        System.out.println(indent + horseman.getName()
                + " | HP: " + horseman.getHealth()
                + " | DMG: " + horseman.getDamage()
                + " | Equipment: " + eq);
    }

    @Override
    public void visit(SoldierProxy proxy) {
        Soldier inner = proxy.getInnerSoldier();
        if(inner == null) {
            System.out.println("Unknown Soldier");
            return;
        }
        inner.accept(this);
    }

    @Override
    public void visit(EquipmentDecorator decorator) {
        equipments.add(decorator.getEquipmentType());
        decorator.getInnerSoldier().accept(this);
        equipments.remove(decorator.getEquipmentType());
    }

    @Override
    public void exitGroup() {
        if (groupDepth > 0) groupDepth--;
    }
}
