package com.schoolerc.dungeoncompanion.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.schoolerc.dungeoncompanion.data.Race.RaceContract;

/**
 * Created by Chaz on 5/23/2017.
 */

public class DatabaseOpenHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "content.db";
    private static final int CURRENT_VERSION = 1;

    private static final String CREATE_RACE_TEMPLATE_TABLE = "CREATE TABLE " + RaceContract.TABLE_NAME
            + "(" +
            RaceContract._ID + " INTEGER PRIMARY KEY," +
            RaceContract.COLUMN_NAME + " VARCHAR(255)," +
            RaceContract.COLUMN_SPEED + " INTEGER" +
            ")";

    public DatabaseOpenHelper(Context context)
    {
        super(context, DATABASE_NAME, null, CURRENT_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_RACE_TEMPLATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }
}
