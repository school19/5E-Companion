package com.schoolerc.dungeoncompanion.data;

import android.content.Context;
import android.net.Uri;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz on 5/5/2017.
 */

public class Race {
    public static final class RaceContract implements BaseColumns{
        public static final String AUTHORITY = "com.schoolerc.dungeoncompanion.provider";

        public static final Uri CONTENT_URI = Uri.parse("content://com.schoolerc.dungeoncompanion.provider/race");

        public static final String TABLE_NAME = "race";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_SPEED = "speed";
    }

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
}
