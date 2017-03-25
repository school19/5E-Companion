package com.schoolerc.ddcompanion.character.data;

import android.util.Xml;

import com.schoolerc.ddcompanion.character.AbilityScore;
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

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.InputStream;
import java.io.InputStreamReader;


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
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        return null;
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
