package com.schoolerc.dungeoncompanion.data;

import android.util.JsonReader;

import com.schoolerc.dungeoncompanion.entity.CharacterClass;
import com.schoolerc.dungeoncompanion.entity.Race;

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
            }
        }

        reader.endObject();

        return r;
    }
}
