package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.schoolerc.dungeoncompanion.data.Race;
import com.schoolerc.dungeoncompanion.loader.RaceLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 5/24/2017.
 */

public class RaceSelectorFragment extends Fragment{

    private static final int ID_LOADER_ID = 1;
    private static final int RACE_LOADER_ID_BASE = 2;

    private static final String ARG_RACE_ID = "race_id";

    private List<Race> raceData = new ArrayList<>();

    private void clearRaces(){
        raceData = new ArrayList<>();
    }


    private class RaceIdCallbacks implements LoaderManager.LoaderCallbacks<Cursor>{
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            return new CursorLoader(getContext(), Race.RaceContract.CONTENT_URI, new String[]{Race.RaceContract._ID}, null, null, null);
        }

        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            int idColumnIndex = data.getColumnIndex(Race.RaceContract._ID);
            while(data.moveToNext())
            {
                int id = data.getInt(idColumnIndex);
                Bundle args = new Bundle();
                args.putInt(ARG_RACE_ID, id);

                getLoaderManager().initLoader(RACE_LOADER_ID_BASE + id, args, new RaceLoaderCallbacks());
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
            return new RaceLoader(getContext(), args.getInt(ARG_RACE_ID));
        }

        @Override
        public void onLoadFinished(Loader<Race> loader, Race data) {

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
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initiateDataLoad();
    }
}
