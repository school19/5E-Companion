package com.schoolerc.dungeoncompanion.ui.display;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.Character;


/**
 * A simple {@link Fragment} subclass.
 * to handle interaction events.
 * Use the {@link CharacterDetailsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CharacterDetailsFragment extends Fragment {
    private static final String ARG_CHARACTER = "character";

    // TODO: Rename and change types of parameters
    private Character character;

    public CharacterDetailsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CharacterDetailsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CharacterDetailsFragment newInstance(Character character) {
        CharacterDetailsFragment fragment = new CharacterDetailsFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_character_details, container, false);

        if(character != null) {
            updateFragmentView(v);
        }
        return v;
    }

    private void updateTextView(View parent, int id, String content)
    {
        TextView textView = (TextView)parent.findViewById(id);
        textView.setText(content);
    }

    private void updateFragmentView(View view)
    {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
