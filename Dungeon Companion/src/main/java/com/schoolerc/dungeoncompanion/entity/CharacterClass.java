package com.schoolerc.dungeoncompanion.entity;

import android.net.Uri;
import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Chaz on 5/5/2017.
 */

public class CharacterClass extends Component implements Serializable{
    private String name;
    private int hitDice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitDice() {
        return hitDice;
    }

    public void setHitDice(int hitDice) {
        this.hitDice = hitDice;
    }

    @Override
    public void apply(CharacterState state) {

    }

    @Override
    public int getPriority() {
        return 2;
    }
}
