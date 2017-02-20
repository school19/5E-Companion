package com.schoolerc.ddcompanion.util;

/**
 * Created by Chaz Schooler on 1/28/2017.
 */

public final class Math {

    static public int scoreToBonus(int score)
    {
        return (int) java.lang.Math.floor(score-10/2.0);
    }
}
