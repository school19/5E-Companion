package com.schoolerc.fiftheditioncompanion.entity;


import com.schoolerc.fiftheditioncompanion.entity.operators.ComponentVisitor;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class Component implements Iterable<Component> {

    private List<Component> children;

    public Component()
    {
        children = new Vector<>();
    }
    abstract void accept(ComponentVisitor visitor);

    public void addComponent(Component child)
    {
        children.add(child);
    }
    public void removeComponent(Component child)
    {
        children.remove(child);
    }

    public Iterator<Component> iterator()
    {
        return children.iterator();
    }

    public abstract int getStrengthScore();
    public abstract int getDexterityScore();
    public abstract int getConstitutionScore();
    public abstract int getIntelligenceScore();
    public abstract int getWisdomScore();
    public abstract int getCharismaScore();

    public abstract String getName();

}
