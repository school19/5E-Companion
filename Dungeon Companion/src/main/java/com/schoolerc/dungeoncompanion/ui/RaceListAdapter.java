package com.schoolerc.dungeoncompanion.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.data.Race;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz on 5/23/2017.
 */

public class RaceListAdapter extends BaseAdapter {

    private Context context;

    public RaceListAdapter(Context ctx)
    {
        this.context = ctx;
    }

    private List<Race> data = new ArrayList<>();

    public void setData(List<Race> data) {
        this.data = data;
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
