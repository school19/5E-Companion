package com.schoolerc.fiftheditioncompanion.entity;


/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncreaseComponent implements Component {
    private AbilityScore abilityScore;
    private int bonus;

    public static class Builder
    {
        public Builder()
        {
        }

        private AbilityScore abilityScore;
        private int bonus;

        public Builder abilityScore(AbilityScore score)
        {
            abilityScore = score;
            return this;
        }

        public Builder bonus(int bonus)
        {
            this.bonus = bonus;
            return this;
        }

        public AbilityScoreIncreaseComponent build()
        {
            return new AbilityScoreIncreaseComponent(this);
        }

        private int getBonus()
        {
            return bonus;
        }

        private AbilityScore getAbilityScore()
        {
            return abilityScore;
        }
    }

    private AbilityScoreIncreaseComponent(Builder b)
    {
        abilityScore = b.getAbilityScore();
        bonus = b.getBonus();
    }
}
