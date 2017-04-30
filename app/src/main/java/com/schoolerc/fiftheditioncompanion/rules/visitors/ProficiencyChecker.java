package com.schoolerc.fiftheditioncompanion.rules.visitors;

import com.schoolerc.fiftheditioncompanion.rules.Character;
import com.schoolerc.fiftheditioncompanion.rules.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.rules.Class;
import com.schoolerc.fiftheditioncompanion.rules.Component;
import com.schoolerc.fiftheditioncompanion.rules.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.rules.ProficiencyComponent;
import com.schoolerc.fiftheditioncompanion.rules.Race;
import com.schoolerc.fiftheditioncompanion.rules.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.rules.TraitComponent;
import com.schoolerc.fiftheditioncompanion.rules.VisionComponent;
import com.schoolerc.fiftheditioncompanion.rules.Proficientable;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chaz on 4/27/2017.
 */

public class ProficiencyChecker implements ComponentVisitor {

    Set<Proficientable> proficiencies;

    public ProficiencyChecker()
    {
        proficiencies = new HashSet<>();
    }

    @Override
    public void visitCharacter(Character c) {
        for (Component component : c) {
            component.accept(this);
        }
    }


    @Override
    public void visitChooseComponent(ChooseComponent chooseComponent) {

    }

    @Override
    public void visitClassComponent(Class aClass) {
        for (Component component : aClass) {
            component.accept(this);
        }
    }

    @Override
    public void visitLanguageComponent(LanguageComponent languageComponent) {

    }

    @Override
    public void visitRaceComponent(Race race) {

    }

    @Override
    public void visitProficiencyComponent(ProficiencyComponent proficiencyComponent) {
        proficiencies.add(proficiencyComponent.getProficiency());
    }

    @Override
    public void visitSubraceComponent(SubraceComponent subraceComponent) {
        for (Component component : subraceComponent) {
            component.accept(this);
        }
    }

    @Override
    public void visitTraitComponent(TraitComponent traitComponent) {
        for (Component component : traitComponent) {
            component.accept(this);
        }
    }

    @Override
    public void visitVisionComponent(VisionComponent visionComponent) {

    }

    public boolean isProficient(Proficientable proficientable)
    {
        return proficiencies.contains(proficientable);
    }
}
