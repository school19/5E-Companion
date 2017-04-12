package com.schoolerc.fiftheditioncompanion.components.operators;

import com.schoolerc.fiftheditioncompanion.components.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.components.AbilityScoreIncreaseComponent;
import com.schoolerc.fiftheditioncompanion.components.Character;
import com.schoolerc.fiftheditioncompanion.components.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.components.ClassComponent;
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
 * Created by Chaz Schooler on 2/13/2017.
 */

public interface ComponentVisitor {
    void visitCharacter(Character c);
    void visitAbilityScoreComponent(AbilityScoreComponent abilityScoreComponent);
    void visitAbilityScoreIncreaseComponent(AbilityScoreIncreaseComponent abilityScoreIncreaseComponent);
    void visitChooseComponent(ChooseComponent chooseComponent);
    void visitClassComponent(ClassComponent classComponent);
    void visitConditionComponent(ConditionComponent conditionComponent);
    void visitDamageComponent(DamageComponent damageComponent);
    void visitImmunityComponent(ImmunityComponent immunityComponent);
    void visitLanguageComponent(LanguageComponent languageComponent);
    void visitProficiencyComponent(ProficiencyComponent proficiencyComponent);
    void visitRaceComponent(RaceComponent raceComponent);
    void visitResistanceComponent(ResistanceComponent resistanceComponent);
    void visitSpeedComponent(SpeedComponent speedComponent);
    void visitSpellcastingComponent(SpellcastingComponent spellcastingComponent);
    void visitSubraceComponent(SubraceComponent subraceComponent);
    void visitTraitComponent(TraitComponent traitComponent);
    void visitVisionComponent(VisionComponent visionComponent);
}
