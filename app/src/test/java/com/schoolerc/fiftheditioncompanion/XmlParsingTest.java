/**
 * Created by Chaz on 4/2/2017.
 */

package com.schoolerc.fiftheditioncompanion;

import com.schoolerc.fiftheditioncompanion.components.ClassComponent;
import com.schoolerc.fiftheditioncompanion.components.RaceComponent;
import com.schoolerc.fiftheditioncompanion.components.operators.PrettyPrinter;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;

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
            RaceComponent component = serializer.read(RaceComponent.class, new File(halfElfRacePath));
            PrettyPrinter printer = new PrettyPrinter(System.out);
            component.accept(printer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
