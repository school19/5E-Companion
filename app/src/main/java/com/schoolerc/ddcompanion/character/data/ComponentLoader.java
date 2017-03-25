package com.schoolerc.ddcompanion.character.data;

import android.content.Context;
import android.renderscript.ScriptGroup;
import android.support.v4.content.AsyncTaskLoader;

import com.schoolerc.ddcompanion.character.Component;

import java.io.InputStream;

public class ComponentLoader extends AsyncTaskLoader<Component> {
    private InputStream inputStream;
    private ComponentParser parser;

    public ComponentLoader(Context ctx){
        super(ctx);
    }

    public void setParser(ComponentParser parser)
    {
        this.parser = parser;
    }

    public void setInputStream(InputStream inputStream)
    {
        this.inputStream = inputStream;
    }

    public Component loadInBackground()
    {
        return parser.parse(inputStream);
    }
}
