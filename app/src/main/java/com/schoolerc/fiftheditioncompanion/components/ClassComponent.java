package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/5/2017.
 */

public class ClassComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitClassComponent(this);
    }

    public ClassComponent(Builder builder)
    {

    }

    public static class Builder
    {
        public ClassComponent build()
        {
            return new ClassComponent(this);
        }
    }
}
