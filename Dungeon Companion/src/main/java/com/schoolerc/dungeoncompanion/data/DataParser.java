package com.schoolerc.dungeoncompanion.data;

import com.schoolerc.dungeoncompanion.entity.CharacterClass;
import com.schoolerc.dungeoncompanion.entity.Race;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Chaz on 5/27/2017.
 */

public interface DataParser {

    Race parseRace(InputStream inputStream) throws IOException;
    CharacterClass parseCharacterClass(InputStream inputStream) throws IOException;
}
