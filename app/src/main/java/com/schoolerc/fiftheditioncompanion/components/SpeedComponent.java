package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import org.simpleframework.xml.Attribute;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class SpeedComponent extends Component {
    @Attribute
    private int speed;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitSpeedComponent(this);
    }

    public int getSpeed()
    {
        return speed;
    }

    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
}
