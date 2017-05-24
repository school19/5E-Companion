package com.schoolerc.dungeoncompanion.loader;

import android.content.AsyncTaskLoader;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;

import com.schoolerc.dungeoncompanion.data.Race;

/**
 * Created by Chaz Schooler on 5/24/2017.
 */

public class RaceLoader extends AsyncTaskLoader<Race> {

    int id;

    public RaceLoader(Context c, int id) {
        super(c);
        this.id = id;
    }

    @Override
    public Race loadInBackground() {
        Cursor cursor = getContext().getContentResolver().query(ContentUris.withAppendedId(Race.RaceContract.CONTENT_URI, id), null, null, null, null);
        cursor.moveToNext();
        return null;
    }
}
