package com.schoolerc.fiftheditioncompanion.entity;


import com.schoolerc.fiftheditioncompanion.entity.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncreaseComponent extends Component {
    private AbilityScore abilityScore;
    private int bonus;

    @Override
    void accept(ComponentVisitor visitor) {

    }

    @Override
    public int getStrengthScore() {
        return 0;
    }

    @Override
    public int getDexterityScore() {
        return 0;
    }

    @Override
    public int getConstitutionScore() {
        return 0;
    }

    @Override
    public int getIntelligenceScore() {
        return 0;
    }

    @Override
    public int getWisdomScore() {
        return 0;
    }

    @Override
    public int getCharismaScore() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }

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
