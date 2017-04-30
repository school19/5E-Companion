/**
 * Created by Chaz on 4/2/2017.
 */

package com.schoolerc.fiftheditioncompanion;

import com.schoolerc.fiftheditioncompanion.rules.Race;

import org.junit.Assert;
import org.junit.Test;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;

public class XmlParsingTest{


    @Test
    public void halfElfRaceTest()
    {
        String halfElfRacePath = "app/src/main/staging/components/race/half_elf/base.xml";
        Serializer serializer = new Persister();

        try {
            serializer.validate(Race.class, new File(halfElfRacePath));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void dwarfRaceTest()
    {
        String dwarfRacePath = "app/src/main/staging/components/race/dwarf/base.xml";
        Serializer serializer = new Persister();

        try{
            Assert.assertTrue(serializer.validate(Race.class, new File(dwarfRacePath)));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
