package com.schoolerc.dungeoncompanion.entity;

/**
 * Created by Chaz on 5/28/2017.
 */

public class ToughnessComponent extends Component {
    private int factor;

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public ToughnessComponent(){}

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public void apply(CharacterState state) {
        int increase = state.getCharacterLevel()*getFactor();
        state.setMaximumHitPoints(state.getMaximumHitPoints()+increase);
    }
}
