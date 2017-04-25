package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import org.simpleframework.xml.Attribute;


/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class AbilityScoreComponent extends Component {

    @Attribute
    private int strength;

    @Attribute
    private int dexterity;

    @Attribute
    private int constitution;

    @Attribute
    private int intelligence;

    @Attribute
    private int wisdom;

    @Attribute
    private int charisma;

    public AbilityScoreComponent()
    {
    }

    @Override
    public String getName()
    {
        return "";
    }

    @Override
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
