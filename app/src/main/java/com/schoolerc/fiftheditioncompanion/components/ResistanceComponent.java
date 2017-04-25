package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.DamageType;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class ResistanceComponent extends Component {
    @Element
    DamageType type;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitResistanceComponent(this);
    }

    public DamageType getResistance()
    {
        return type;
    }

    public void setResistance(DamageType type)
    {
        this.type = type;
    }
}
