package com.schoolerc.dungeoncompanion.ui;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;

import com.schoolerc.dungeoncompanion.loader.RaceLoader;

public class RaceDescriptorLoaderCallbacks implements LoaderManager.LoaderCallbacks<RaceDescriptor> {

    public static final String ARG_LOADER_FILEPATH = "loader.filepath";

    Context context;
    RaceDescriptorAdapter adapter;

    public RaceDescriptorLoaderCallbacks(Context ctx, RaceDescriptorAdapter adapter)
    {
        context = ctx;
        this.adapter = adapter;
    }
    @Override
    public Loader<RaceDescriptor> onCreateLoader(int id, Bundle args) {
        return new RaceLoader(context, args.getString(ARG_LOADER_FILEPATH));
    }

    @Override
    public void onLoadFinished(Loader<RaceDescriptor> loader, RaceDescriptor data) {
        adapter.addEntry(data);
    }

    @Override
    public void onLoaderReset(Loader<RaceDescriptor> loader) {

    }
}