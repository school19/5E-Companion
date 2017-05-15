package com.schoolerc.fiftheditioncompanion.data;

/**
 * Created by Chaz on 5/8/2017.
 */

public class CharacterSnapshot {
    private CharacterState state;

    public CharacterSnapshot(CharacterState state)
    {
        this.state = state;
    }

    public CharacterState getState()
    {
        return state;
    }
}
