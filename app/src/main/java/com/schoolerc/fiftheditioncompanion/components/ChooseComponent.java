package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import java.util.List;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class ChooseComponent extends Component {

    private int quantity;
    private List<Component> options;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitChooseComponent(this);
    }

    public ChooseComponent(Builder builder)
    {
        setOptions(builder.getOptions());
        setQuantity(builder.getQuantity());
    }

    public static class Builder
    {
        private int quantity;
        private List<Component> options;

        public List<Component> getOptions()
        {
            return options;
        }

        public int getQuantity()
        {
            return quantity;
        }

        public Builder options(List<Component> options)
        {
            this.options = options;
            return this;
        }

        public Builder quantity(int quantity)
        {
            this.quantity = quantity;
            return this;
        }

        public ChooseComponent build()
        {
            return new ChooseComponent(this);
        }
    }

    public int getQuantity()
    {
        return quantity;
    }

    public List<Component> getOptions()
    {
        return options;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public void setOptions(List<Component> options)
    {
        this.options = options;
    }
}
