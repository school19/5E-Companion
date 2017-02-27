package com.schoolerc.ddcompanion.ui.display;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.couchbase.lite.ManagerOptions;
import com.couchbase.lite.android.AndroidContext;
import com.schoolerc.ddcompanion.util.OnErrorListener;

import com.schoolerc.ddcompanion.R;
import com.schoolerc.ddcompanion.ui.creator.CharacterCreatorActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.couchbase.lite.Manager;


public class CharacterDisplayActivity extends Activity implements CharacterListFragment.OnEditCharacterListListener , OnErrorListener{

    private static final int LOADER_ID_CHARACTERS = 0;
    private static final String KEY_CHARACTER_LIST = "key_character_list";
    private static final String KEY_ACTIVE_CHARACTER = "key_active_character";
    private static final String TAG = "CharDisplayActivity";
    private static final String DEFAULT_CHARACTER_DIRECTORY = "characters";

    private int activeIndex = 0;
    private Character activeCharacter = null;
    private List<Character> characterList = null;
    private CharacterListFragment listFragment = null;
    private CharacterDetailsFragment detailsFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        Manager manager = null;
        deleteFile("test");
        try{
            FileOutputStream stream = openFileOutput("test", 0);
            FileWriter writer = new FileWriter(stream.getFD());
            writer.write("{}");
            writer.close();
            stream.close();
            manager = new Manager(new AndroidContext(getApplicationContext()), Manager.DEFAULT_OPTIONS);
            manager.getExistingDatabase("test");
        }
        catch(Exception ex)
        {
            Log.i(TAG, "fuuuuuuuuuuuuuuuuck");
            System.exit(0);
        }

        Log.i(TAG, "Number of DBs: " + manager.getAllDatabaseNames().size());
        try {
            listFragment = (CharacterListFragment) getFragmentManager().findFragmentById(R.id.fragmentCharacterList);
            detailsFragment = (CharacterDetailsFragment) getFragmentManager().findFragmentById(R.id.fragmentCharacterDetails);
        } catch (ClassCastException ex) {
            Log.e(TAG, "fragment loading failed", ex);
        }
        if (savedInstanceState != null) {
            int activeIndex = savedInstanceState.getInt(KEY_ACTIVE_CHARACTER);
            activeCharacter = characterList != null ? characterList.get(activeIndex) : null;
        }
    }


    public void onAddCharacter()
    {
        Intent intent = new Intent(this, CharacterCreatorActivity.class);
        startActivity(intent);
    }

    public void onError(Exception exception, Object object)
    {

    }
}
