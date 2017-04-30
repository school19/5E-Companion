package com.schoolerc.fiftheditioncompanion.util;

import com.schoolerc.fiftheditioncompanion.rules.DamageType;

/**
 * Created by Chaz on 3/27/2017.
 */

public final class EntityUtil {
    private EntityUtil(){}

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
