package com.schoolerc.dungeoncompanion.util;

/**
 * Created by Chaz Schooler on 1/28/2017.
 */

public final class Math {
    private Math(){}
    static public int scoreToBonus(int score)
    {
        return (int) java.lang.Math.floor((score-10)/2.0);
    }
}
