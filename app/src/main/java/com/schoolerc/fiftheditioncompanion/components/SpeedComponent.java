package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class SpeedComponent extends Component {
    private int speed;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitSpeedComponent(this);
    }
}
