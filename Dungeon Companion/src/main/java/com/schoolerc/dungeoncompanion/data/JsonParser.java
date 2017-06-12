package com.schoolerc.dungeoncompanion.data;

import android.util.JsonReader;

import com.schoolerc.dungeoncompanion.entity.AbilityScore;
import com.schoolerc.dungeoncompanion.entity.AbilityScoreModifier;
import com.schoolerc.dungeoncompanion.entity.CharacterClass;
import com.schoolerc.dungeoncompanion.entity.Race;
import com.schoolerc.dungeoncompanion.entity.ToughnessComponent;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Chaz on 5/27/2017.
 */

public class JsonParser implements DataParser {
    @Override
    public CharacterClass parseCharacterClass(InputStream inputStream) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));

        CharacterClass characterClass = new CharacterClass();

        reader.beginObject();

        while(reader.hasNext())
        {
            switch(reader.nextName().toLowerCase())
            {
                default:
                    break;
                case "name":
                    characterClass.setName(reader.nextString());
                    break;
                case "hit_dice":
                    characterClass.setHitDice(reader.nextInt());
                    break;
            }
        }

        reader.endObject();

        return characterClass;
    }

    @Override
    public Race parseRace(InputStream inputStream) throws IOException {
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream));

        Race r = new Race();

        reader.beginObject();

        while(reader.hasNext())
        {
            switch(reader.nextName().toLowerCase())
            {
                default:
                    break;
                case "name":
                    r.setName(reader.nextString());
                    break;
                case "speed":
                    r.setSpeed(reader.nextInt());
                    break;
                case "tough":
                    ToughnessComponent component = new ToughnessComponent(reader.nextInt());
                    break;
                case "ability_score_improvements":
                    reader.beginArray();
                    while(reader.hasNext())
                    {
                        r.addChild(parseAbilityScoreModifier(reader));
                    }
                    reader.endArray();
                    break;
            }
        }

        reader.endObject();

        return r;
    }

    private AbilityScoreModifier parseAbilityScoreModifier(JsonReader reader) throws IOException
    {
        reader.beginObject();
        AbilityScore score = AbilityScore.Strength;
        int value = 0;
        while(reader.hasNext())
        {
            switch(reader.nextName())
            {
                case "ability_score":
                    score = AbilityScore.valueOf(reader.nextString());
                    break;
                case "value":
                    value = reader.nextInt();
                    break;
                default:
                    break;
            }
        }
        return new AbilityScoreModifier(score, value);
    }
}
