package com.schoolerc.fiftheditioncompanion.data;

import java.util.List;

/**
 * Created by Chaz on 5/7/2017.
 */

//Class to represent memento state

public class CharacterState implements Cloneable{
    public CharacterState(){}

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    private int maxHitPoints;
    private int currentHitPoints;

    private int strengthScore;
    private int dexterityScore;
    private int constitutionScore;
    private int intelligenceScore;
    private int wisdomScore;
    private int charismaScore;

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getStrengthScore() {
        return strengthScore;
    }

    public void setStrengthScore(int strengthScore) {
        this.strengthScore = strengthScore;
    }

    public int getDexterityScore() {
        return dexterityScore;
    }

    public void setDexterityScore(int dexterityScore) {
        this.dexterityScore = dexterityScore;
    }

    public int getConstitutionScore() {
        return constitutionScore;
    }

    public void setConstitutionScore(int constitutionScore) {
        this.constitutionScore = constitutionScore;
    }

    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }

    public int getWisdomScore() {
        return wisdomScore;
    }

    public void setWisdomScore(int wisdomScore) {
        this.wisdomScore = wisdomScore;
    }

    public int getCharismaScore() {
        return charismaScore;
    }

    public void setCharismaScore(int charismaScore) {
        this.charismaScore = charismaScore;
    }



    @Override
    public CharacterState clone() {
        CharacterState result = new CharacterState();
        result.setCurrentHitPoints(this.getCurrentHitPoints());
        return result;
    }
}
