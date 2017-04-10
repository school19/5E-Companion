package com.schoolerc.fiftheditioncompanion.entity;


import com.schoolerc.fiftheditioncompanion.entity.operators.ComponentVisitor;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class VisionComponent extends Component {
    private int range;

    @Override
    public void accept(ComponentVisitor visitor) {

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
}
