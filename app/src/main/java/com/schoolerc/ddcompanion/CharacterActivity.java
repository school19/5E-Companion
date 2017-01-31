package com.schoolerc.ddcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class CharacterActivity extends Activity {

    private static final int LOADER_ID_CHARACTERS = 0;
    private static final String KEY_CHARACTER_LIST = "key_character_list";
    private static final String KEY_ACTIVE_CHARACTER = "key_active_character";
    private static final String TAG = "CharacterActivity";

    private int activeIndex = 0;
    private ICharacter activeCharacter = null;
    private List<ICharacter> characterList = null;
    private CharacterListFragment listFragment = null;
    private CharacterDetailsFragment detailsFragment = null;
    private CharacterLoaderCallbacks characterLoaderCallbacks = new CharacterLoaderCallbacks(this);

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
            try {
                characterList = (List<ICharacter>) savedInstanceState.getSerializable(KEY_CHARACTER_LIST);
            } catch (ClassCastException ex) {
                Log.e(TAG, "savedInstanceState corrupted", ex);
            }

            int activeIndex = savedInstanceState.getInt(KEY_ACTIVE_CHARACTER);
            activeCharacter = characterList != null ? characterList.get(activeIndex): null;

        }
        if (characterList == null) {
            Log.i(TAG, "Loading characters");
            getLoaderManager().initLoader(LOADER_ID_CHARACTERS, null, characterLoaderCallbacks);
        }
    }
}
