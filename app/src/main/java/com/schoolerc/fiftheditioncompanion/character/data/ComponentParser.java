package com.schoolerc.fiftheditioncompanion.character.data;

import com.schoolerc.fiftheditioncompanion.character.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.character.AbilityScoreIncreaseComponent;
import com.schoolerc.fiftheditioncompanion.character.AdvantageComponent;
import com.schoolerc.fiftheditioncompanion.character.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.character.ClassComponent;
import com.schoolerc.fiftheditioncompanion.character.Component;
import com.schoolerc.fiftheditioncompanion.character.ConditionComponent;
import com.schoolerc.fiftheditioncompanion.character.DamageComponent;
import com.schoolerc.fiftheditioncompanion.character.EffectComponent;
import com.schoolerc.fiftheditioncompanion.character.ImmunityComponent;
import com.schoolerc.fiftheditioncompanion.character.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.character.RaceComponent;
import com.schoolerc.fiftheditioncompanion.character.ResistanceComponent;
import com.schoolerc.fiftheditioncompanion.character.SpeedComponent;
import com.schoolerc.fiftheditioncompanion.character.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.character.TraitComponent;
import com.schoolerc.fiftheditioncompanion.character.VisionComponent;

import java.io.InputStream;


public interface ComponentParser {
    AbilityScoreComponent parseAbilityScore();
    AbilityScoreIncreaseComponent parseAbilityScoreIncrease();
    AdvantageComponent parseAdvantageComponent();
    ChooseComponent parseChooseComponent();
    ClassComponent parseClassComponent();
    ConditionComponent parseConditionComponent();
    DamageComponent parseDamageComponent();
    EffectComponent parseEffectComponent();
    ImmunityComponent parseImmunityComponent();
    LanguageComponent parseLanguageComponent();
    RaceComponent parseRaceComponent();
    ResistanceComponent parseResistanceComponent();
    SpeedComponent parseSpeedComponent();
    SubraceComponent parseSubraceComponent();
    TraitComponent parseTraitComponent();
    VisionComponent parseVisionComponent();

    Component parse(InputStream inputStream);
}
