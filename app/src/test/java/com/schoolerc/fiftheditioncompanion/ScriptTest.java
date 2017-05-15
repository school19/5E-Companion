package com.schoolerc.fiftheditioncompanion;

import com.schoolerc.fiftheditioncompanion.data.CharacterClass;
import com.schoolerc.fiftheditioncompanion.data.Race;
import com.schoolerc.fiftheditioncompanion.data.Repository;

import java.util.List;

import junit.framework.Assert;

import org.mozilla.javascript.Context;

import org.junit.Test;
import org.mozilla.javascript.ContextFactory;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

/**
 * Created by Chaz on 4/27/2017.
 */

public class ScriptTest {

    private String scriptDirectory = "app\\src\\main\\staging\\scripts";

    private String raceInit = "test = {getName: function(){return \"Test Race\";}}\n" +
            "race = new com.schoolerc.fiftheditioncompanion.data.Race(test)\n";

    private String raceRegister = "repository.registerRace(race)\n";

    private String classInit = "test = {getName: function(){return \"Test Class\";}}\n"+
            "c = new com.schoolerc.fiftheditioncompanion.data.CharacterClass(test)\n";

    private String classRegister = "repository.registerClass(c)\n";

    @Test
    public void raceTest()
    {
        Race r = null;
        Context c = null;
        try {
            c = ContextFactory.getGlobal().enterContext();
            c.setOptimizationLevel(-1);
            Scriptable scope = c.initStandardObjects();

            r = (Race) Context.jsToJava(c.evaluateString(scope, raceInit, "Test", 0, null), Race.class);
            Assert.assertNotNull(r);
            System.out.println(r.getName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            Context.exit();
        }
    }

    @Test
    public void repositoryRaceTest()
    {
        Context c = null;
        Repository repository = new Repository();
        try{
            c = ContextFactory.getGlobal().enterContext();
            c.setOptimizationLevel(-1);
            Scriptable scope = c.initStandardObjects();

            ScriptableObject.putProperty(scope, "repository", repository);

            c.evaluateString(scope, raceInit, "race init", 0, null);
            c.evaluateString(scope, raceRegister, "race register", 0, null);

            Assert.assertEquals(repository.getRaces().size(), 1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            Context.exit();
        }
    }

    @Test
    public void characterClassTest()
    {
        CharacterClass c = null;
        Context context = null;
        try {
            context = ContextFactory.getGlobal().enterContext();
            context.setOptimizationLevel(-1);
            Scriptable scope = context.initStandardObjects();

            c = (CharacterClass) Context.jsToJava(context.evaluateString(scope, classInit, "Test", 0, null), CharacterClass.class);

            Assert.assertNotNull(c);
            System.out.println(c.getName());
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            Context.exit();
        }
    }

    @Test
    public void repositoryCharacterClassTest()
    {
        Context c = null;
        Repository repository = new Repository();
        try{
            c = ContextFactory.getGlobal().enterContext();
            c.setOptimizationLevel(-1);
            Scriptable scope = c.initStandardObjects();

            ScriptableObject.putProperty(scope, "repository", repository);

            c.evaluateString(scope, classInit, "class init", 0, null);
            c.evaluateString(scope, classRegister, "class register", 0, null);

            Assert.assertEquals(repository.getClasses().size(), 1);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            Context.exit();
        }
    }

    @Test
    public void scriptListTest()
    {
        Context c = null;
        try{
            c = ContextFactory.getGlobal().enterContext();
            c.setOptimizationLevel(-1);
            Scriptable scope = c.initStandardObjects();

            Object result = c.evaluateString(scope, "[1,2,3]", "list test", 0, null);
            List<Double> list = (List<Double>)c.jsToJava(result, List.class);
            for (Double integer : list) {
                System.out.println(integer);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finally {
            Context.exit();
        }
    }

    @Test
    public void dwarfRaceTest()
    {
        String dwarfScriptPath = scriptDirectory + "\\dwarf.js";
        Context c = null;
    }

}
