package com.schoolerc.fiftheditioncompanion.entity.data;

import com.schoolerc.fiftheditioncompanion.util.Pair;

import com.schoolerc.fiftheditioncompanion.entity.Character;
import com.schoolerc.fiftheditioncompanion.entity.*;

import java.util.Objects;

/**
 * Created by Chaz on 4/4/2017.
 */

public class ParserBuilderAdapter {

    protected ParserBuilderAdapter(){}

    public static Character.Builder characterBuilderFromProperties(Iterable<Pair<PropertyKey, Object>> properties)
    {
        Character.Builder builder = new Character.Builder();

        for (Pair<PropertyKey, Object> property : properties) {
            switch(property.first)
            {
                case Name:
                    builder.name((String)property.second);
                    break;
            }
        }
        return builder;
    }

    public static AbilityScoreComponent.Builder abilityScoreBuilderFromProperties(Iterable<Pair<PropertyKey, Object>> properties)
    {
        AbilityScoreComponent.Builder builder = new AbilityScoreComponent.Builder();

        for(Pair<PropertyKey, Object> property : properties)
        {
            switch (property.first)
            {
                case Strength:
                    builder.strength((int)property.second);
                    break;
                case Dexterity:
                    builder.dexterity((int)property.second);
                    break;
                case Constitution:
                    builder.constitution((int)property.second);
                    break;
                case Intelligence:
                    builder.intelligence((int)property.second);
                    break;
                case Wisdom:
                    builder.wisdom((int)property.second);
                    break;
                case Charisma:
                    builder.charisma((int)property.second);
                    break;
            }
        }

        return builder;
    }
}
