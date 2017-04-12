package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class LanguageComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitLanguageComponent(this);
    }
}
