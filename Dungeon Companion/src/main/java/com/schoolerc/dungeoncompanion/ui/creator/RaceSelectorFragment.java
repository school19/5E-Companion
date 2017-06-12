package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.data.JsonParser;
import com.schoolerc.dungeoncompanion.entity.Race;
import com.schoolerc.dungeoncompanion.loader.RaceLoader;
import com.schoolerc.dungeoncompanion.ui.RaceListAdapter;
import com.schoolerc.dungeoncompanion.util.FileUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * Created by Chaz Schooler on 5/24/2017.
 */

public class RaceSelectorFragment extends Fragment {
    private static final String TAG = "RaceSelector";

    private static final String ARG_RACE_FILEPATH = "race_filepath";

    private static final String ARG_RACE_DATASET = "race_set";

    private OnFragmentInteractionListener listener;

    private RaceListAdapter adapter;
    private int selection = -1;

    private class RaceLoaderCallbacks implements LoaderManager.LoaderCallbacks<Race> {
        @Override
        public Loader<Race> onCreateLoader(int id, Bundle args) {
            Log.d(TAG, "Creating RaceLoader for race file: " + args.getString(ARG_RACE_FILEPATH));
            return new RaceLoader(getContext(), args.getString(ARG_RACE_FILEPATH), new JsonParser());
        }

        @Override
        public void onLoadFinished(Loader<Race> loader, Race data) {
            Log.d(TAG, "RaceLoader (name: " + data.getName() + ") finished loading");
            adapter.addRace(data);
        }

        @Override
        public void onLoaderReset(Loader<Race> loader) {
            //Not really sure what to put here presently.
            //Given that the IDLoader handles resetting the
            //Race array, I don't think anything actually goes here
        }
    }

    private void initiateDataLoad() {
        adapter.clear();
        File dataDir = getContext().getFilesDir();
        File raceDir = new File(dataDir.getPath()+ File.separator + FileUtil.RACE_DEFINITION_DIRECTORY);

        File[] raceFiles = raceDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("json");
            }
        });
        for(int i = 0; i < raceFiles.length; i++)
        {
            Bundle args = new Bundle();
            args.putSerializable(ARG_RACE_FILEPATH, raceFiles[i].getPath());
            getLoaderManager().initLoader(i, args, new RaceLoaderCallbacks());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_race_selector, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);

        ListView listView = (ListView) view.findViewById(R.id.listViewRaces);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onRaceSelected((Race)parent.getAdapter().getItem(position));
            }
        });
    }

    @Override
    public void onDetach() {
        listener = null;
        super.onDetach();
    }

    @Override
    public void onAttach(Context context) {
        if(context instanceof OnFragmentInteractionListener)
        {
            listener = (OnFragmentInteractionListener) context;
        }
        else{
            throw new RuntimeException("Context must implement OnFragmentInteractionListener");
        }
        super.onAttach(context);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.i(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);

        outState.putSerializable(ARG_RACE_DATASET, adapter.getData());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        adapter = new RaceListAdapter(getContext());

        if (savedInstanceState != null) {
            adapter.setData((ArrayList<Race>)savedInstanceState.getSerializable(ARG_RACE_DATASET));
        } else {
            initiateDataLoad();
        }
    }

    public interface OnFragmentInteractionListener{
        void onRaceSelected(Race race);
    }
}
