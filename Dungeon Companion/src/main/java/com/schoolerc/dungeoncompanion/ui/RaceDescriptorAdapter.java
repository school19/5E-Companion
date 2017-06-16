package com.schoolerc.dungeoncompanion.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.HashSet;

/**
 * Created by Chaz on 6/13/2017.
 */

public class RaceDescriptorAdapter extends BaseAdapter {

    private Context ctx;
    private HashSet<RaceDescriptor> entries = new HashSet<>();

    public RaceDescriptorAdapter(Context ctx)
    {
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return entries.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    public void addEntry(RaceDescriptor entry)
    {
        entries.add(entry);
    }

    public void clear()
    {
        entries.clear();
    }

    public void setData(HashSet<RaceDescriptor> data)
    {
        entries = data;
    }

    public HashSet getData()
    {
        return entries;
    }
}
