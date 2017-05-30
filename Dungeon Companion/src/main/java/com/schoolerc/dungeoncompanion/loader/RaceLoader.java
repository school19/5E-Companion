package com.schoolerc.dungeoncompanion.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.schoolerc.dungeoncompanion.data.DataParser;
import com.schoolerc.dungeoncompanion.entity.Race;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class RaceLoader extends AsyncTaskLoader<Race> {

    private static final String TAG = "RaceLoader";
    private String path;
    private Race data;
    private DataParser parser;

    public RaceLoader(Context c, String path, DataParser parser) {
        super(c);
        this.path = path;
        this.parser = parser;
        onContentChanged();
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        data = null;
    }

    @Override
    public Race loadInBackground() {
        try {
            return parser.parseRace(new BufferedInputStream(new FileInputStream(path)));
        }
        catch(Exception e)
        {
            Log.e(TAG, "Failed to handle race data file: " + path);
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    public void deliverResult(Race data) {
        if(isReset())
        {
            return;
        }
        this.data = data;

        super.deliverResult(data);
    }

    @Override
    protected void onStartLoading() {
        if(data != null)
        {
            deliverResult(data);
        }

        if(takeContentChanged() || data == null)
        {
            forceLoad();
        }
    }
}
