package com.schoolerc.ddcompanion.character;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class ChooseComponent extends Component {

    private int quantity;
    private List<Component> components;

    @Override
    public void load(XmlPullParser parser) {
    }
}
