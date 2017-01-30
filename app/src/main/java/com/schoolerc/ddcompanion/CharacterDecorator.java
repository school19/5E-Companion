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

    protected ICharacter decoratedCharacter;

    protected TYPE mDecoratorType;
    protected String mDecoratorName;
    protected boolean mEnabled = true;

    CharacterDecorator(ICharacter decorated)
    {
        decoratedCharacter = decorated;
    }

    public TYPE getDecoratorType(){return mDecoratorType; }
    public String getDecoratorName(){return mDecoratorName; }

    public void enableDecorator()
    {
        mEnabled = true;
    }
    public void disableDecorator()
    {
        mEnabled = false;
    }

    public boolean isEnabled()
    {
        return mEnabled;
    }

    public ICharacter removeDecorator(String name)
    {
        if(name.equals(mDecoratorName))
        {
            return decoratedCharacter.removeDecorator(name);
        }
        decoratedCharacter = decoratedCharacter.removeDecorator(name);
        return this;
    }

    public String getName(){return decoratedCharacter.getName();}
    public void setName(String name){
        decoratedCharacter.setName(name);}

    public int getStrengthScore(){return decoratedCharacter.getStrengthScore();}
    public int getStrengthBonus(){return decoratedCharacter.getStrengthBonus();}
    public int getStrengthSave(){return decoratedCharacter.getStrengthSave();}
    public void setStrengthScore(int strengthScore){
        decoratedCharacter.setStrengthScore(strengthScore);}

    public int getDexterityScore(){return decoratedCharacter.getDexterityScore();}
    public int getDexterityBonus(){return decoratedCharacter.getDexterityBonus();}
    public int getDexteritySave(){return decoratedCharacter.getDexteritySave();}
    public void setDexterityScore(int dexterityScore){
        decoratedCharacter.setDexterityScore(dexterityScore);}

    public int getConstitutionScore(){return decoratedCharacter.getConstitutionScore();}
    public int getConstitutionBonus(){return decoratedCharacter.getConstitutionBonus();}
    public int getConstitutionSave(){return decoratedCharacter.getConstitutionSave();}
    public void setConstitutionScore(int constitutionScore){
        decoratedCharacter.setConstitutionScore(constitutionScore);}

    public int getIntelligenceScore(){return decoratedCharacter.getIntelligenceScore();}
    public int getIntelligenceBonus(){return decoratedCharacter.getIntelligenceBonus();}
    public int getIntelligenceSave(){return decoratedCharacter.getIntelligenceSave();}
    public void setIntelligenceScore(int intelligenceScore){
        decoratedCharacter.setIntelligenceScore(intelligenceScore);}

    public int getWisdomScore(){return decoratedCharacter.getWisdomScore();}
    public int getWisdomBonus(){return decoratedCharacter.getWisdomBonus();}
    public int getWisdomSave(){return decoratedCharacter.getWisdomSave();}
    public void setWisdomScore(int wisdomScore){
        decoratedCharacter.setWisdomScore(wisdomScore);}

    public int getCharismaScore(){return decoratedCharacter.getCharismaScore();}
    public int getCharismaBonus(){return decoratedCharacter.getCharismaBonus();}
    public int getCharismaSave(){return decoratedCharacter.getCharismaSave();}
    public void setCharismaScore(int charismaScore){
        decoratedCharacter.setCharismaScore(charismaScore);}

    public int getProficiencyBonus(){return decoratedCharacter.getProficiencyBonus();}

    public int getAcrobaticsBonus(){return decoratedCharacter.getAcrobaticsBonus();}
    public int getAnimalHandlingBonus(){return decoratedCharacter.getAnimalHandlingBonus();}
    public int getArcanaBonus(){return decoratedCharacter.getArcanaBonus();}
    public int getAthleticsBonus(){return decoratedCharacter.getAthleticsBonus();}
    public int getDeceptionBonus(){return decoratedCharacter.getDeceptionBonus();}
    public int getHistoryBonus(){return decoratedCharacter.getHistoryBonus();}
    public int getInsightBonus(){return decoratedCharacter.getInsightBonus();}
    public int getIntimidationBonus(){return decoratedCharacter.getIntimidationBonus();}
    public int getInvestigationBonus(){return decoratedCharacter.getInvestigationBonus();}
    public int getMedicineBonus(){return decoratedCharacter.getMedicineBonus();}
    public int getNatureBonus(){return decoratedCharacter.getNatureBonus();}
    public int getPerceptionBonus(){return decoratedCharacter.getPerceptionBonus();}
    public int getPerformanceBonus(){return decoratedCharacter.getPerformanceBonus();}
    public int getPersuasionBonus(){return decoratedCharacter.getPersuasionBonus();}
    public int getReligionBonus(){return decoratedCharacter.getReligionBonus();}
    public int getSleightOfHandBonus(){return decoratedCharacter.getSleightOfHandBonus();}
    public int getStealthBonus(){return decoratedCharacter.getStealthBonus();}
    public int getSurvivalBonus(){return decoratedCharacter.getSurvivalBonus();}

    public int getArmorClass(){return decoratedCharacter.getArmorClass();}

    public int getMovementSpeed(){return decoratedCharacter.getMovementSpeed();}
}
