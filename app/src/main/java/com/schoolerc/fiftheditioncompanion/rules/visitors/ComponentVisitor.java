package com.schoolerc.fiftheditioncompanion.rules.visitors;

import com.schoolerc.fiftheditioncompanion.rules.Character;
import com.schoolerc.fiftheditioncompanion.rules.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.rules.Class;
import com.schoolerc.fiftheditioncompanion.rules.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.rules.ProficiencyComponent;
import com.schoolerc.fiftheditioncompanion.rules.Race;
import com.schoolerc.fiftheditioncompanion.rules.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.rules.TraitComponent;
import com.schoolerc.fiftheditioncompanion.rules.VisionComponent;

/**
 * Created by Chaz Schooler on 2/13/2017.
 */

public interface ComponentVisitor {
    void visitCharacter(Character c);
    void visitChooseComponent(ChooseComponent chooseComponent);
    void visitClassComponent(Class aClass);
    void visitLanguageComponent(LanguageComponent languageComponent);
    void visitProficiencyComponent(ProficiencyComponent proficiencyComponent);
    void visitRaceComponent(Race race);
    void visitSubraceComponent(SubraceComponent subraceComponent);
    void visitTraitComponent(TraitComponent traitComponent);
    void visitVisionComponent(VisionComponent visionComponent);
}
