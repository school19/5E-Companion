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

/**
 * Created by Chaz Schooler on 4/9/2017.
 */

public class AbilityScoreCalculator implements ComponentVisitor {

    @Override
    public void visitCharacter(Character c)
    {
        for (Component component : c) {
            component.accept(this);
        }
    }

    @Override
    public void visitChooseComponent(ChooseComponent chooseComponent) {

    }

    @Override
    public void visitClassComponent(Class aClass) {

    }

    @Override
    public void visitLanguageComponent(LanguageComponent languageComponent) {

    }

    @Override
    public void visitProficiencyComponent(ProficiencyComponent proficiencyComponent) {

    }

    @Override
    public void visitRaceComponent(Race race) {

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
}
