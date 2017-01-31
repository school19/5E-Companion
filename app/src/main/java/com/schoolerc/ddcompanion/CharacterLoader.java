package com.schoolerc.ddcompanion;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import android.util.Xml;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static android.util.Xml.newPullParser;

/**
 * Created by Chaz Schooler on 1/30/2017.
 */

public class CharacterLoader extends AsyncTaskLoader<List<ICharacter>> {
    private static final String TAG = "CharacterLoader";
    private static final String ns = null;
    private final File directory;
    public CharacterLoader(Context context, File directory)
    {
        super(context);
        this.directory = directory;
    }

    @Override
    public List<ICharacter> loadInBackground()
    {
        File[] characterListings = directory.listFiles();
        if(characterListings == null)
        {
            return new ArrayList<>();
        }

        for(File listing : characterListings)
        {
            FileInputStream f = null;

            try {
                f = new FileInputStream(listing);
            }
            catch(FileNotFoundException ex) {
                Log.e(TAG, "Failed to open character file", ex);
            }
        }
        return null;
    }

    public ICharacter loadCharacter(InputStream inputStream)
    {
        try {
            XmlPullParser pullParser = Xml.newPullParser();
            pullParser.setInput(inputStream, null);
        }
        catch(XmlPullParserException ex)
        {
            Log.e(TAG, "Failed to parse character file", ex);
        }
        return null;
    }
}
