package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.Effect;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class ImmunityComponent extends Component {
    Effect immuneTo;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitImmunityComponent(this);
    }
}
