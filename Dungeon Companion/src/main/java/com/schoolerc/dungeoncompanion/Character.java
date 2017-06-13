package com.schoolerc.dungeoncompanion;

import com.schoolerc.dungeoncompanion.util.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */
public class Character{

    public Character(Lua lua)
    {
        handle = createHandle(lua);
    }

    @Override
    protected void finalize() throws Throwable {
        try{
            destroyHandle();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            super.finalize();
        }
    }

    private long handle;

    private native long createHandle(Lua lua);
    private native void destroyHandle();

}
