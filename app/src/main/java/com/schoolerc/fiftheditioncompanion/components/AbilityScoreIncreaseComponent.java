package com.schoolerc.fiftheditioncompanion.components;


import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;

import org.simpleframework.xml.Attribute;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncreaseComponent extends Component {

    @Attribute
    private AbilityScore abilityScore;

    @Attribute
    private int modifier;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitAbilityScoreIncreaseComponent(this);
    }


    private AbilityScoreIncreaseComponent()
    {
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
