package Soldier.Visitor;

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

    @Override
    public void visit(Group group) {
        String indent = "  ".repeat(groupDepth);
        System.out.println(indent + "[Group] " + group.getName()
                + " — size: " + group.getSize()
                + ", total HP: " + group.getHealth()
                + ", total DMG: " + group.getDamage());
        groupDepth++;
    }

    @Override
    public void visit(Infantryman infantryman) {
        String indent = "  ".repeat(groupDepth);
        System.out.println(indent + "[Infantryman] " + infantryman.getName()
                + " | HP: " + infantryman.getHealth()
                + " | DMG: " + infantryman.getDamage()
                + " | Equipment: none");
    }

    @Override
    public void visit(Horseman horseman) {
        String indent = "  ".repeat(groupDepth);
        System.out.println(indent + "[Horseman] " + horseman.getName()
                + " | HP: " + horseman.getHealth()
                + " | DMG: " + horseman.getDamage()
                + " | Equipment: none");
    }

    @Override
    public void visit(SoldierProxy proxy) {
        String indent = "  ".repeat(groupDepth);
        String type = resolveType(proxy.getInnerSoldier());
        List<String> equipment = collectEquipment(proxy.getInnerSoldier());
 
        System.out.println(indent + "[" + type + "] " + proxy.getName()
                + " | HP: " + proxy.getHealth()
                + " | DMG: " + proxy.getDamage()
                + " | Equipment: " + (equipment.isEmpty() ? "none" : String.join(", ", equipment)));
        
        // if the proxy wraps a Group, traverse into it
        if (proxy.getInnerSoldier() instanceof Group) {
            groupDepth++;
            proxy.getInnerSoldier().accept(this);
            groupDepth--;
        }
    }

    @Override
    public void visit(EquipmentDecorator decorator) {
        
    }

    @Override
    public void exitGroup() {
        if (groupDepth > 0) groupDepth--;
    }

    // Walk down the decorator chain to find the base soldier type. 
    private String resolveType(Soldier soldier) {
        if (soldier instanceof EquipmentDecorator) {
            return resolveType(((EquipmentDecorator) soldier).getInnerSoldier());
        }
        if (soldier instanceof Infantryman) return "Infantryman";
        if (soldier instanceof Horseman)    return "Horseman";
        if (soldier instanceof Group)       return "Group";
        return "Unknown";
    }

    // Collect all equipment names from the decorator chain.
    private List<String> collectEquipment(Soldier soldier) {
        List<String> result = new ArrayList<>();
        while (soldier instanceof EquipmentDecorator) {
            EquipmentDecorator dec = (EquipmentDecorator) soldier;
            result.add(0, dec.getEquipmentType());
            soldier = dec.getInnerSoldier();
        }
        return result;
    }
}
