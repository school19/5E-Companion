package com.schoolerc.ddcompanion.character.data;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.schoolerc.ddcompanion.character.Component;

/**
 * Created by Chaz Schooler on 3/12/2017.
 */

public class ComponentLoader extends AsyncTaskLoader<Component> {
    public ComponentLoader(Context ctx){
        super(ctx);
    }

    public Component loadInBackground()
    {
        return null;
    }
}
