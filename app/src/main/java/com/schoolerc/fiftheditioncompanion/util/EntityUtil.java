package com.schoolerc.fiftheditioncompanion.util;

import com.schoolerc.fiftheditioncompanion.entity.AbilityScore;
import com.schoolerc.fiftheditioncompanion.entity.DamageType;
import com.schoolerc.fiftheditioncompanion.entity.Skill;

/**
 * Created by Chaz on 3/27/2017.
 */

public final class EntityUtil {
    private EntityUtil(){}

    public static AbilityScore stringToAbilityScore(String s)
    {
        switch(s.toLowerCase())
        {
            case "strength":
                return AbilityScore.Strength;
            case "dexterity":
                return AbilityScore.Dexterity;
            case "constitution":
                return AbilityScore.Constitution;
            case "intelligence":
                return AbilityScore.Intelligence;
            case "wisdom":
                return AbilityScore.Wisdom;
            case "charisma":
                return AbilityScore.Charisma;
            default:
                throw new IllegalArgumentException("String '" + s + "' does not map to an ability score");
        }
    }

    public static Skill stringToSkill(String s)
    {
        switch(s.toLowerCase())
        {
            case "acrobatics":
                return Skill.Acrobatics;
            case "animal handling":
                return Skill.AnimalHandling;
            case "arcana":
                return Skill.Arcana;
            case "athletics":
                return Skill.Athletics;
            case "deception":
                return Skill.Deception;
            case "history":
                return Skill.History;
            case "insight":
                return Skill.Insight;
            case "intimidation":
                return Skill.Intimidation;
            case "investigation":
                return Skill.Investigation;
            case "medicine":
                return Skill.Medicine;
            case "nature":
                return Skill.Nature;
            case "perception":
                return Skill.Perception;
            case "performance":
                return Skill.Performance;
            case "persuasion":
                return Skill.Persuasion;
            case "religion":
                return Skill.Religion;
            case "sleight of hand":
                return Skill.SleightOfHand;
            case "stealth":
                return Skill.Stealth;
            case "survival":
                return Skill.Survival;
            default:
                throw new IllegalArgumentException("String '" + s + "' is not a skill");

        }
    }

    public static DamageType stringToDamageType(String s)
    {
        switch(s.toLowerCase())
        {
            case "acid":
                return DamageType.Acid;
            case "bludgeoning":
                return DamageType.Bludgeoning;
            case "cold":
                return DamageType.Cold;
            case "fire":
                return DamageType.Fire;
            case "force":
                return DamageType.Force;
            case "lightning":
                return DamageType.Lightning;
            case "necrotic":
                return DamageType.Necrotic;
            case "piercing":
                return DamageType.Piercing;
            case "poison":
                return DamageType.Poison;
            case "psychic":
                return DamageType.Psychic;
            case "radiant":
                return DamageType.Radiant;
            case "slashing":
                return DamageType.Slashing;
            case "thunder":
                return DamageType.Thunder;
            default:
                throw new IllegalArgumentException("String '" + s + "' is not a damage type");
        }
    }

}
