package com.schoolerc.fiftheditioncompanion.entity.data;

import android.util.Xml;

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
import com.schoolerc.fiftheditioncompanion.util.EntityUtil;

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
    public AbilityScoreIncreaseComponent parseAbilityScoreIncrease()
    {
        AbilityScoreIncreaseComponent.Builder builder = new AbilityScoreIncreaseComponent.Builder();
        try {
            pullParser.require(XmlPullParser.START_TAG, null, "ability-score-increase");

            int depth = 1;
            int eventType;
            while(depth > 0)
            {
                eventType = pullParser.next();
                switch(eventType)
                {
                    case XmlPullParser.START_TAG:
                        depth++;
                        String tagName = pullParser.getName();
                        if(tagName.equals("target"))
                        {
                            builder.abilityScore(EntityUtil.stringToAbilityScore(pullParser.getText()));
                        }
                        else if(tagName.equals("value"))
                        {
                            builder.bonus(Integer.parseInt(pullParser.getText()));
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        depth--;
                }
            }
            //Get off of END_TAG state
            pullParser.require(XmlPullParser.END_TAG, null, "ability-score-increase");
            pullParser.next();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

        return builder.build();
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
