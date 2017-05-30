package com.schoolerc.dungeoncompanion.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.schoolerc.dungeoncompanion.entity.CharacterClass;
import com.schoolerc.dungeoncompanion.data.DataParser;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Chaz on 5/26/2017.
 */

public class CharacterClassLoader extends AsyncTaskLoader<CharacterClass> {

    private static final String TAG = "CharacterClassLoader";

    private String path;
    private DataParser parser;
    private CharacterClass data;
    public CharacterClassLoader(Context ctx, String path, DataParser parser)
    {
        super(ctx);
        this.path = path;
        this.parser = parser;
    }

    @Override
    public CharacterClass loadInBackground() {
        try {
            return parser.parseCharacterClass(new BufferedInputStream(new FileInputStream(path)));
        }
        catch(IOException e)
        {
            Log.e(TAG, "Failed to load character class file: " + path);
            e.printStackTrace();
        }
        return null;
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

    @Override
    public void deliverResult(CharacterClass data) {
        if(isReset())
        {
            return;
        }

        this.data = data;
        super.deliverResult(data);
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        data = null;
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }
}
