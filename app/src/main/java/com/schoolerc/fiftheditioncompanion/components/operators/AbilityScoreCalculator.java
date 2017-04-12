package com.schoolerc.fiftheditioncompanion.components.operators;

import com.schoolerc.fiftheditioncompanion.components.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.components.AbilityScoreIncreaseComponent;
import com.schoolerc.fiftheditioncompanion.components.Character;
import com.schoolerc.fiftheditioncompanion.components.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.components.ClassComponent;
import com.schoolerc.fiftheditioncompanion.components.Component;
import com.schoolerc.fiftheditioncompanion.components.ConditionComponent;
import com.schoolerc.fiftheditioncompanion.components.DamageComponent;
import com.schoolerc.fiftheditioncompanion.components.ImmunityComponent;
import com.schoolerc.fiftheditioncompanion.components.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.components.ProficiencyComponent;
import com.schoolerc.fiftheditioncompanion.components.RaceComponent;
import com.schoolerc.fiftheditioncompanion.components.ResistanceComponent;
import com.schoolerc.fiftheditioncompanion.components.SpeedComponent;
import com.schoolerc.fiftheditioncompanion.components.SpellcastingComponent;
import com.schoolerc.fiftheditioncompanion.components.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.components.TraitComponent;
import com.schoolerc.fiftheditioncompanion.components.VisionComponent;

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

    @Override
    public void visitChooseComponent(ChooseComponent chooseComponent) {

    }

    @Override
    public void visitClassComponent(ClassComponent classComponent) {

    }

    @Override
    public void visitConditionComponent(ConditionComponent conditionComponent) {

    }

    @Override
    public void visitDamageComponent(DamageComponent damageComponent) {

    }

    @Override
    public void visitImmunityComponent(ImmunityComponent immunityComponent) {

    }

    @Override
    public void visitLanguageComponent(LanguageComponent languageComponent) {

    }

    @Override
    public void visitProficiencyComponent(ProficiencyComponent proficiencyComponent) {

    }

    @Override
    public void visitRaceComponent(RaceComponent raceComponent) {

    }

    @Override
    public void visitResistanceComponent(ResistanceComponent resistanceComponent) {

    }

    @Override
    public void visitSpeedComponent(SpeedComponent speedComponent) {

    }

    @Override
    public void visitSpellcastingComponent(SpellcastingComponent spellcastingComponent) {

    }

    @Override
    public void visitSubraceComponent(SubraceComponent subraceComponent) {

    }

    @Override
    public void visitTraitComponent(TraitComponent traitComponent) {

    }

    @Override
    public void visitVisionComponent(VisionComponent visionComponent) {

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
