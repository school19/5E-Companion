package com.schoolerc.ddcompanion.character.data;

import java.io.InputStream;

/**
 * Created by Chaz on 3/20/2017.
 */

public abstract class ComponentParser {
    private ComponentBuilder builder;
    public ComponentParser(ComponentBuilder builder)
    {
        this.builder = builder;
    }

    public abstract void parse(InputStream inputStream);
}
