package com.schoolerc.ddcompanion.character.data;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Chaz on 3/20/2017.
 */

public class ComponentXmlParser implements ComponentParser {
    private XmlPullParser pullParser;
    public ComponentXmlParser(ComponentBuilder builder)
    {
        pullParser = Xml.newPullParser();
    }

    @Override
    public void parse(InputStream inputStream)
    {
        try {
            pullParser.setInput(inputStream, null);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
    }

}
