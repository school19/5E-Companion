package com.schoolerc.ddcompanion;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.util.Log;

import com.schoolerc.ddcompanion.character.CharacterComponent;
import com.schoolerc.ddcompanion.character.CharacterLoader;

import java.io.File;
import java.util.List;

public class CharacterActivity extends Activity implements LoaderManager.LoaderCallbacks<List<CharacterComponent>> {

    private static final int LOADER_ID_CHARACTERS = 0;
    private static final String KEY_CHARACTER_LIST = "key_character_list";
    private static final String KEY_ACTIVE_CHARACTER = "key_active_character";
    private static final String TAG = "CharacterActivity";
    private static final String DEFAULT_CHARACTER_DIRECTORY = "characters";

    private int activeIndex = 0;
    private CharacterComponent activeCharacter = null;
    private List<CharacterComponent> characterList = null;
    private CharacterListFragment listFragment = null;
    private CharacterDetailsFragment detailsFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

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
        if (characterList == null) {
            Log.i(TAG, "Loading characters");
            getLoaderManager().initLoader(LOADER_ID_CHARACTERS, null, this);
        }
    }

    public void setCharacterData(List<CharacterComponent> characterList) {
        this.characterList = characterList;
    }


    public Loader<List<CharacterComponent>> onCreateLoader(int ID, Bundle args) {
        return new CharacterLoader(this, new File(getFilesDir(), DEFAULT_CHARACTER_DIRECTORY));
    }

    public void onLoaderReset(Loader<List<CharacterComponent>> loader) {
    }

    public void onLoadFinished(Loader<List<CharacterComponent>> loader, List<CharacterComponent> data) {
        setCharacterData(data);
    }
}
