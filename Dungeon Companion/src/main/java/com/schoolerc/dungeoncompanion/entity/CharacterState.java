package com.schoolerc.dungeoncompanion.entity;

/**
 * Created by Chaz on 5/28/2017.
 */

public class CharacterState {
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

    private int strengthScore = 0;
    private int dexterityScore = 0;
    private int constitutionScore = 0;
    private int intelligenceScore = 0;
    private int wisdomScore = 0;
    private int charismaScore = 0;

    private int experience = 0;

    private int maximumHitPoints = 0;
    private int currentHitPoints = 0;

    private int armorClass = 0;

    public int getMaximumHitPoints() {
        return maximumHitPoints;
    }

    public void setMaximumHitPoints(int maximumHitPoints) {
        this.maximumHitPoints = maximumHitPoints;
    }

    public int getCurrentHitPoints() {
        return currentHitPoints;
    }

    public void setCurrentHitPoints(int currentHitPoints) {
        this.currentHitPoints = currentHitPoints;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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

    public int getCharacterLevel() {
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
        int level = getCharacterLevel();
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
}
