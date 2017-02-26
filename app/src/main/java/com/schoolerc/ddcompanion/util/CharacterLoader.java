package com.schoolerc.ddcompanion.util;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.schoolerc.ddcompanion.character.Component;

import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Chaz Schooler on 1/30/2017.
 */

public class CharacterLoader extends AsyncTaskLoader<List<Character>> {
    private static final String TAG = "CharacterLoader";
    private final File directory;
    private List<Component> characters;
    private OnErrorListener listener;

    public CharacterLoader(Context context, File directory) {
        super(context);
        if (!(context instanceof OnErrorListener)) {
            throw new RuntimeException("Context must implement onErrorListener interface!");
        }

        this.directory = directory;
    }

    @Override
    public List<Character> loadInBackground() {
        return null;
    }
}
