package com.schoolerc.dungeoncompanion.ui.display;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.View.OnClickListener;

import com.schoolerc.dungeoncompanion.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CharacterListFragment extends Fragment {

    private OnEditCharacterListListener mListener;

    public CharacterListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_character_list, container, false);
        FloatingActionButton fab = (FloatingActionButton) v.findViewById(R.id.floatingActionButtonAdd);
        fab.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mListener.onAddCharacter();
                    }
                }
        );
        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnEditCharacterListListener)
        {
            mListener = (OnEditCharacterListListener) context;
        }
        else
        {
            throw new RuntimeException(context.toString() + " must implement OnEditCharacterListListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnEditCharacterListListener
    {
        void onAddCharacter();
    }
}
