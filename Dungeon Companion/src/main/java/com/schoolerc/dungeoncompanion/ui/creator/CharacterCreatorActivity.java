package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.data.Character;
import com.schoolerc.dungeoncompanion.data.Repository;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class CharacterCreatorActivity extends Activity implements AbilityScoresEditFragment.OnFragmentInteractionListener, Repository.Listener {

    private Context scriptContext;
    private Scriptable rootScope;
    private Repository contentRepository;

    private Character root;

    private AbilityScoresEditFragment scoresFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_creator);

        root = new Character();
        root.setBaseStrength(15);
        root.setBaseDexterity(14);
        root.setBaseConstitution(13);
        root.setBaseIntelligence(12);
        root.setBaseWisdom(10);
        root.setBaseCharisma(8);

        scoresFragment = new AbilityScoresEditFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.activity_character_creator, scoresFragment, "step");
        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        scoresFragment.setCharacter(root);
    }

    @Override
    public void onRaceRegistered() {

    }

    @Override
    public void onClassRegistered() {

    }
}