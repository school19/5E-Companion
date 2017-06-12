package com.schoolerc.dungeoncompanion.entity;

import android.net.Uri;
import android.provider.BaseColumns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Chaz on 5/5/2017.
 */

public class Race extends Component implements Serializable{

    private String name;
    private int speed;
    private List<Subrace> subraceList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void apply(CharacterState state) {

    }

    @Override
    public int getPriority() {
        return 1;
    }

    public void addSubrace(Subrace sub)
    {
        if(subraceList == null)
        {
            subraceList = new ArrayList<>();
        }
        subraceList.add(sub);
    }

    public List<Subrace> getSubraces()
    {
        return subraceList;
    }

    public void setSubrace(Subrace sub)
    {
        subraceList = null;
        for (Component component : sub) {
            addChild(component);
        }
    }

}
