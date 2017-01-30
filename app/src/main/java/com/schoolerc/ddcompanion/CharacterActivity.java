package com.schoolerc.ddcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class CharacterActivity extends Activity{

    private static final int LOADER_ID_CHAR_LIST = 0;
    private static final int LOADER_ID_CHAR_DETAILS = 1;
    private static final String KEY_CHARACTER_NAME = "key_character_name";
    private static final String TAG = "CharacterActivity";
    private ICharacter activeCharacter = null;
    private CharacterListFragment listFragment = null;
    private CharacterDetailsFragment detailsFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character);

        try {
            listFragment = (CharacterListFragment) getFragmentManager().findFragmentById(R.id.fragmentCharacterList);
            detailsFragment  = (CharacterDetailsFragment)getFragmentManager().findFragmentById(R.id.fragmentCharacterDetails);
        }
        catch(ClassCastException ex)
        {
            ex.printStackTrace();
        }

        if(listFragment != null)
        {
            loadCharacterList();
        }

        if(detailsFragment != null)
        {
            String characterName = savedInstanceState.getString(KEY_CHARACTER_NAME);
            loadCharacterDetails(characterName);
        }
    }

    private void loadCharacterList()
    {
        
    }

    private void loadCharacterDetails(String name)
    {

    }
}
