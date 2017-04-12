package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.Effect;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class ConditionComponent extends Component implements Effect {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitConditionComponent(this);
    }
}
