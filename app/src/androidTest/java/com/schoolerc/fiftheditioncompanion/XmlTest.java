package com.schoolerc.fiftheditioncompanion;

import android.util.Log;

import org.junit.Test;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;

/**
 * Created by Chaz on 4/13/2017.
 */

public class XmlTest {
    private String testString = "<document></document>";
    @Test
    public void pullParserTest() throws XmlPullParserException
    {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        XmlPullParser pullParser = factory.newPullParser();
        StringReader reader = new StringReader(testString);
        try {
            pullParser.setInput(reader);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            switch (pullParser.next()) {
                case XmlPullParser.START_DOCUMENT:
                    Log.e("TESTING", "START_DOCUMENT");
                    break;
                case XmlPullParser.START_TAG:
                    Log.e("TESTING", "START_TAG");
                    break;
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
