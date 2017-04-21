package com.schoolerc.fiftheditioncompanion.rules;

/**
 * Created by Chaz on 3/28/2017.
 */

public class SkillCheck implements DiceRoll {
    private Skill skill;

    public SkillCheck(Builder builder)
    {
        setSkill(builder.getSkill());
    }

    public Skill getSkill()
    {
        return skill;
    }

    public void setSkill(Skill skill)
    {
        this.skill = skill;
    }

    public static class Builder
    {
        private Skill skill;

        public Builder(){}

        public Builder skill(Skill skill)
        {
            this.skill = skill;
            return this;
        }

        public Skill getSkill()
        {
            return skill;
        }

        public SkillCheck build()
        {
            return new SkillCheck(this);
        }
    }
}
