package com.schoolerc.ddcompanion.character;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.util.List;

/**
 * Created by Chaz Schooler on 1/30/2017.
 */

public class CharacterLoader extends AsyncTaskLoader<List<Component>> {
    private static final String TAG = "CharacterLoader";
    private final File directory;
    private List<Component> characters;

    public CharacterLoader(Context context, File directory) {
        super(context);
        this.directory = directory;
    }

    @Override
    public List<Component> loadInBackground() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Log.e(TAG, "Failed to create document builder");
            return null;
        }

        for (File charFile : directory.listFiles()) {
            Document characterDocument;
            try {
                characterDocument = documentBuilder.parse(charFile);
            }
            catch(Exception ex)
            {
                Log.e(TAG, "Failed to load character document: " + charFile.getPath());
            }
        }
        return null;
    }
}
