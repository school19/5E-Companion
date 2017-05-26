package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.IntegerRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.data.Race;
import com.schoolerc.dungeoncompanion.loader.RaceLoader;
import com.schoolerc.dungeoncompanion.ui.RaceListAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Chaz Schooler on 5/24/2017.
 */

public class RaceSelectorFragment extends Fragment{
    private static final String TAG = "RaceSelector";

    private static final int ID_LOADER_ID = 1;
    private static final int RACE_LOADER_ID_BASE = 2;

    private static final String ARG_RACE_ID = "race_id";

    private List<Race> raceData = new ArrayList<>();
    private Set<Integer> idSet = new HashSet<>();
    private RaceListAdapter adapter;
    private Race selection = null;

    private void clearRaces(){
        raceData = new ArrayList<>();
        idSet = new HashSet<>();
    }


    private class RaceIdCallbacks implements LoaderManager.LoaderCallbacks<Cursor>{
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            Log.d(TAG, "Creating CursorLoader to query all race id values");
            return new CursorLoader(getContext(), Race.RaceContract.CONTENT_URI, new String[]{Race.RaceContract._ID}, null, null, null);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            int idColumnIndex = data.getColumnIndex(Race.RaceContract._ID);
            Log.i(TAG, "Found " + data.getCount() + " race entries");
            while(data.moveToNext())
            {
                int id = data.getInt(idColumnIndex);
                Bundle args = new Bundle();
                args.putInt(ARG_RACE_ID, id);

                getLoaderManager().initLoader(RACE_LOADER_ID_BASE + id, args, new RaceLoaderCallbacks()).forceLoad();
                idSet.add(RACE_LOADER_ID_BASE + id);
            }
        }

        @Override
        public void onLoaderReset(Loader<Cursor> loader) {
            clearRaces();
        }
    }

    private class RaceLoaderCallbacks implements LoaderManager.LoaderCallbacks<Race>{
        @Override
        public Loader<Race> onCreateLoader(int id, Bundle args) {
            Log.d(TAG, "Creating RaceLoader for race id: " + args.getInt(ARG_RACE_ID));
            return new RaceLoader(getContext(), args.getInt(ARG_RACE_ID));
        }

        @Override
        public void onLoadFinished(Loader<Race> loader, Race data) {
            Log.d(TAG, "RaceLoader (id: " + (loader.getId()- RACE_LOADER_ID_BASE) + ") finished loading");
            raceData.add(data);
            idSet.remove(loader.getId());
            if(idSet.isEmpty())
            {
                Log.d(TAG, "All RaceLoaders finished loading, swapping adapter data");
                //All of the started loaders are done, update the adapter
                adapter.setData(raceData);
            }
        }

        @Override
        public void onLoaderReset(Loader<Race> loader) {
            //Not really sure what to put here presently.
            //Given that the IDLoader handles resetting the
            //Race array, I don't think anything actually goes here
        }
    }

    private void initiateDataLoad()
    {
        clearRaces();
        getLoaderManager().initLoader(ID_LOADER_ID, null, new RaceIdCallbacks());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_race_selector, container, false);

        ListView listView = (ListView)v.findViewById(R.id.listViewRaces);
        listView.setAdapter(adapter);
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selection = (Race) adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                selection = null;
            }
        });

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new RaceListAdapter(getContext());
        initiateDataLoad();
    }
}
