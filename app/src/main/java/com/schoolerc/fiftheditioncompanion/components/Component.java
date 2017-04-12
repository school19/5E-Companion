package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class Component implements Iterable<Component> {

    private List<Component> children;
    private List<ComponentObserver> observers;

    public Component()
    {
        children = new Vector<>();
        observers = new Vector<>();
    }
    public abstract void accept(ComponentVisitor visitor);

    public void addComponent(Component child)
    {
        children.add(child);
        for (ComponentObserver observer : observers) {
            observer.childAdded();
        }
    }
    public void removeComponent(Component child)
    {
        children.remove(child);
        for (ComponentObserver observer : observers) {
            observer.childRemoved();
        }
    }

    public void addObserver(ComponentObserver observer){observers.add(observer);}
    public void removeObserver(ComponentObserver observer){observers.remove(observer);}

    public Iterator<Component> iterator()
    {
        return children.iterator();
    }

    public int getStrengthScore(){return 0;}
    public int getDexterityScore(){return 0;}
    public int getConstitutionScore(){return 0;}
    public int getIntelligenceScore(){return 0;}
    public int getWisdomScore(){return 0;}
    public int getCharismaScore(){return 0;}

    public String getName(){return null;}

}
