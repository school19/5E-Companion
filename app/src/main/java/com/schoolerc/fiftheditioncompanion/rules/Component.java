package com.schoolerc.fiftheditioncompanion.rules;


import android.os.Parcel;
import android.os.Parcelable;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Component implements Iterable<Component>, Parcelable {

    private List<Component> children;
    private List<PropertyModifier> modifiers;

    private List<ComponentObserver> observers;

    private Component parent = null;

    public Component()
    {
        children = new ArrayList<>();
        observers = new ArrayList<>();
        modifiers = new ArrayList<>();
    }

    protected Component(Parcel source)
    {
        observers = new ArrayList<>();
        source.readTypedList(children, CREATOR);
        source.readTypedList(modifiers, PropertyModifier.CREATOR);
    }

    public void accept(ComponentVisitor visitor){}

    public void addComponent(Component child)
    {
        child.setParent(this);
        children.add(child);
        for (ComponentObserver observer : observers) {
            observer.childAdded();
        }
    }
    public void removeComponent(Component child)
    {
        child.setParent(null);
        children.remove(child);
        for (ComponentObserver observer : observers) {
            observer.childRemoved();
        }
    }

    public void addModifier(PropertyModifier m)
    {
        modifiers.add(m);
        for(ComponentObserver observer : observers)
        {
            observer.modifierAdded();
        }
    }

    public void removeModifier(PropertyModifier m)
    {
        modifiers.remove(m);
        for (ComponentObserver observer : observers) {
            observer.modifierRemoved();
        }
    }

    public void addObserver(ComponentObserver observer){observers.add(observer);}
    public void removeObserver(ComponentObserver observer){observers.remove(observer);}

    public void setParent(Component parent){
        this.parent = parent;
    }
    public Component getParent()
    {
        return parent;
    }

    public Component getRoot()
    {
        if(getParent() == null)
        {
            return null;
        }

        Component parent = getParent();
        while(parent.getParent() != null)
        {
            parent = parent.getParent();
        }

        return parent;
    }

    public Iterator<Component> iterator()
    {
        return children.iterator();
    }

    public String getName(){return null;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(children);
        dest.writeTypedList(modifiers);
    }

    public static final Parcelable.Creator<Component> CREATOR = new Parcelable.Creator<Component>()
    {
        @Override
        public Component createFromParcel(Parcel source) {
            return new Component(source);
        }

        @Override
        public Component[] newArray(int size) {
            return new Component[size];
        }
    };
}
