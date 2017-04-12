package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class TraitComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitTraitComponent(this);
    }
}
