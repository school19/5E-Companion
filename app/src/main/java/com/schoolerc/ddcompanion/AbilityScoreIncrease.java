package com.schoolerc.ddcompanion;

import org.w3c.dom.Element;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncrease extends CharacterComponent {
    private final static String STR_STRENGTH = "strength";
    private final static String STR_DEXTERITY = "dexterity";
    private final static String STR_CONSTITUTION = "constitution";
    private final static String STR_INTELLIGENCE = "intelligence";
    private final static String STR_WISDOM = "wisdom";
    private final static String STR_CHARISMA = "charisma";

    private final static String ATTR_SCORE = "score";

    private AbilityScore abilityScore;
    private int bonus;

    @Override
    public void load(Element element) {
        super.load(element);
        String score = element.getAttribute(ATTR_SCORE).toLowerCase();

        if(score.equals(STR_STRENGTH))
        {
            abilityScore = AbilityScore.Strength;
        }
        else if(score.equals(STR_DEXTERITY))
        {
            abilityScore = AbilityScore.Dexterity;
        }
        else if(score.equals(STR_CONSTITUTION))
        {
            abilityScore = AbilityScore.Constitution;
        }
        else if(score.equals(STR_INTELLIGENCE))
        {
            abilityScore = AbilityScore.Intelligence;
        }
        else if(score.equals(STR_WISDOM))
        {
            abilityScore = AbilityScore.Wisdom;
        }
        else if(score.equals(STR_CHARISMA))
        {
            abilityScore = AbilityScore.Charisma;
        }
        else
        {
            throw new RuntimeException("Ability score increase is malformed");
        }

        try {
            bonus = Integer.parseInt(element.getTextContent());
        }
        catch(NumberFormatException ex)
        {
            throw new RuntimeException("Ability score increase is malformed");
        }
    }
}
