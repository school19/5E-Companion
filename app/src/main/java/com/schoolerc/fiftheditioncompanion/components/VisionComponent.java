package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.VisionType;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class VisionComponent extends Component {

    @Element
    private int range;

    @Element
    private VisionType type;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitVisionComponent(this);
    }

    public VisionComponent()
    {}

    public void setRange(int range)
    {
        this.range = range;
    }

    public void setType(VisionType type)
    {
        this.type = type;
    }

    public VisionType getType()
    {
        return type;
    }

    public int getRange()
    {
        return range;
    }
}
