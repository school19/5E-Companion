package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;

/**
 * Created by Chaz on 4/14/2017.
 */

public class AbilityScoreModifierComponent extends Component {

    private int value;
    private AbilityScore target;

    public AbilityScoreModifierComponent(Builder builder) {

    }

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitAbilitiyScoreModifierComponent(this);
    }

    public static class Builder {
        private int value;
        private AbilityScore target;

        public Builder target(AbilityScore target) {
            this.target = target;
            return this;
        }

        public Builder value(int value) {
            this.value = value;
            return this;
        }

        public int getValue() {
            return value;
        }

        public AbilityScore getTarget() {
            return target;
        }

        public AbilityScoreModifierComponent build() {
            return new AbilityScoreModifierComponent(this);
        }
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
