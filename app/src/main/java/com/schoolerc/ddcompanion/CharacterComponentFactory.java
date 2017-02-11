package com.schoolerc.ddcompanion;

import org.w3c.dom.Element;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class CharacterComponentFactory {
    private static final String STR_ABILITY_SCORE_INCREASE = "ability-score-increase";
    private static final String STR_CHOOSE = "choose";
    private static final String STR_RACE = "race";
    private static final String STR_CLASS = "class";
     CharacterComponent componentFromElement(Element element)
    {
        String tagName = element.getTagName().toLowerCase();
        CharacterComponent component = null;

        if(tagName.equals(STR_ABILITY_SCORE_INCREASE))
        {
            component = new AbilityScoreIncrease();
        }
        else if(tagName.equals(STR_CHOOSE))
        {
            component = new Choose();
        }
        else if(tagName.equals(STR_RACE))
        {
            component = new CharacterRaceComponent();
        }
        else if(tagName.equals(STR_CLASS))
        {
            component = new CharacterClassComponent();
        }
        else
        {
            throw new RuntimeException("Element does not represent a valid component");
        }

        component.load(element);
        return component;
    }
}
