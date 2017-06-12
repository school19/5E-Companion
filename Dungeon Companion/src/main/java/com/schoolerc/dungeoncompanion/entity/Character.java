package com.schoolerc.dungeoncompanion.entity;

import com.schoolerc.dungeoncompanion.util.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */
public class Character extends Component{

    private String name;
    private int experience;


    public Character() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public CharacterState getState()
    {
        CharacterState state = new CharacterState();
        this.apply(state);
        return state;
    }

    @Override
    public int getPriority() {
        return -1;
    }

}
