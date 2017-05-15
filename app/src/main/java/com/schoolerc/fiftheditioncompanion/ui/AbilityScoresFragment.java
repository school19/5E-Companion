package com.schoolerc.fiftheditioncompanion.ui;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.schoolerc.fiftheditioncompanion.data.Character;

import com.schoolerc.fiftheditioncompanion.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AbilityScoresFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AbilityScoresFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AbilityScoresFragment extends Fragment implements Character.Listener {

    private OnFragmentInteractionListener mListener;
    private Character dataSource;

    public AbilityScoresFragment() {
        // Required empty public constructor
    }

    public void setCharacter(Character c)
    {
        if(dataSource != null) {
            dataSource.removeListener(this);
        }

        dataSource = c;

        if(dataSource != null) {
            dataSource.addListener(this);
        }

        updateView(getView());
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
        if (getArguments() != null) {
        }
    }

    private void updateView(View v)
    {
        updateTextView(v, R.id.textViewStrengthScore, "" + dataSource.getStrengthScore());
        updateTextView(v, R.id.textViewDexterityScore, "" + dataSource.getDexterityScore());
        updateTextView(v, R.id.textViewConstitutionScore, "" + dataSource.getConstitutionScore());
        updateTextView(v, R.id.textViewIntelligenceScore, "" + dataSource.getIntelligenceScore());
        updateTextView(v, R.id.textViewWisdomScore, "" + dataSource.getWisdomScore());
        updateTextView(v, R.id.textViewCharismaScore, "" + dataSource.getCharismaScore());
        updateTextView(v, R.id.textViewStrengthBonus, "" + dataSource.getStrengthBonus());
        updateTextView(v, R.id.textViewDexterityBonus, "" + dataSource.getDexterityBonus());
        updateTextView(v, R.id.textViewConstitutionBonus, "" + dataSource.getConstitutionBonus());
        updateTextView(v, R.id.textViewIntelligenceBonus, "" + dataSource.getIntelligenceBonus());
        updateTextView(v, R.id.textViewWisdomBonus, "" + dataSource.getWisdomBonus());
        updateTextView(v, R.id.textViewCharismaBonus, "" + dataSource.getCharismaBonus());
        updateTextView(v, R.id.textViewStrengthSave, "" + dataSource.getStrengthSave());
        updateTextView(v, R.id.textViewDexteritySave, "" + dataSource.getDexteritySave());
        updateTextView(v, R.id.textViewConstitutionSave, "" + dataSource.getConstitutionSave());
        updateTextView(v, R.id.textViewIntelligenceSave, "" + dataSource.getIntelligenceSave());
        updateTextView(v, R.id.textViewWisdomSave, "" + dataSource.getWisdomSave());
        updateTextView(v, R.id.textViewCharismaSave, "" + dataSource.getCharismaSave());
    }

    private void updateTextView(View parent, int id, String text)
    {
        ((TextView)parent.findViewById(id)).setText(text);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ability_scores, container, false);
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
    public void onCharacterBeforeModified() {
        //Do nothing
    }

    @Override
    public void onCharacterAfterModified() {
        updateView(getView());
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
        // TODO: Update argument type and name
    }
}
