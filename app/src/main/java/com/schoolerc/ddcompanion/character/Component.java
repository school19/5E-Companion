package com.schoolerc.ddcompanion.character;

import java.util.HashMap;
import org.w3c.dom.Element;
/**
 * Created by Chaz Schooler on 1/27/2017.
 */

public class Component {
    private String name;
    void load(Element element)
    {
        name = element.getTagName();
    }
}
