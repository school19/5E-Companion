package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 2/5/2017.
 */

public class RaceComponent extends Component {

    String name;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitRaceComponent(this);
    }

    public RaceComponent(Builder builder)
    {
        for (Component component : builder.getChildren()) {
            addComponent(component);
        }
        setName(builder.getName());
    }

    public static class Builder
    {
        List<Component> children;
        String name;

        public Builder()
        {
            children = new ArrayList<>();
        }

        public RaceComponent build()
        {
            return new RaceComponent(this);
        }

        public Builder child(Component child)
        {
            this.children.add(child);
            return this;
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public List<Component> getChildren()
        {
            return children;
        }

        public String getName()
        {
            return name;
        }
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
