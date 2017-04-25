package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import org.simpleframework.xml.Element;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class TraitComponent extends Component {
    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitTraitComponent(this);
    }

    @Element
    private String name;

    @Element(required=false)
    private String description;

    @Override
    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public TraitComponent()
    {
    }
}
