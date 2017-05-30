package com.schoolerc.dungeoncompanion.entity;

import android.net.Uri;
import android.provider.BaseColumns;

import java.io.Serializable;


/**
 * Created by Chaz on 5/5/2017.
 */

public class Race extends Component implements Serializable{

    private String name;
    private int speed;

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
}
