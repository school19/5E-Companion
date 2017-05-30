package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.util.FileUtil;
import com.schoolerc.dungeoncompanion.util.OnErrorListener;

import java.io.BufferedInputStream;
import java.io.IOException;


public class CharacterCreatorActivity extends Activity implements AbilityScoresEditFragment.OnFragmentInteractionListener, OnErrorListener{

    private static final String TAG = "CharCreator";

    private AbilityScoresEditFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences(getPackageName(), 0);
        if (prefs.getBoolean("first_run", true)) {
            prefs.edit().putBoolean("first_run", true).apply(); //TODO: Change this back to 'false' after done testing
            unzipStagedData();

        }
        setContentView(R.layout.activity_character_creator);

        if (savedInstanceState != null) {
            fragment = (AbilityScoresEditFragment) getFragmentManager().getFragment(savedInstanceState, "ability_scores_fragment");
        } else {
            fragment = new AbilityScoresEditFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.activity_character_creator, fragment, "step");
            transaction.commit();
        }

    }

    private void unzipStagedData() {
        try {
            FileUtil.unzip(new BufferedInputStream(getAssets().open("Dungeon Companion.zip")), getFilesDir(), this);
        } catch (IOException e) {
            this.onError(e, "Unzipping prefab assets");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getFragmentManager().putFragment(outState, "ability_scores_fragment", fragment);
    }

    @Override
    public void onError(Exception exception, Object data) {
        Log.e(TAG, "Exception: " + exception.toString());
    }
}
