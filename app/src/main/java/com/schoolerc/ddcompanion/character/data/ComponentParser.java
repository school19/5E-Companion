package com.schoolerc.ddcompanion.character.data;

import com.schoolerc.ddcompanion.character.AbilityScoreComponent;
import com.schoolerc.ddcompanion.character.AbilityScoreIncreaseComponent;
import com.schoolerc.ddcompanion.character.AdvantageComponent;
import com.schoolerc.ddcompanion.character.ChooseComponent;
import com.schoolerc.ddcompanion.character.ClassComponent;
import com.schoolerc.ddcompanion.character.Component;
import com.schoolerc.ddcompanion.character.ConditionComponent;
import com.schoolerc.ddcompanion.character.DamageComponent;
import com.schoolerc.ddcompanion.character.EffectComponent;
import com.schoolerc.ddcompanion.character.ImmunityComponent;
import com.schoolerc.ddcompanion.character.LanguageComponent;
import com.schoolerc.ddcompanion.character.RaceComponent;
import com.schoolerc.ddcompanion.character.ResistanceComponent;
import com.schoolerc.ddcompanion.character.SpeedComponent;
import com.schoolerc.ddcompanion.character.SubraceComponent;
import com.schoolerc.ddcompanion.character.TraitComponent;
import com.schoolerc.ddcompanion.character.VisionComponent;

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
