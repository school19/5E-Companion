package com.schoolerc.ddcompanion.character;

import org.w3c.dom.Element;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class ComponentFactory {
    private static final String STR_ABILITY_SCORE_INCREASE = "ability-score-increase";
    private static final String STR_CHOOSE = "choose";
    private static final String STR_RACE = "libraries/race";
    private static final String STR_CLASS = "class";
     Component componentFromElement(Element element)
    {
        String tagName = element.getTagName().toLowerCase();
        Component component = null;

        if(tagName.equals(STR_ABILITY_SCORE_INCREASE))
        {
            component = new AbilityScoreIncreaseComponent();
        }
        else if(tagName.equals(STR_CHOOSE))
        {
            component = new ChooseComponent();
        }
        else if(tagName.equals(STR_RACE))
        {
            component = new RaceComponent();
        }
        else if(tagName.equals(STR_CLASS))
        {
            component = new ClassComponent();
        }
        else
        {
            throw new RuntimeException("Element does not represent a valid component");
        }

        component.load(element);
        return component;
    }
}
