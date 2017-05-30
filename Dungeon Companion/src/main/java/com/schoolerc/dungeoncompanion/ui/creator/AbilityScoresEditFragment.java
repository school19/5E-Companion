package com.schoolerc.dungeoncompanion.ui.creator;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.entity.AbilityScore;
import com.schoolerc.dungeoncompanion.entity.AbilityScoresComponent;
import com.schoolerc.dungeoncompanion.ui.AbilityScoresFragment;
import com.schoolerc.dungeoncompanion.util.Math;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AbilityScoresEditFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class AbilityScoresEditFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private OnFragmentInteractionListener mListener;

    private boolean validatePointBuy = false;

    private AbilityScoresComponent abilityScores = new AbilityScoresComponent();

    private int pointBuyBudget;
    Map<Integer, Integer> costs = new HashMap<>();
    {
        costs.put(8, 0);
        costs.put(9, 1);
        costs.put(10, 2);
        costs.put(11, 3);
        costs.put(12, 4);
        costs.put(13, 5);
        costs.put(14, 7);
        costs.put(15, 9);
    }

    private class ClickResponder implements Button.OnClickListener {
        private AbilityScore score;
        private boolean increase;

        private ClickResponder(AbilityScore score, boolean increase) {
            this.score = score;
            this.increase = increase;
        }

        @Override
        public void onClick(View v) {
            switch (score) {
                case Strength:
                    if (increase)
                        abilityScores.setStrength(abilityScores.getStrength() + 1);
                    else
                        abilityScores.setStrength(abilityScores.getStrength() - 1);
                    break;
                case Dexterity:
                    if (increase)
                        abilityScores.setDexterity(abilityScores.getDexterity() + 1);
                    else
                        abilityScores.setDexterity(abilityScores.getDexterity() - 1);
                    break;
                case Constitution:
                    if (increase)
                        abilityScores.setConstitution(abilityScores.getConstitution() + 1);
                    else
                        abilityScores.setConstitution(abilityScores.getConstitution() - 1);
                    break;
                case Intelligence:
                    if (increase)
                        abilityScores.setIntelligence(abilityScores.getIntelligence() + 1);
                    else
                        abilityScores.setIntelligence(abilityScores.getIntelligence() - 1);
                    break;
                case Wisdom:
                    if (increase)
                        abilityScores.setWisdom(abilityScores.getWisdom() + 1);
                    else
                        abilityScores.setWisdom(abilityScores.getWisdom() - 1);
                    break;
                case Charisma:
                    if (increase)
                        abilityScores.setCharisma(abilityScores.getCharisma() + 1);
                    else
                        abilityScores.setCharisma(abilityScores.getCharisma() - 1);
                    break;
            }
            updateView();
        }
    }

    public boolean canIncrease(int value) {
        if (validatePointBuy) {
            if(value >= 15)
            {
                return false;
            }
            else if(value >= 13)
            {
                return pointBuyBudget >= 2;
            }
            else
            {
                return pointBuyBudget >= 1;
            }
        }
        return value < 20;
    }

    public boolean canDecrease(int value) {
        if (validatePointBuy) {
            return value > 8;
        }

        return value > 1;
    }

    public void updateView() {
        if (validatePointBuy) {
            computeBudget();
            TextView budgetText = (TextView) getView().findViewById(R.id.textViewPointBuyBudget);
            budgetText.setText("Available points: " + pointBuyBudget);
        }

        updateFieldControls(abilityScores.getStrength(), R.id.textViewStrengthScore, R.id.textViewStrengthBonus, R.id.textViewStrengthSave, R.id.buttonStrengthMinus, R.id.buttonStrengthPlus);
        updateFieldControls(abilityScores.getDexterity(), R.id.textViewDexterityScore, R.id.textViewDexterityBonus, R.id.textViewDexteritySave, R.id.buttonDexterityMinus, R.id.buttonDexterityPlus);
        updateFieldControls(abilityScores.getConstitution(), R.id.textViewConstitutionScore, R.id.textViewConstitutionBonus, R.id.textViewConstitutionSave, R.id.buttonConstitutionMinus, R.id.buttonConstitutionPlus);
        updateFieldControls(abilityScores.getIntelligence(), R.id.textViewIntelligenceScore, R.id.textViewIntelligenceBonus, R.id.textViewIntelligenceSave, R.id.buttonIntelligenceMinus, R.id.buttonIntelligencePlus);
        updateFieldControls(abilityScores.getWisdom(), R.id.textViewWisdomScore, R.id.textViewWisdomBonus, R.id.textViewWisdomSave, R.id.buttonWisdomMinus, R.id.buttonWisdomPlus);
        updateFieldControls(abilityScores.getCharisma(), R.id.textViewCharismaScore, R.id.textViewCharismaBonus, R.id.textViewCharismaSave, R.id.buttonCharismaMinus, R.id.buttonCharismaPlus);
    }

    public void clampScores()
    {
        if(abilityScores.getStrength() > 15)
        {
            abilityScores.setStrength(15);
        }
        else if(abilityScores.getStrength() < 8)
        {
            abilityScores.setStrength(8);
        }

        if(abilityScores.getDexterity() > 15)
        {
            abilityScores.setDexterity(15);
        }
        else if(abilityScores.getDexterity() < 8)
        {
            abilityScores.setDexterity(8);
        }

        if(abilityScores.getConstitution() > 15)
        {
            abilityScores.setConstitution(15);
        }
        else if(abilityScores.getConstitution() < 8)
        {
            abilityScores.setConstitution(8);
        }

        if(abilityScores.getIntelligence() > 15)
        {
            abilityScores.setIntelligence(15);
        }
        else if(abilityScores.getIntelligence() < 8)
        {
            abilityScores.setIntelligence(8);
        }

        if(abilityScores.getWisdom() > 15)
        {
            abilityScores.setWisdom(15);
        }
        else if(abilityScores.getWisdom() < 8)
        {
            abilityScores.setWisdom(8);
        }

        if(abilityScores.getCharisma() > 15)
        {
            abilityScores.setCharisma(15);
        }
        else if(abilityScores.getCharisma() < 8)
        {
            abilityScores.setCharisma(8);
        }
    }

    public void computeBudget() {
        pointBuyBudget = 27;

        clampScores();

        pointBuyBudget -= costs.get(abilityScores.getStrength());
        pointBuyBudget -= costs.get(abilityScores.getDexterity());
        pointBuyBudget -= costs.get(abilityScores.getConstitution());
        pointBuyBudget -= costs.get(abilityScores.getIntelligence());
        pointBuyBudget -= costs.get(abilityScores.getWisdom());
        pointBuyBudget -= costs.get(abilityScores.getCharisma());

    }

    public void updateFieldControls(int value, int textView, int bonusView, int saveView, int minusButton, int plusButton) {
        TextView view = (TextView) getView().findViewById(textView);
        view.setText("" + value);

        int bonus = Math.scoreToBonus(value);
        String bonusText;

        if(bonus > 0)
        {
            bonusText = "+" + bonus;
        }
        else
        {
            bonusText = "" + bonus;
        }

        view = (TextView) getView().findViewById(bonusView);
        view.setText(bonusText);

        view = (TextView) getView().findViewById(saveView);
        view.setText(bonusText);

        getView().findViewById(plusButton).setEnabled(canIncrease(value));
        getView().findViewById(minusButton).setEnabled(canDecrease(value));
    }

    public AbilityScoresEditFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AbilityScoresFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AbilityScoresFragment newInstance() {
        AbilityScoresFragment fragment = new AbilityScoresFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        abilityScores.setStrength(15);
        abilityScores.setDexterity(14);
        abilityScores.setConstitution(13);
        abilityScores.setIntelligence(12);
        abilityScores.setWisdom(10);
        abilityScores.setCharisma(8);

        if (getArguments() != null) {
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner s = (Spinner) view.findViewById(R.id.spinnerStatChoice);
        s.setOnItemSelectedListener(this);

        view.findViewById(R.id.buttonStrengthMinus).setOnClickListener(new ClickResponder(AbilityScore.Strength, false));
        view.findViewById(R.id.buttonStrengthPlus).setOnClickListener(new ClickResponder(AbilityScore.Strength, true));

        view.findViewById(R.id.buttonDexterityMinus).setOnClickListener(new ClickResponder(AbilityScore.Dexterity, false));
        view.findViewById(R.id.buttonDexterityPlus).setOnClickListener(new ClickResponder(AbilityScore.Dexterity, true));

        view.findViewById(R.id.buttonConstitutionMinus).setOnClickListener(new ClickResponder(AbilityScore.Constitution, false));
        view.findViewById(R.id.buttonConstitutionPlus).setOnClickListener(new ClickResponder(AbilityScore.Constitution, true));

        view.findViewById(R.id.buttonIntelligenceMinus).setOnClickListener(new ClickResponder(AbilityScore.Intelligence, false));
        view.findViewById(R.id.buttonIntelligencePlus).setOnClickListener(new ClickResponder(AbilityScore.Intelligence, true));

        view.findViewById(R.id.buttonWisdomMinus).setOnClickListener(new ClickResponder(AbilityScore.Wisdom, false));
        view.findViewById(R.id.buttonWisdomPlus).setOnClickListener(new ClickResponder(AbilityScore.Wisdom, true));

        view.findViewById(R.id.buttonCharismaMinus).setOnClickListener(new ClickResponder(AbilityScore.Charisma, false));
        view.findViewById(R.id.buttonCharismaPlus).setOnClickListener(new ClickResponder(AbilityScore.Charisma, true));

        updateView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ability_scores_edit, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner statSpinner = (Spinner) getView().findViewById(R.id.spinnerStatChoice);
        String text = (String) statSpinner.getSelectedItem();
        switch (text) {
            case "Rolled":
                validatePointBuy = false;
                showNumberPickers();
                break;
            case "Point Buy":
                validatePointBuy = true;
                showNumberPickers();
                break;
            case "Standard Array":
                validatePointBuy = false;
                showDraggableGrid();
        }
        updateView();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //I don't think this actually can be triggered
    }

    public void showNumberPickers() {
        View root = getView();

        root.findViewById(R.id.textViewPointBuyBudget).setVisibility(validatePointBuy ? View.VISIBLE : View.GONE);

        root.findViewById(R.id.buttonStrengthMinus).setVisibility(View.VISIBLE);
        root.findViewById(R.id.textViewStrengthScore).setVisibility(View.VISIBLE);
        root.findViewById(R.id.buttonStrengthPlus).setVisibility(View.VISIBLE);

        root.findViewById(R.id.buttonDexterityMinus).setVisibility(View.VISIBLE);
        root.findViewById(R.id.textViewDexterityScore).setVisibility(View.VISIBLE);
        root.findViewById(R.id.buttonDexterityPlus).setVisibility(View.VISIBLE);

        root.findViewById(R.id.buttonConstitutionMinus).setVisibility(View.VISIBLE);
        root.findViewById(R.id.textViewConstitutionScore).setVisibility(View.VISIBLE);
        root.findViewById(R.id.buttonConstitutionPlus).setVisibility(View.VISIBLE);

        root.findViewById(R.id.buttonIntelligenceMinus).setVisibility(View.VISIBLE);
        root.findViewById(R.id.textViewIntelligenceScore).setVisibility(View.VISIBLE);
        root.findViewById(R.id.buttonIntelligencePlus).setVisibility(View.VISIBLE);

        root.findViewById(R.id.buttonWisdomMinus).setVisibility(View.VISIBLE);
        root.findViewById(R.id.textViewWisdomScore).setVisibility(View.VISIBLE);
        root.findViewById(R.id.buttonWisdomPlus).setVisibility(View.VISIBLE);

        root.findViewById(R.id.buttonCharismaMinus).setVisibility(View.VISIBLE);
        root.findViewById(R.id.textViewCharismaScore).setVisibility(View.VISIBLE);
        root.findViewById(R.id.buttonCharismaPlus).setVisibility(View.VISIBLE);

        root.findViewById(R.id.gridViewDefaultArray).setVisibility(View.GONE);

        ConstraintSet set = new ConstraintSet();
        set.clone((ConstraintLayout) root);
        set.centerHorizontally(R.id.textViewAbilityScoreHeading, R.id.textViewStrengthScore);
        set.applyTo((ConstraintLayout) root);
    }

    public void showDraggableGrid() {
        View root = getView();

        root.findViewById(R.id.textViewPointBuyBudget).setVisibility(View.GONE);

        root.findViewById(R.id.buttonStrengthMinus).setVisibility(View.GONE);
        root.findViewById(R.id.textViewStrengthScore).setVisibility(View.GONE);
        root.findViewById(R.id.buttonStrengthPlus).setVisibility(View.GONE);

        root.findViewById(R.id.buttonDexterityMinus).setVisibility(View.GONE);
        root.findViewById(R.id.textViewDexterityScore).setVisibility(View.GONE);
        root.findViewById(R.id.buttonDexterityPlus).setVisibility(View.GONE);

        root.findViewById(R.id.buttonConstitutionMinus).setVisibility(View.GONE);
        root.findViewById(R.id.textViewConstitutionScore).setVisibility(View.GONE);
        root.findViewById(R.id.buttonConstitutionPlus).setVisibility(View.GONE);

        root.findViewById(R.id.buttonIntelligenceMinus).setVisibility(View.GONE);
        root.findViewById(R.id.textViewIntelligenceScore).setVisibility(View.GONE);
        root.findViewById(R.id.buttonIntelligencePlus).setVisibility(View.GONE);

        root.findViewById(R.id.buttonWisdomMinus).setVisibility(View.GONE);
        root.findViewById(R.id.textViewWisdomScore).setVisibility(View.GONE);
        root.findViewById(R.id.buttonWisdomPlus).setVisibility(View.GONE);

        root.findViewById(R.id.buttonCharismaMinus).setVisibility(View.GONE);
        root.findViewById(R.id.textViewCharismaScore).setVisibility(View.GONE);
        root.findViewById(R.id.buttonCharismaPlus).setVisibility(View.GONE);

        root.findViewById(R.id.gridViewDefaultArray).setVisibility(View.VISIBLE);

        ConstraintSet set = new ConstraintSet();
        set.clone((ConstraintLayout) root);
        set.centerHorizontally(R.id.textViewAbilityScoreHeading, R.id.gridViewDefaultArray);
        set.applyTo((ConstraintLayout) root);

        Log.i("ABILITY SCORES", "" + root.findViewById(R.id.textViewAbilityScoreHeading).getVisibility());
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
    }
}
