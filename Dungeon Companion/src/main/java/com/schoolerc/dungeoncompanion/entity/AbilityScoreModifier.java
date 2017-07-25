package com.schoolerc.dungeoncompanion.entity;

import android.support.annotation.NonNull;

/**
 * Created by Chaz on 5/15/2017.
 */

public class AbilityScoreModifier extends Component {
    private AbilityScore target;
    private int value;

    public AbilityScoreModifier(AbilityScore target, int value)
    {
        this.target = target;
        this.value = value;
    }

    public String toString()
    {
        return "Ability Score Modifier: " + (value > 0 ? "+" : "") + value + " " + target.toString();
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void apply(CharacterState state) {

    }
}
