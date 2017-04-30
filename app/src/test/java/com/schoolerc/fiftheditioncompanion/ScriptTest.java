package com.schoolerc.fiftheditioncompanion;

import org.mozilla.javascript.Context;

import org.junit.Test;
import org.mozilla.javascript.Scriptable;

/**
 * Created by Chaz on 4/27/2017.
 */

public class ScriptTest {

    @Test
    public void rhinoTest()
    {
        Context c = null;
        try {
            c = Context.enter();
            Scriptable scope = c.initStandardObjects();
            c.setOptimizationLevel(-1);
            Object result = c.evaluateString(scope, "'Hello World'", "Test", 0, null);
            System.out.println(c.toString(result));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            c.exit();
        }
    }
}
