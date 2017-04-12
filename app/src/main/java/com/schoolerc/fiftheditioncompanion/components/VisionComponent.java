package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class VisionComponent extends Component {
    private int range;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitVisionComponent(this);
    }
}
