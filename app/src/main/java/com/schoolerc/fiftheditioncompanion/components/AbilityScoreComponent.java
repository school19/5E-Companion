package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class AbilityScoreComponent extends Component {
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public AbilityScoreComponent(Builder builder)
    {
        setStrength(builder.getStrength());
        setDexterity(builder.getDexterity());
        setConstitution(builder.getConstitution());
        setIntelligence(builder.getIntelligence());
        setWisdom(builder.getWisdom());
        setCharisma(builder.getCharisma());
    }

    @Override
    public String getName()
    {
        return "";
    }

    public void accept(ComponentVisitor visitor)
    {
        visitor.visitAbilityScoreComponent(this);
    }

    @Override
    public int getStrengthScore() {
        return strength;
    }

    @Override
    public int getDexterityScore() {
        return dexterity;
    }

    @Override
    public int getConstitutionScore() {
        return constitution;
    }

    @Override
    public int getIntelligenceScore() {
        return intelligence;
    }

    @Override
    public int getWisdomScore() {
        return wisdom;
    }

    @Override
    public int getCharismaScore() {
        return charisma;
    }

    public static class Builder{
        private int strength;
        private int dexterity;
        private int constitution;
        private int intelligence;
        private int wisdom;
        private int charisma;

        public Builder(){}

        public AbilityScoreComponent build()
        {
            return new AbilityScoreComponent(this);
        }

        public Builder strength(int strength)
        {
            this.strength = strength;
            return this;
        }

        public Builder dexterity(int dexterity)
        {
            this.dexterity = dexterity;
            return this;
        }

        public Builder constitution(int constitution)
        {
            this.constitution = constitution;
            return this;
        }

        public Builder intelligence(int intelligence)
        {
            this.intelligence = intelligence;
            return this;
        }

        public Builder wisdom(int wisdom)
        {
            this.wisdom = wisdom;
            return this;
        }

        public Builder charisma(int charisma)
        {
            this.charisma = charisma;
            return this;
        }

        public int getStrength()
        {
            return strength;
        }

        public int getDexterity()
        {
            return dexterity;
        }

        public int getConstitution()
        {
            return constitution;
        }

        public int getIntelligence()
        {
            return intelligence;
        }

        public int getWisdom()
        {
            return wisdom;
        }

        public int getCharisma()
        {
            return charisma;
        }
    }

    public void setStrength(int strength)
    {
        this.strength = strength;
    }

    public void setDexterity(int dexterity)
    {
        this.dexterity = dexterity;
    }

    public void setConstitution(int constitution)
    {
        this.constitution = constitution;
    }

    public void setIntelligence(int intelligence)
    {
        this.intelligence = intelligence;
    }

    public void setWisdom(int wisdom)
    {
        this.wisdom = wisdom;
    }

    public void setCharisma(int charisma)
    {
        this.charisma = charisma;
    }
}
