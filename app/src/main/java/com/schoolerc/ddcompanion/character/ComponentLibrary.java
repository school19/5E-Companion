package com.schoolerc.ddcompanion.character;

/**
 * Created by Chaz Schooler on 2/18/2017.
 */

public class ComponentLibrary {
    private static ComponentLibrary library = null;
    static ComponentLibrary getInstance()
    {
        if(library == null)
        {
            library = new ComponentLibrary();
        }
        return library;
    }

    Component getComponentByName(String name)
    {
        return null;
    }
}
