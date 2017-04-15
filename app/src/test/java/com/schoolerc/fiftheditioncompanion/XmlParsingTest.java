/**
 * Created by Chaz on 4/2/2017.
 */

package com.schoolerc.fiftheditioncompanion;


import android.util.Xml;

import com.schoolerc.fiftheditioncompanion.components.parsing.Token;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

public class XmlParsingTest{

    private String testString = "<document></document>";
    @Test
    public void tokenTest()
    {
        System.out.println(Token.CharacterBegin.toString());
    }
}
