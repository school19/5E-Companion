package com.schoolerc.ddcompanion.util;

import android.content.Context;
import android.content.UriMatcher;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;

import com.schoolerc.ddcompanion.character.Component;

import android.net.Uri;
import java.util.List;

/**
 * Created by Chaz Schooler on 2/26/2017.
 */

public class ComponentLoader extends AsyncTaskLoader<List<Component>> {
    private Uri uri;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int CHARACTERS = 1;
    private static final int CHARACTERS_ID = 2;
    static
    {

    }
    ComponentLoader(Context context, Uri uri)
    {
        super(context);
        this.uri = uri;
    }

    public List<Component> loadInBackground()
    {
        return null;
    }
}
