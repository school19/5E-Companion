package com.schoolerc.fiftheditioncompanion.rules;

/**
 * Created by Chaz Schooler on 4/9/2017.
 */

public interface ComponentObserver {

    void childAdded();
    void childRemoved();

    void modifierAdded();
    void modifierRemoved();

}
