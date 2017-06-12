package com.schoolerc.dungeoncompanion.entity;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Chaz on 5/28/2017.
 */

public abstract class Component implements Comparable<Component>, Iterable<Component>{
    public void apply(CharacterState state)
    {
        for (Component component : this) {
            component.apply(state);
        }
    }
    public abstract int getPriority();

    public void addChild(Component c)
    {
        children.add(c);
    }

    public void removeChild(Component c)
    {
        children.remove(c);
    }

    private ArrayList<Component> children = new ArrayList<>();

    @Override
    public int compareTo(@NonNull Component o) {
        return Integer.valueOf(getPriority()).compareTo(o.getPriority());
    }

    @Override
    public Iterator<Component> iterator() {
        return children.iterator();
    }
}
