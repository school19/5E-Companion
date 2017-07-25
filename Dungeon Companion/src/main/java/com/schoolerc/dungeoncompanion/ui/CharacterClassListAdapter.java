package com.schoolerc.dungeoncompanion.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.schoolerc.dungeoncompanion.R;
import com.schoolerc.dungeoncompanion.entity.CharacterClass;

import java.util.ArrayList;

/**
 * Created by Chaz on 5/28/2017.
 */

public class CharacterClassListAdapter extends BaseAdapter {

    private Context context;

    public CharacterClassListAdapter(Context context)
    {
        this.context = context;
    }

    private ArrayList<CharacterClass> data = new ArrayList<>();

    public void setData(ArrayList<CharacterClass> data) {
        if(data == null){
            clear();
        }
        else {
            this.data = data;
            notifyDataSetChanged();
        }
    }

    public ArrayList<CharacterClass> getData(){
        return data;
    }

    public void addClass(CharacterClass c)
    {
        if(!data.contains(c)){
            data.add(c);
            notifyDataSetChanged();
        }
    }

    public void removeClass(CharacterClass c)
    {
        if(data.contains(c)){
            data.remove(c);
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
        CharacterClass characterClass = (CharacterClass)getItem(position);

        View v;

        if(convertView != null)
        {
            v = convertView;
        }
        else
        {
            v = LayoutInflater.from(context).inflate(R.layout.layout_class_item, parent, false);
        }

        TextView nameView = (TextView) v.findViewById(R.id.textViewClassName);
        nameView.setText(characterClass.getName());

        TextView hitDiceView = (TextView) v.findViewById(R.id.textViewHitDice);
        hitDiceView.setText(""+characterClass.getHitDice());

        return v;
    }
}
