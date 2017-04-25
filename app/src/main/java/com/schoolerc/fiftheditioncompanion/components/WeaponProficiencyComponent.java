package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.rules.WeaponType;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz on 4/24/2017.
 */

public class WeaponProficiencyComponent extends Component {
    @Element
    private WeaponType proficientIn;

    public WeaponProficiencyComponent(){}

    public WeaponType getProficient()
    {
        return proficientIn;
    }

    public void setProficient(WeaponType type)
    {
        proficientIn = type;
    }
}
