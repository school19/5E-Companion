package com.schoolerc.fiftheditioncompanion.entity;


import com.schoolerc.fiftheditioncompanion.entity.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncreaseComponent extends Component {
    private AbilityScore abilityScore;
    private int increase;

    @Override
    void accept(ComponentVisitor visitor) {
        visitor.visitAbilityScoreIncreaseComponent(this);
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
        private int increase;

        public Builder abilityScore(AbilityScore score)
        {
            abilityScore = score;
            return this;
        }

        public Builder increase(int bonus)
        {
            this.increase = bonus;
            return this;
        }

        public AbilityScoreIncreaseComponent build()
        {
            return new AbilityScoreIncreaseComponent(this);
        }

        private int getIncrease()
        {
            return increase;
        }

        private AbilityScore getAbilityScore()
        {
            return abilityScore;
        }
    }

    private AbilityScoreIncreaseComponent(Builder b)
    {
        abilityScore = b.getAbilityScore();
        increase = b.getIncrease();
    }

    public void setIncrease(int increase)
    {
        this.increase = increase;
    }

    public void setAbilityScore(AbilityScore abilityScore)
    {
        this.abilityScore = abilityScore;
    }

    public int getIncrease()
    {
        return increase;
    }

    public AbilityScore getAbilityScore()
    {
        return abilityScore;
    }
}
