package com.schoolerc.ddcompanion;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */

public class CharacterBase implements Serializable, ICharacter {

    private String mName;
    private int mStrengthScore;
    private int mDexterityScore;
    private int mConstitutionScore;
    private int mIntelligenceScore;
    private int mWisdomScore;
    private int mCharismaScore;

    public CharacterBase() {
    }

    public void enableDecorator() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("CharacterBase is not a decorator");
    }

    public void disableDecorator() throws UnsupportedOperationException
    {
        throw new UnsupportedOperationException("CharacterBase is not a decorator");
    }

    public boolean isEnabled()
    {
        return true;
    }

    public ICharacter removeDecorator(String name)
    {
        return this;
    }

    public String getName(){return mName;}

    public void setName(String name){mName = name;}

    public int getStrengthScore()
    {
        return mStrengthScore;
    }

    public int getDexterityScore()
    {
        return mDexterityScore;
    }

    public int getConstitutionScore()
    {
        return mConstitutionScore;
    }

    public int getIntelligenceScore()
    {
        return mIntelligenceScore;
    }

    public int getWisdomScore()
    {
        return mWisdomScore;
    }

    public int getCharismaScore()
    {
        return mCharismaScore;
    }

    public void setStrengthScore(int strengthScore)
    {
        mStrengthScore = strengthScore;
    }

    public void setDexterityScore(int dexterityScore)
    {
        mDexterityScore = dexterityScore;
    }

    public void setConstitutionScore(int constitutionScore) {mConstitutionScore = constitutionScore;}

    public void setIntelligenceScore(int intelligenceScore) {mIntelligenceScore = intelligenceScore;}

    public void setWisdomScore(int wisdomScore)
    {
        mWisdomScore = wisdomScore;
    }

    public void setCharismaScore(int charismaScore) {mCharismaScore = charismaScore;}

    public int getStrengthBonus()
    {
        return CharacterUtilities.scoreToBonus(getStrengthScore());
    }

    public int getDexterityBonus()
    {
        return CharacterUtilities.scoreToBonus(getDexterityScore());
    }

    public int getConstitutionBonus()
    {
        return CharacterUtilities.scoreToBonus(getConstitutionScore());
    }

    public int getIntelligenceBonus()
    {
        return CharacterUtilities.scoreToBonus(getIntelligenceScore());
    }

    public int getWisdomBonus()
    {
        return CharacterUtilities.scoreToBonus(getWisdomScore());
    }

    public int getCharismaBonus()
    {
        return CharacterUtilities.scoreToBonus(getCharismaScore());
    }

    public int getStrengthSave()
    {
        return getStrengthBonus();
    }

    public int getDexteritySave()
    {
        return getDexterityBonus();
    }

    public int getConstitutionSave()
    {
        return getConstitutionBonus();
    }

    public int getIntelligenceSave()
    {
        return getIntelligenceBonus();
    }

    public int getWisdomSave()
    {
        return getWisdomBonus();
    }

    public int getCharismaSave()
    {
        return getCharismaScore();
    }

    public int getAcrobaticsBonus()
    {
        return getDexterityBonus();
    }

    public int getAnimalHandlingBonus()
    {
        return getWisdomBonus();
    }

    public int getArcanaBonus()
    {
        return getIntelligenceBonus();
    }

    public int getAthleticsBonus()
    {
        return getStrengthBonus();
    }

    public int getDeceptionBonus()
    {
        return getCharismaScore();
    }

    public int getHistoryBonus()
    {
        return getIntelligenceBonus();
    }

    public int getInsightBonus()
    {
        return getWisdomBonus();
    }

    public int getIntimidationBonus()
    {
        return getCharismaBonus();
    }

    public int getInvestigationBonus()
    {
        return getIntelligenceBonus();
    }

    public int getMedicineBonus()
    {
        return getWisdomBonus();
    }

    public int getNatureBonus()
    {
        return getIntelligenceBonus();
    }

    public int getPerceptionBonus()
    {
        return getWisdomBonus();
    }

    public int getPerformanceBonus()
    {
        return getCharismaBonus();
    }

    public int getPersuasionBonus()
    {
        return getCharismaBonus();
    }

    public int getReligionBonus()
    {
        return getIntelligenceBonus();
    }

    public int getSleightOfHandBonus()
    {
        return getDexterityBonus();
    }

    public int getStealthBonus()
    {
        return getDexterityBonus();
    }

    public int getSurvivalBonus()
    {
        return getWisdomBonus();
    }

    public int getMovementSpeed(){return 0;}

    public int getArmorClass()
    {
        return getDexterityBonus()+10;
    }

    public int getProficiencyBonus()
    {
        return 0;
    }
}