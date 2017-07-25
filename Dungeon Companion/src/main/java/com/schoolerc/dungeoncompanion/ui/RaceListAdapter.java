package com.schoolerc.dungeoncompanion.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.entity.Race;

import java.util.ArrayList;

/**
 * Created by Chaz on 5/23/2017.
 */

public class RaceListAdapter extends BaseAdapter {

    private Context context;

    public RaceListAdapter(Context ctx)
    {
        this.context = ctx;
    }

    private ArrayList<Race> data = new ArrayList<>();

    public void setData(ArrayList<Race> data) {
        if(data == null){
            clear();
        }
        else {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    public ArrayList<Race> getData(){
        return data;
    }

    public void addRace(Race r)
    {
        if(!data.contains(r)){
            data.add(r);
            notifyDataSetChanged();
        }
    }

    public void removeRace(Race r)
    {
        if(data.contains(r)){
            data.remove(r);
            notifyDataSetChanged();
        }
    }

    public void clear()
    {
        data = new ArrayList<>();
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
        View root;
        if(convertView != null)
        {
            root = convertView;
        }
        else
        {
            root = LayoutInflater.from(context).inflate(R.layout.layout_race_item, parent, false);
        }
        Race r = (Race) getItem(position);

        TextView nameView = (TextView)root.findViewById(R.id.textViewRaceName);
        nameView.setText(r.getName());

        TextView speedView = (TextView)root.findViewById(R.id.textViewSpeed);
        speedView.setText(""+r.getSpeed());

        return root;
    }
}
