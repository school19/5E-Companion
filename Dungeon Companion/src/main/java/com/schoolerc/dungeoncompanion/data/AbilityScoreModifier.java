package com.schoolerc.dungeoncompanion.data;

/**
 * Created by Chaz on 5/15/2017.
 */

public class AbilityScoreModifier implements Modifier {
    private AbilityScore target;
    private int value;

    @Override
    public void apply(CharacterState state) {
        switch(target)
        {
            case Strength:
                state.setStrengthScore(state.getStrengthScore()+value);
                break;
            case Dexterity:
                state.setDexterityScore(state.getDexterityScore()+value);
                break;
            case Constitution:
                state.setConstitutionScore(state.getConstitutionScore()+value);
                break;
            case Intelligence:
                state.setIntelligenceScore(state.getIntelligenceScore()+value);
                break;
            case Wisdom:
                state.setWisdomScore(state.getWisdomScore()+value);
                break;
            case Charisma:
                state.setCharismaScore(state.getCharismaScore()+value);
                break;
        }
    }

    public AbilityScoreModifier(AbilityScore target, int value)
    {
        this.target = target;
        this.value = value;
    }

    public String toString()
    {
        return "Ability Score Modifier: " + (value > 0 ? "+" : "") + value + " " + target.toString();
    }
}
