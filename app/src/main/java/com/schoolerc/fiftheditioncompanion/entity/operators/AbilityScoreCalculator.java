package com.schoolerc.fiftheditioncompanion.entity.operators;

import com.schoolerc.fiftheditioncompanion.entity.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.entity.AbilityScoreIncreaseComponent;
import com.schoolerc.fiftheditioncompanion.entity.Character;
import com.schoolerc.fiftheditioncompanion.entity.Component;

/**
 * Created by Chaz Schooler on 4/9/2017.
 */

public class AbilityScoreCalculator implements ComponentVisitor {
    AbilityScoreComponent base = null;

    @Override
    public void visitCharacter(Character c)
    {
        for (Component component : c) {
            component.accept(this);
        }
    }

    @Override
    public void visitAbilityScoreComponent(AbilityScoreComponent abilityScoreComponent)
    {
        if(base != null)
        {
            throw new RuntimeException("Duplicate AbilityScoreComponents");
        }
        base = abilityScoreComponent;
    }

    @Override
    public void visitAbilityScoreIncreaseComponent(AbilityScoreIncreaseComponent abilityScoreIncreaseComponent) {

    }


    public int getStrength()
    {
        return base.getStrengthScore();
    }

    public int getDexterity()
    {
        return base.getDexterityScore();
    }

    public int getConstitution()
    {
        return base.getConstitutionScore();
    }

    public int getIntelligence()
    {
        return base.getIntelligenceScore();
    }

    public int getWisdom()
    {
        return base.getWisdomScore();
    }

    public int getCharisma()
    {
        return base.getCharismaScore();
    }
}
