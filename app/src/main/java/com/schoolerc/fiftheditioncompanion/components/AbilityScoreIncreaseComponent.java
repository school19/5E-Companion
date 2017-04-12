package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncreaseComponent extends Component {
    private AbilityScore abilityScore;
    private int modifier;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitAbilityScoreIncreaseComponent(this);
    }

    public static class Builder
    {
        public Builder()
        {
        }

        private AbilityScore abilityScore;
        private int modifier;

        public Builder abilityScore(AbilityScore score)
        {
            abilityScore = score;
            return this;
        }

        public Builder modifier(int bonus)
        {
            this.modifier = bonus;
            return this;
        }

        public AbilityScoreIncreaseComponent build()
        {
            return new AbilityScoreIncreaseComponent(this);
        }

        private int getModifier()
        {
            return modifier;
        }

        private AbilityScore getAbilityScore()
        {
            return abilityScore;
        }
    }

    private AbilityScoreIncreaseComponent(Builder b)
    {
        setAbilityScore(b.getAbilityScore());
        setModifier(b.getModifier());
    }

    public void setModifier(int modifier)
    {
        this.modifier = modifier;
    }

    public void setAbilityScore(AbilityScore abilityScore)
    {
        this.abilityScore = abilityScore;
    }

    public int getModifier()
    {
        return modifier;
    }

    public AbilityScore getAbilityScore()
    {
        return abilityScore;
    }
}
