package com.schoolerc.dungeoncompanion;

/**
 * Created by Chaz on 6/13/2017.
 */

public class Lua {

    public Lua()
    {
        handle = createHandle();
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

    private native long createHandle();
    private native void destroyHandle();
}
