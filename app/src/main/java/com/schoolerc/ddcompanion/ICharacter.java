package com.schoolerc.ddcompanion;

/**
 * Created by Chaz Schooler on 1/27/2017.
 */

public interface ICharacter {

    String getName();
    void setName(String name);

    int getStrengthScore();
    int getStrengthBonus();
    int getStrengthSave();
    void setStrengthScore(int strengthScore);

    int getDexterityScore();
    int getDexterityBonus();
    int getDexteritySave();
    void setDexterityScore(int dexterityScore);

    int getConstitutionScore();
    int getConstitutionBonus();
    int getConstitutionSave();
    void setConstitutionScore(int constitutionScore);

    int getIntelligenceScore();
    int getIntelligenceBonus();
    int getIntelligenceSave();
    void setIntelligenceScore(int intelligenceScore);

    int getWisdomScore();
    int getWisdomBonus();
    int getWisdomSave();
    void setWisdomScore(int wisdomScore);

    int getCharismaScore();
    int getCharismaBonus();
    int getCharismaSave();
    void setCharismaScore(int charismaScore);

    int getProficiencyBonus();

    int getAcrobaticsBonus();
    int getAnimalHandlingBonus();
    int getArcanaBonus();
    int getAthleticsBonus();
    int getDeceptionBonus();
    int getHistoryBonus();
    int getInsightBonus();
    int getIntimidationBonus();
    int getInvestigationBonus();
    int getMedicineBonus();
    int getNatureBonus();
    int getPerceptionBonus();
    int getPerformanceBonus();
    int getPersuasionBonus();
    int getReligionBonus();
    int getSleightOfHandBonus();
    int getStealthBonus();
    int getSurvivalBonus();

    int getMovementSpeed();

    int getArmorClass();

    void enableDecorator();
    void disableDecorator();
    boolean isEnabled();

    ICharacter removeDecorator(String name);
}
