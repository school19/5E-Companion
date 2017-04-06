package com.schoolerc.fiftheditioncompanion.entity;

import com.schoolerc.fiftheditioncompanion.entity.operators.ComponentVisitor;

import java.util.List;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class ChooseComponent extends Component {

    private int quantity;
    private List<Component> components;

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
}
