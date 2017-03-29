package com.schoolerc.fiftheditioncompanion.entity.data;

import com.schoolerc.fiftheditioncompanion.entity.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.entity.AbilityScoreIncreaseComponent;
import com.schoolerc.fiftheditioncompanion.entity.AdvantageComponent;
import com.schoolerc.fiftheditioncompanion.entity.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.entity.ClassComponent;
import com.schoolerc.fiftheditioncompanion.entity.Component;
import com.schoolerc.fiftheditioncompanion.entity.ConditionComponent;
import com.schoolerc.fiftheditioncompanion.entity.DamageComponent;
import com.schoolerc.fiftheditioncompanion.entity.ImmunityComponent;
import com.schoolerc.fiftheditioncompanion.entity.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.entity.RaceComponent;
import com.schoolerc.fiftheditioncompanion.entity.ResistanceComponent;
import com.schoolerc.fiftheditioncompanion.entity.SpeedComponent;
import com.schoolerc.fiftheditioncompanion.entity.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.entity.TraitComponent;
import com.schoolerc.fiftheditioncompanion.entity.VisionComponent;

import java.io.InputStream;


public interface ComponentParser {
    AbilityScoreComponent parseAbilityScore();
    AbilityScoreIncreaseComponent parseAbilityScoreIncrease();
    AdvantageComponent parseAdvantageComponent();
    ChooseComponent parseChooseComponent();
    ClassComponent parseClassComponent();
    ConditionComponent parseConditionComponent();
    DamageComponent parseDamageComponent();
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
