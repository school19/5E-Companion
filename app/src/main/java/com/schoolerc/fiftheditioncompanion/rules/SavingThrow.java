package com.schoolerc.fiftheditioncompanion.rules;

/**
 * Created by Chaz on 4/21/2017.
 */

public class SavingThrow implements DiceRoll {
    private AbilityScore score;
    private int dc;

    public AbilityScore getScore()
    {
        return score;
    }

    public int getDc()
    {
        return dc;
    }

    public void setScore(AbilityScore score)
    {
        this.score = score;
    }

    public void setDc(int dc)
    {
        this.dc = dc;
    }

    public SavingThrow(Builder builder)
    {
        setDc(builder.getDc());
        setScore(builder.getScore());
    }

    public static class Builder
    {
        private AbilityScore score;
        private int dc;

        public Builder(){}

        public Builder score(AbilityScore score)
        {
            this.score = score;
            return this;
        }

        public Builder dc(int dc)
        {
            this.dc = dc;
            return this;
        }

        public SavingThrow build()
        {
            return new SavingThrow(this);
        }

        public int getDc()
        {
            return dc;
        }

        public AbilityScore getScore()
        {
            return score;
        }
    }
}
