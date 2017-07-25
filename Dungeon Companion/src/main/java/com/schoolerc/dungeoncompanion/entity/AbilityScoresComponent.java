package com.schoolerc.dungeoncompanion.entity;

import android.support.annotation.NonNull;

/**
 * Created by Chaz on 5/28/2017.
 */

public class AbilityScoresComponent extends Component {

    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public int compareTo(@NonNull Component o) {
        return Integer.valueOf(getPriority()).compareTo(o.getPriority());
    }

    @Override
    public void apply(CharacterState state) {
        state.setStrengthScore(getStrength());
        state.setDexterityScore(getDexterity());
        state.setConstitutionScore(getConstitution());
        state.setIntelligenceScore(getIntelligence());
        state.setWisdomScore(getWisdom());
        state.setCharismaScore(getCharisma());
    }
}
