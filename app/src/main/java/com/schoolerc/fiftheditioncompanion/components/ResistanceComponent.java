package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.DamageType;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class ResistanceComponent extends Component {
    DamageType resistantTo;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitResistanceComponent(this);
    }
}
