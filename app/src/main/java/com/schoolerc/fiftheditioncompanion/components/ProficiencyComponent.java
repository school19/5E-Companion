package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.DiceRoll;

/**
 * Created by Chaz on 3/28/2017.
 */

public class ProficiencyComponent extends Component {
    DiceRoll proficientIn;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitProficiencyComponent(this);
    }
}
