package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;


@Root
public class RaceComponent extends Component {

    @Attribute
    String name;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitRaceComponent(this);
    }

    public RaceComponent()
    {
    }


    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
