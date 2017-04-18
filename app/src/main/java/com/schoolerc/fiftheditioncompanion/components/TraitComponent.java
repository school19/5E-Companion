package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

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
    private String name;
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

    public TraitComponent(Builder builder)
    {
        setName(builder.getName());
        setDescription(builder.getDescription());

        for (Component component : builder.getChildren()) {
            addComponent(component);
        }
    }

    public static class Builder
    {
        private String name;
        private String description;
        private List<Component> children;

        public Builder()
        {
            children = new ArrayList<>();
        }

        public TraitComponent build()
        {
            return new TraitComponent(this);
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder description(String description)
        {
            this.description = description;
            return this;
        }

        public Builder child(Component child)
        {
            this.children.add(child);
            return this;
        }

        public Builder children(Collection<Component> children)
        {
            this.children.addAll(children);
            return this;
        }

        public String getName()
        {
            return name;
        }

        public String getDescription()
        {
            return description;
        }

        public List<Component> getChildren()
        {
            return children;
        }
    }
}
