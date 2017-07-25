package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.ui.RaceDescriptor;
import com.schoolerc.dungeoncompanion.ui.RaceDescriptorAdapter;
import com.schoolerc.dungeoncompanion.ui.RaceDescriptorLoaderCallbacks;
import com.schoolerc.dungeoncompanion.util.FileUtil;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.ast.Chunk;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.io.File;
import java.io.FilenameFilter;
import java.util.HashSet;

/**
 * Created by Chaz Schooler on 5/24/2017.
 */

public class RaceSelectorFragment extends Fragment {
    private static final String TAG = "RaceSelector";


    private static final String ARG_DATASET = "race.dataset";

    private OnFragmentInteractionListener listener;

    private RaceDescriptorAdapter adapter;

    private void initiateDataLoad() {
        adapter.clear();
        File dataDir = getContext().getFilesDir();
        File raceDir = new File(dataDir.getPath()+ File.separator + FileUtil.RACE_DEFINITION_DIRECTORY);

        File[] raceFiles = raceDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("lua");
            }
        });
        Globals context = JsePlatform.standardGlobals();
        for(int i = 0; i < raceFiles.length; i++)
        {
            LuaValue chunk = context.loadfile(raceFiles[i].getAbsolutePath());
            LuaValue result = chunk.call();
            if(!result.istable())
            {
                //report the logical error here
            }
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
                listener.onRaceSelected((RaceDescriptor) parent.getAdapter().getItem(position));
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

        outState.putSerializable(ARG_DATASET, adapter.getData());
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        adapter = new RaceDescriptorAdapter(getContext());
        if (savedInstanceState != null) {
            adapter.setData((HashSet<RaceDescriptor>)savedInstanceState.getSerializable(ARG_DATASET));
        } else {
            initiateDataLoad();
        }
    }

    public interface OnFragmentInteractionListener{
        void onRaceSelected(RaceDescriptor race);
    }
}
