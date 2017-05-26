package com.schoolerc.dungeoncompanion.loader;

import android.content.AsyncTaskLoader;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;

import com.schoolerc.dungeoncompanion.data.Race;

public class RaceLoader extends AsyncTaskLoader<Race> {

    int id;

    public RaceLoader(Context c, int id) {
        super(c);
        this.id = id;
        onContentChanged();
    }

    @Override
    public Race loadInBackground() {
        Cursor cursor = getContext().getContentResolver().query(ContentUris.withAppendedId(Race.RaceContract.CONTENT_URI, id), null, null, null, null);
        cursor.moveToNext();

        int nameCol = cursor.getColumnIndex(Race.RaceContract.COLUMN_NAME);
        int speedCol = cursor.getColumnIndex(Race.RaceContract.COLUMN_SPEED);

        Race r = new Race();

        r.setSpeed(cursor.getInt(speedCol));
        r.setName(cursor.getString(nameCol));

        return r;
    }
}
