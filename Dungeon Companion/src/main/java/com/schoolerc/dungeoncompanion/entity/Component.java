package com.schoolerc.dungeoncompanion.entity;

import android.support.annotation.NonNull;

/**
 * Created by Chaz on 5/28/2017.
 */

public abstract class Component implements Comparable<Component> {
    public abstract void apply(CharacterState state);
    public abstract int getPriority();

    @Override
    public int compareTo(@NonNull Component o) {
        return Integer.valueOf(getPriority()).compareTo(o.getPriority());
    }
}
