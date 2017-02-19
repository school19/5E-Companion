package com.schoolerc.ddcompanion.character;

import org.w3c.dom.Element;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class VisionComponent extends Component {
    private static final String KEY_TYPE = "type";
    private static final String STR_NORMAL = "normal";
    private static final String STR_DARKVISION = "darkvision";
    private static final String STR_TREMORSENSE = "tremorsense";
    private static final String STR_TRUESIGHT = "truesight";
    private static final String STR_BLINDSIGHT = "blindsight";

    private Vision type;
    private int range;

    @Override
    public void load(Element element)
    {
        String str_type = element.getAttribute(KEY_TYPE).toLowerCase();

        if(str_type.equals(STR_NORMAL))
        {
            type = Vision.Normal;
        }
        else if(str_type.equals(STR_DARKVISION))
        {
            type = Vision.Darkvision;
        }
        else if(str_type.equals(STR_BLINDSIGHT))
        {
            type = Vision.Blindsight;
        }
        else if(str_type.equals(STR_TREMORSENSE))
        {
            type = Vision.Tremorsense;
        }
        else if(str_type.equals(STR_TRUESIGHT))
        {
            type = Vision.Truesight;
        }
        else
        {
            throw new RuntimeException("Malformed vision component");
        }

        try{
            range = Integer.parseInt(element.getTextContent());
        }
        catch(NumberFormatException ex)
        {
            throw new RuntimeException(("Malformed vision component"));
        }
    }
}
