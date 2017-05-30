package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.entity.AbilityScoresComponent;
import com.schoolerc.dungeoncompanion.util.FileUtil;
import com.schoolerc.dungeoncompanion.util.OnErrorListener;

import java.io.BufferedInputStream;
import java.io.IOException;


public class CharacterCreatorActivity extends Activity implements AbilityScoresEditFragment.OnFragmentInteractionListener, OnErrorListener{

    private static final String TAG = "CharCreator";
    public static final String ARG_ABILITY_SCORES_FRAGMENT = "ability_scores_fragment";
    public static final String ARG_RACE_SELECTOR_FRAGMENT = "race_selector_fragment";
    public static final String ARG_CLASS_SELECTOR_FRAGMENT = "class_selector_fragment";
    public static final String FRAGMENT_TAG_STEP = "step";

    private AbilityScoresEditFragment abilityScoresFragment;
    private RaceSelectorFragment raceSelectorFragment;
    private ClassSelectorFragment classSelectorFragment;

    private AbilityScoresComponent abilityScores = new AbilityScoresComponent();

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
            abilityScoresFragment = (AbilityScoresEditFragment) getFragmentManager().getFragment(savedInstanceState, ARG_ABILITY_SCORES_FRAGMENT);
            raceSelectorFragment = (RaceSelectorFragment) getFragmentManager().getFragment(savedInstanceState, ARG_RACE_SELECTOR_FRAGMENT);
            classSelectorFragment = (ClassSelectorFragment) getFragmentManager().getFragment(savedInstanceState, ARG_CLASS_SELECTOR_FRAGMENT);
        } else {
            abilityScoresFragment = new AbilityScoresEditFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.add(R.id.activity_character_creator, abilityScoresFragment, FRAGMENT_TAG_STEP);
            transaction.commit();
            raceSelectorFragment = new RaceSelectorFragment();
            classSelectorFragment = new ClassSelectorFragment();
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
    public void commitAbilityScores() {
        abilityScores = abilityScoresFragment.getAbilityScores();
        getFragmentManager().beginTransaction().replace(R.id.activity_character_creator, raceSelectorFragment, "step").commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getFragmentManager().putFragment(outState, ARG_ABILITY_SCORES_FRAGMENT, abilityScoresFragment);
    }

    @Override
    public void onError(Exception exception, Object data) {
        Log.e(TAG, "Exception: " + exception.toString());
    }
}
