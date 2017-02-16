package com.schoolerc.ddcompanion.character;

/**
 * Created by Chaz Schooler on 1/28/2017.
 */

public final class CharacterUtilities {

    static public int scoreToBonus(int score)
    {
        return (int)Math.floor(score-10/2.0);
    }
}
