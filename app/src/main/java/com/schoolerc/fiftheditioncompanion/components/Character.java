package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.components.operators.*;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Default;
import org.simpleframework.xml.Transient;

import java.util.Collection;
import java.util.List;
import java.util.Vector;


/**
 * Created by Chaz Schooler on 12/30/2016.
 */
public class Character extends Component implements ComponentObserver{

    @Transient
    private AbilityScoreCalculator abilityScoreCalculator = new AbilityScoreCalculator();

    @Attribute
    private String name;

    public Character() {
        addObserver(this);
        recalculate();
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
    public void childAdded() {
        recalculate();
    }

    @Override
    public void childRemoved() {
        recalculate();
    }

    private void recalculate()
    {
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
