package com.schoolerc.dungeoncompanion.entity;

import com.schoolerc.dungeoncompanion.util.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */
public class Character{

    public interface Listener {
        void onCharacterBeforeModified();
        void onCharacterAfterModified();
    }


    private List<Listener> listeners;

    private String name;
    private int experience;

    private int baseStrength;
    private int baseDexterity;
    private int baseConstitution;
    private int baseIntelligence;
    private int baseWisdom;
    private int baseCharisma;


    public Character() {
        listeners = new ArrayList<>();
    }

    public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    public void removeListener(Listener listener)
    {
        listeners.remove(listener);
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }





    private void notifyBefore()
    {
        for (Listener listener : listeners) {
            listener.onCharacterBeforeModified();
        }
    }

    private void notifyAfter()
    {
        for (Listener listener : listeners) {
            listener.onCharacterAfterModified();
        }
    }


    public int getBaseStrength() {
        return baseStrength;
    }

    public int getBaseDexterity() {
        return baseDexterity;
    }

    public int getBaseConstitution() {
        return baseConstitution;
    }

    public int getBaseIntelligence() {
        return baseIntelligence;
    }

    public int getBaseWisdom() {
        return baseWisdom;
    }

    public int getBaseCharisma() {
        return baseCharisma;
    }

    public void setBaseStrength(int baseStrength) {
        notifyBefore();
        this.baseStrength = baseStrength;
        notifyAfter();
    }

    public void setBaseDexterity(int baseDexterity) {
        notifyBefore();
        this.baseDexterity = baseDexterity;
        notifyAfter();
    }

    public void setBaseConstitution(int baseConstitution) {
        notifyBefore();
        this.baseConstitution = baseConstitution;
        notifyAfter();
    }

    public void setBaseIntelligence(int baseIntelligence) {
        notifyBefore();
        this.baseIntelligence = baseIntelligence;
        notifyAfter();
    }

    public void setBaseWisdom(int baseWisdom) {
        notifyBefore();
        this.baseWisdom = baseWisdom;
        notifyAfter();
    }

    public void setBaseCharisma(int baseCharisma) {
        notifyBefore();
        this.baseCharisma = baseCharisma;
        notifyAfter();
    }

    private int calculateAbilityScore(AbilityScore score, int base)
    {
        int result = base;
        return result;
    }

    public int getStrengthScore()
    {
        return calculateAbilityScore(AbilityScore.Strength, getBaseStrength());
    }

    public int getDexterityScore()
    {
        return calculateAbilityScore(AbilityScore.Dexterity, getBaseDexterity());
    }

    public int getConstitutionScore()
    {
        return calculateAbilityScore(AbilityScore.Constitution, getBaseConstitution());
    }

    public int getIntelligenceScore()
    {
        return calculateAbilityScore(AbilityScore.Intelligence, getBaseIntelligence());
    }

    public int getWisdomScore()
    {
        return calculateAbilityScore(AbilityScore.Wisdom, getBaseWisdom());
    }

    public int getCharismaScore()
    {
        return calculateAbilityScore(AbilityScore.Charisma, getBaseCharisma());
    }

    public int getStrengthBonus()
    {
        return Math.scoreToBonus(getStrengthScore());
    }

    public int getDexterityBonus()
    {
        return Math.scoreToBonus(getDexterityScore());
    }

    public int getConstitutionBonus()
    {
        return Math.scoreToBonus(getConstitutionScore());
    }

    public int getIntelligenceBonus()
    {
        return Math.scoreToBonus(getIntelligenceScore());
    }

    public int getWisdomBonus()
    {
        return Math.scoreToBonus(getWisdomScore());
    }

    public int getCharismaBonus()
    {
        return Math.scoreToBonus(getCharismaScore());
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
        return getCharismaBonus();
    }
}
