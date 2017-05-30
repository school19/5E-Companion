package com.schoolerc.dungeoncompanion.ui.creator;

import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.entity.CharacterClass;
import com.schoolerc.dungeoncompanion.data.JsonParser;
import com.schoolerc.dungeoncompanion.loader.CharacterClassLoader;
import com.schoolerc.dungeoncompanion.ui.CharacterClassListAdapter;
import com.schoolerc.dungeoncompanion.util.FileUtil;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;

/**
 * Created by Chaz on 5/22/2017.
 */

public class ClassSelectorFragment extends Fragment {
    private static final String TAG = "ClassSelector";

    private static final String ARG_CHARACTER_CLASS_FILEPATH = "ClassSelector.class_filepath";

    private static final String ARG_CHARACTER_CLASS_DATASET = "ClassSelector.dataset";

    private CharacterClassListAdapter adapter;

    private class CharacterClassLoaderCallbacks implements LoaderManager.LoaderCallbacks<CharacterClass>{
        @Override
        public Loader<CharacterClass> onCreateLoader(int id, Bundle args) {
            return new CharacterClassLoader(getContext(), args.getString(ARG_CHARACTER_CLASS_FILEPATH), new JsonParser());
        }

        @Override
        public void onLoadFinished(Loader<CharacterClass> loader, CharacterClass data) {
            adapter.addClass(data);
        }

        @Override
        public void onLoaderReset(Loader<CharacterClass> loader) {
        }
    }

    private void initiateDataLoad()
    {
        adapter.clear();
        File dataDir = getContext().getFilesDir();
        File raceDir = new File(dataDir.getPath()+ File.separator + FileUtil.CHARACTER_CLASS_DEFINITION_DIRECTORY);

        File[] raceFiles = raceDir.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith("json");
            }
        });
        for(int i = 0; i < raceFiles.length; i++)
        {
            Bundle args = new Bundle();
            args.putSerializable(ARG_CHARACTER_CLASS_FILEPATH, raceFiles[i].getPath());
            getLoaderManager().initLoader(i, args, new CharacterClassLoaderCallbacks());
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new CharacterClassListAdapter(getContext());
        if(savedInstanceState != null)
        {
            adapter.setData((ArrayList<CharacterClass>)savedInstanceState.getSerializable(ARG_CHARACTER_CLASS_DATASET));
        }
        else
        {
            initiateDataLoad();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_class_selector, container, false);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putSerializable(ARG_CHARACTER_CLASS_DATASET, adapter.getData());
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = (ListView) view.findViewById(R.id.listViewClasses);
        listView.setAdapter(adapter);
        //TODO: Put in a onItemSelected listener too in a bit
    }
}
