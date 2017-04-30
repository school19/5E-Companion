package com.schoolerc.fiftheditioncompanion.rules;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/28/2017.
 */

public class SubraceComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitSubraceComponent(this);
    }
}
