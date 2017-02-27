package com.schoolerc.ddcompanion.util;

import android.content.Context;
import android.support.v4.content.Loader;

import com.schoolerc.ddcompanion.character.Component;

import java.util.List;

/**
 * Created by Chaz Schooler on 2/26/2017.
 */

public class ComponentLoader extends Loader<List<Component>> {
    ComponentLoader(Context context)
    {
        super(context);
    }
}
