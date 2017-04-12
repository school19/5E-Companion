package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz on 4/11/2017.
 */

public class SpellcastingComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitSpellcastingComponent(this);
    }
}
