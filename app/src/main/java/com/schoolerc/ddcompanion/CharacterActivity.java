package com.schoolerc.ddcompanion;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class CharacterActivity extends Activity {

    private static final String TAG = "CharacterActivity";
    private ICharacter activeICharacter = null;
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
    }
}
