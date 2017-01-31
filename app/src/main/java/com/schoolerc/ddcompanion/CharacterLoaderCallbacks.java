package com.schoolerc.ddcompanion;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import java.util.List;

/**
 * Created by Chaz Schooler on 1/30/2017.
 */

public class CharacterLoaderCallbacks implements LoaderManager.LoaderCallbacks<List<Character>> {
    private static final String KEY_DIRECTORY = "directory";
    private static final String DEFAULT_DIRECTORY = "characters";
    private final Context context;

    public CharacterLoaderCallbacks(Context context)
    {
        this.context = context;
    }

    public Loader<List<Character>> onCreateLoader(int id, Bundle args)
    {
        String directory = args.getString(KEY_DIRECTORY);
        directory = directory == null ? DEFAULT_DIRECTORY : directory;
        return new CharacterLoader(context, directory);
    }

    public void onLoaderReset(Loader<List<Character>> loader)
    {

    }

    public void onLoadFinished(Loader<List<Character>> loader, List<Character> data)
    {

    }
}
