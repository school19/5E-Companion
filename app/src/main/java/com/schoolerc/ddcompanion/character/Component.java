package com.schoolerc.ddcompanion.character;

import java.util.HashMap;
import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Created by Chaz Schooler on 1/27/2017.
 */

public class Component {
    private static final String ATTR_NAME = "name";
    private String name;
    public void load(XmlPullParser parser) throws XmlPullParserException
    {
        name = parser.getAttributeValue(parser.NO_NAMESPACE, ATTR_NAME);
    }
}
