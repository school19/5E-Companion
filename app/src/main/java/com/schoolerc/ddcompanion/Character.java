package com.schoolerc.ddcompanion;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */

public class Character implements Serializable {

    private String mName;
    private int mStrengthScore;
    private int mDexterityScore;
    private int mConstitutionScore;
    private int mIntelligenceScore;
    private int mWisdomScore;
    private int mCharismaScore;

    public Character() {
    }

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

    public void setConstitutionScore(int constitutionScore)
    {
        mConstitutionScore = constitutionScore;
    }

    public void setIntelligenceScore(int intelligenceScore)
    {
        mIntelligenceScore = intelligenceScore;
    }

    public void setWisdomScore(int wisdomScore)
    {
        mWisdomScore = wisdomScore;
    }

    public void setCharismaScore(int charismaScore)
    {
        mCharismaScore = charismaScore;
    }
}
