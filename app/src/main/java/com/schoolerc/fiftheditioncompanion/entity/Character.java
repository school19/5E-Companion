package com.schoolerc.fiftheditioncompanion.entity;

import com.schoolerc.fiftheditioncompanion.entity.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.util.Math;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */

public class Character extends Component {

    private String name;

    public Character(Builder builder) {
        setName(builder.getName());
        for (Component component : builder.getChildren()) {
            addComponent(component);
        }
    }

    public static class Builder
    {
        private String name = "";
        List<Component> children;

        public Builder()
        {
            children = new Vector<>();
        }

        public Builder name(String name)
        {
            this.name = name;
            return this;
        }

        public Builder child(Component component)
        {
            children.add(component);
            return this;
        }

        public Builder children(Collection<Component> components)
        {
            children.addAll(components);
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

        public Character build()
        {
            return new Character(this);
        }
    }

    @Override
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public void accept(ComponentVisitor visitor)
    {
        visitor.visitCharacter(this);
    }

    @Override
    public int getStrengthScore() {
        return 0; //TODO replace with visitor that scans children for strength
    }

    @Override
    public int getDexterityScore() {
        return 0; //TODO replace with visitor that scans children for dexterity
    }

    @Override
    public int getConstitutionScore() {
        return 0; //TODO replace with visitor that scans children for constitution
    }

    @Override
    public int getIntelligenceScore() {
        return 0; //TODO replace with visitor that scans children for intelligence
    }

    @Override
    public int getWisdomScore() {
        return 0; //TODO replace with visitor that scans children for wisdom
    }

    @Override
    public int getCharismaScore() {
        return 0; //TODO replace with visitor that scans children for charisma
    }


}
