package com.schoolerc.dungeoncompanion.ui.creator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.entity.AbilityScoresComponent;


/**
 * Created by Chaz on 5/30/2017.
 */

public class AbilityScoresAdapter extends BaseAdapter {
    private AbilityScoresComponent component;
    private Context context;

    public AbilityScoresAdapter(Context ctx, AbilityScoresComponent component) {
        this.context = ctx;
        this.component = component;
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public Object getItem(int position) {
        switch (position) {
            case 0:
                return component.getStrength();
            case 1:
                return component.getDexterity();
            case 2:
                return component.getConstitution();
            case 3:
                return component.getIntelligence();
            case 4:
                return component.getWisdom();
            case 5:
                return component.getCharisma();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View v;

        if (convertView != null) {
            v = convertView;
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.layout_ability_score_dragable, parent, false);
        }

        TextView view = (TextView) v.findViewById(R.id.textViewScore);
        view.setText(""+getItem(position));

        v.setTag(position);

        return v;
    }
}
