package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz on 4/14/2017.
 */

public class AbilityScoreModifierComponent extends Component {

    @Element
    private int value;

    @Element
    private AbilityScore target;

    public AbilityScoreModifierComponent() {

    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitAbilitiyScoreModifierComponent(this);
    }


    public int getValue() {
        return value;
    }

    public AbilityScore getTarget() {
        return target;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setTarget(AbilityScore target) {
        this.target = target;
    }
}
