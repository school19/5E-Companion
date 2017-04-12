package com.schoolerc.fiftheditioncompanion.items;

import com.schoolerc.fiftheditioncompanion.components.Component;
import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

/**
 * Created by Chaz on 4/9/2017.
 */

public class Weapon extends Component {
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
