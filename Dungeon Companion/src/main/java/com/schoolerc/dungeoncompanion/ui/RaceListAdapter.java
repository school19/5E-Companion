package com.schoolerc.dungeoncompanion.ui;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.schoolerc.dungeoncompanion.data.Race;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz on 5/23/2017.
 */

public class RaceListAdapter extends BaseAdapter {

    private List<Race> data = new ArrayList<>();

    public void clearData()
    {
        data.clear();
    }

    public void addRace(Race r)
    {
        data.add(r);
        notifyDataSetChanged();
    }

    public void removeRace(Race r)
    {
        data.remove(r);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
