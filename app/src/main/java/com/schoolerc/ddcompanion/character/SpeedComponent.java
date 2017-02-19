package com.schoolerc.ddcompanion.character;

import org.w3c.dom.Element;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class SpeedComponent extends Component {
    private int speed;

    @Override
    public void load(Element element)
    {
        try{
            speed = Integer.parseInt(element.getTextContent());
        }
        catch(NumberFormatException ex)
        {
            throw new RuntimeException("Malformed speed component");
        }
    }
}
