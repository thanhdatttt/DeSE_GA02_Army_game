package Observer;

import Soldier.Soldier;

import java.util.ArrayList;
import java.util.List;

public class ObserverManager {
    private final List<Observer> observers =  new ArrayList<>();

    public boolean subscribe(Observer observer){
        observers.add(observer);
        return true;
    }

    public boolean unsubscribe(Observer observer){
        observers.remove(observer);
        return true;
    }

    public void notifyObservers(Soldier soldier){
        for  (Observer observer : observers){
            observer.update(soldier);
        }
    }
}
