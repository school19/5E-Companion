package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/28/2017.
 */

public class SubraceComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitSubraceComponent(this);
    }
}
