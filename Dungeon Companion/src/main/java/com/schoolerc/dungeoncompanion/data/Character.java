package com.schoolerc.dungeoncompanion.data;

import com.schoolerc.dungeoncompanion.util.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 12/30/2016.
 */
public class Character{

    private static final int LEVEL20_XP = 355000;
    private static final int LEVEL19_XP = 305000;
    private static final int LEVEL18_XP = 265000;
    private static final int LEVEL17_XP = 225000;
    private static final int LEVEL16_XP = 195000;
    private static final int LEVEL15_XP = 165000;
    private static final int LEVEL14_XP = 140000;
    private static final int LEVEL13_XP = 120000;
    private static final int LEVEL12_XP = 100000;
    private static final int LEVEL11_XP = 85000;
    private static final int LEVEL10_XP = 64000;
    private static final int LEVEL9_XP = 48000;
    private static final int LEVEL8_XP = 34000;
    private static final int LEVEL7_XP = 23000;
    private static final int LEVEL6_XP = 14000;
    private static final int LEVEL5_XP = 6500;
    private static final int LEVEL4_XP = 2700;
    private static final int LEVEL3_XP = 900;
    private static final int LEVEL2_XP = 300;

    public static class Builder
    {
        Character base;
        public Builder()
        {
            base = new Character();
        }

        public Builder strength(int strength)
        {
            base.baseStrength = strength;
            return this;
        }

        public Builder dexterity(int dexterity)
        {
            base.baseDexterity = dexterity;
            return this;
        }

        public Builder constitution(int constitution)
        {
            base.baseConstitution = constitution;
            return this;
        }

        public Builder intelligence(int intelligence)
        {
            base.baseIntelligence = intelligence;
            return this;
        }

        public Builder wisdom(int wisdom)
        {
            base.baseWisdom = wisdom;
            return this;
        }

        public Builder charisma(int charisma)
        {
            base.baseCharisma = charisma;
            return this;
        }

        public Builder name(String name)
        {
            base.name = name;
            return this;
        }

        public Builder experience(int xp)
        {
            base.experience = xp;
            return this;
        }

        public Character build()
        {
            return base;
        }
    }

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

    private CharacterState state;


    public Character() {
        state = new CharacterState();
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

    public CharacterSnapshot createSnapshot()
    {
        return new CharacterSnapshot(state);
    }

    public void restoreState(CharacterSnapshot snapshot)
    {
        this.state = snapshot.getState();
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getLevel() {
        int experience = getExperience();
        if (experience >= LEVEL20_XP) {
            return 20;
        }
        if (experience >= LEVEL19_XP) {
            return 19;
        }
        if (experience >= LEVEL18_XP) {
            return 18;
        }
        if (experience >= LEVEL17_XP) {
            return 17;
        }
        if (experience >= LEVEL16_XP) {
            return 16;
        }
        if (experience >= LEVEL15_XP) {
            return 15;
        }
        if (experience >= LEVEL14_XP) {
            return 14;
        }
        if (experience >= LEVEL13_XP) {
            return 13;
        }
        if (experience >= LEVEL12_XP) {
            return 12;
        }
        if (experience >= LEVEL11_XP) {
            return 11;
        }
        if (experience >= LEVEL10_XP) {
            return 10;
        }
        if (experience >= LEVEL9_XP) {
            return 9;
        }
        if (experience >= LEVEL8_XP) {
            return 8;
        }
        if (experience >= LEVEL7_XP) {
            return 7;
        }
        if (experience >= LEVEL6_XP) {
            return 6;
        }
        if (experience >= LEVEL5_XP) {
            return 5;
        }
        if (experience >= LEVEL4_XP) {
            return 4;
        }
        if (experience >= LEVEL3_XP) {
            return 3;
        }
        if (experience >= LEVEL2_XP) {
            return 2;
        }
        return 1;
    }

    public int getProficiencyBonus() {
        int level = getLevel();
        if (level >= 17) {
            return 6;
        }
        if (level >= 13) {
            return 5;
        }
        if (level >= 9) {
            return 4;
        }
        if (level >= 5) {
            return 3;
        }
        return 2;
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
