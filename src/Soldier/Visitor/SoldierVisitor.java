package Soldier.Visitor;

import Army.Group.Group;
import Equipment.Decorator.EquipmentDecorator;
import Soldier.Horseman.Horseman;
import Soldier.Infantryman.Infantryman;
import Soldier.Proxy.SoldierProxy;

public interface SoldierVisitor {
    void visit(Infantryman infantryman);
    void visit(Horseman horseman);
    void visit(Group group);
    void visit(SoldierProxy proxy);
    void visit(EquipmentDecorator decorator); 

    // Called after all children have been visited.
    void exitGroup();
}
