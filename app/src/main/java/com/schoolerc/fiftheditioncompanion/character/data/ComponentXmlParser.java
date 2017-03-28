package com.schoolerc.fiftheditioncompanion.character.data;

import android.util.Xml;

import com.schoolerc.fiftheditioncompanion.character.AbilityScore;
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

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;


public class ComponentXmlParser implements ComponentParser {
    private XmlPullParser pullParser;

    public ComponentXmlParser()
    {
        pullParser = Xml.newPullParser();
    }

    @Override
    public Component parse(InputStream inputStream)
    {
        try {
            pullParser.setInput(inputStream, null);
            pullParser.next(); //Move from START_DOCUMENT to first tag
            return parseComponent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Component parseComponent() throws XmlPullParserException, IOException
    {

        pullParser.require(XmlPullParser.START_TAG, null, null);

        String s = pullParser.getName().toLowerCase();
        switch (s) {
            case "ability-score":
                return parseAbilityScore();
            case "ability-score-increase":
                return parseAbilityScoreIncrease();
            case "advantage":
                return parseAdvantageComponent();
            case "choose":
                return parseChooseComponent();
            case "class":
                return parseClassComponent();
            case "condition":
                return parseConditionComponent();
            case "damage":
                return parseDamageComponent();
            case "effect":
                return parseEffectComponent();
            case "immunity":
                return parseImmunityComponent();
            case "language":
                return parseLanguageComponent();
            case "race":
                return parseRaceComponent();
            case "resistance":
                return parseResistanceComponent();
            case "speed":
                return parseSpeedComponent();
            case "subrace":
                return parseSubraceComponent();
            case "trait":
                return parseTraitComponent();
            case "vision":
                return parseVisionComponent();
            default:
                return null;
        }
    }

    @Override
    public AbilityScoreComponent parseAbilityScore() {
        return null;
    }

    @Override
    public AbilityScoreIncreaseComponent parseAbilityScoreIncrease() {
        return null;
    }

    @Override
    public AdvantageComponent parseAdvantageComponent() {
        return null;
    }

    @Override
    public ChooseComponent parseChooseComponent() {
        return null;
    }

    @Override
    public ClassComponent parseClassComponent() {
        return null;
    }

    @Override
    public ConditionComponent parseConditionComponent() {
        return null;
    }

    @Override
    public DamageComponent parseDamageComponent() {
        return null;
    }

    @Override
    public EffectComponent parseEffectComponent() {
        return null;
    }

    @Override
    public ImmunityComponent parseImmunityComponent() {
        return null;
    }

    @Override
    public LanguageComponent parseLanguageComponent() {
        return null;
    }

    @Override
    public RaceComponent parseRaceComponent() {
        return null;
    }

    @Override
    public ResistanceComponent parseResistanceComponent() {
        return null;
    }

    @Override
    public SpeedComponent parseSpeedComponent() {
        return null;
    }

    @Override
    public SubraceComponent parseSubraceComponent() {
        return null;
    }

    @Override
    public TraitComponent parseTraitComponent() {
        return null;
    }

    @Override
    public VisionComponent parseVisionComponent() {
        return null;
    }
}
