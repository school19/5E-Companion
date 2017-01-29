package com.schoolerc.ddcompanion;

import java.io.Serializable;

/**
 * Created by Chaz Schooler on 1/27/2017.
 */

public abstract class CharacterDecorator implements ICharacter, Serializable {
    public enum TYPE
    {
        RACE,
        CLASS,
        PERMANENT_MAGIC,
        EQUIPMENT,
        MAGIC
    }

    protected final ICharacter decoratedICharacter;

    protected TYPE mDecoratorType;
    protected String mDecoratorName;

    CharacterDecorator(ICharacter decorated)
    {
        decoratedICharacter = decorated;
    }

    public TYPE getDecoratorType(){return mDecoratorType; }
    public String getDecoratorName(){return mDecoratorName; }

    public String getName(){return decoratedICharacter.getName();}
    public void setName(String name){
        decoratedICharacter.setName(name);}

    public int getStrengthScore(){return decoratedICharacter.getStrengthScore();}
    public int getStrengthBonus(){return decoratedICharacter.getStrengthBonus();}
    public int getStrengthSave(){return decoratedICharacter.getStrengthSave();}
    public void setStrengthScore(int strengthScore){
        decoratedICharacter.setStrengthScore(strengthScore);}

    public int getDexterityScore(){return decoratedICharacter.getDexterityScore();}
    public int getDexterityBonus(){return decoratedICharacter.getDexterityBonus();}
    public int getDexteritySave(){return decoratedICharacter.getDexteritySave();}
    public void setDexterityScore(int dexterityScore){
        decoratedICharacter.setDexterityScore(dexterityScore);}

    public int getConstitutionScore(){return decoratedICharacter.getConstitutionScore();}
    public int getConstitutionBonus(){return decoratedICharacter.getConstitutionBonus();}
    public int getConstitutionSave(){return decoratedICharacter.getConstitutionSave();}
    public void setConstitutionScore(int constitutionScore){
        decoratedICharacter.setConstitutionScore(constitutionScore);}

    public int getIntelligenceScore(){return decoratedICharacter.getIntelligenceScore();}
    public int getIntelligenceBonus(){return decoratedICharacter.getIntelligenceBonus();}
    public int getIntelligenceSave(){return decoratedICharacter.getIntelligenceSave();}
    public void setIntelligenceScore(int intelligenceScore){
        decoratedICharacter.setIntelligenceScore(intelligenceScore);}

    public int getWisdomScore(){return decoratedICharacter.getWisdomScore();}
    public int getWisdomBonus(){return decoratedICharacter.getWisdomBonus();}
    public int getWisdomSave(){return decoratedICharacter.getWisdomSave();}
    public void setWisdomScore(int wisdomScore){
        decoratedICharacter.setWisdomScore(wisdomScore);}

    public int getCharismaScore(){return decoratedICharacter.getCharismaScore();}
    public int getCharismaBonus(){return decoratedICharacter.getCharismaBonus();}
    public int getCharismaSave(){return decoratedICharacter.getCharismaSave();}
    public void setCharismaScore(int charismaScore){
        decoratedICharacter.setCharismaScore(charismaScore);}

    public int getProficiencyBonus(){return decoratedICharacter.getProficiencyBonus();}

    public int getAcrobaticsBonus(){return decoratedICharacter.getAcrobaticsBonus();}
    public int getAnimalHandlingBonus(){return decoratedICharacter.getAnimalHandlingBonus();}
    public int getArcanaBonus(){return decoratedICharacter.getArcanaBonus();}
    public int getAthleticsBonus(){return decoratedICharacter.getAthleticsBonus();}
    public int getDeceptionBonus(){return decoratedICharacter.getDeceptionBonus();}
    public int getHistoryBonus(){return decoratedICharacter.getHistoryBonus();}
    public int getInsightBonus(){return decoratedICharacter.getInsightBonus();}
    public int getIntimidationBonus(){return decoratedICharacter.getIntimidationBonus();}
    public int getInvestigationBonus(){return decoratedICharacter.getInvestigationBonus();}
    public int getMedicineBonus(){return decoratedICharacter.getMedicineBonus();}
    public int getNatureBonus(){return decoratedICharacter.getNatureBonus();}
    public int getPerceptionBonus(){return decoratedICharacter.getPerceptionBonus();}
    public int getPerformanceBonus(){return decoratedICharacter.getPerformanceBonus();}
    public int getPersuasionBonus(){return decoratedICharacter.getPersuasionBonus();}
    public int getReligionBonus(){return decoratedICharacter.getReligionBonus();}
    public int getSleightOfHandBonus(){return decoratedICharacter.getSleightOfHandBonus();}
    public int getStealthBonus(){return decoratedICharacter.getStealthBonus();}
    public int getSurvivalBonus(){return decoratedICharacter.getSurvivalBonus();}

    public int getArmorClass(){return decoratedICharacter.getArmorClass();}

    public int getMovementSpeed(){return decoratedICharacter.getMovementSpeed();}
}
