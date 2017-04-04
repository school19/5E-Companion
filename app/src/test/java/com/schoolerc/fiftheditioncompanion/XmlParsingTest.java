/**
 * Created by Chaz on 4/2/2017.
 */

package com.schoolerc.fiftheditioncompanion;

import com.schoolerc.fiftheditioncompanion.entity.data.XmlParser;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class XmlParsingTest {

    private static final String basicCharacterTestString = "";

    @Test
    public void basicCharacterParseTest()
    {
        XmlParser tokenizer = new XmlParser();
        InputStream stream = new ByteArrayInputStream(basicCharacterTestString.getBytes());

    }
}
