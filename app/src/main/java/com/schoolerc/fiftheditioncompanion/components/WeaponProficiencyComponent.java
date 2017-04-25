package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.rules.WeaponType;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz on 4/24/2017.
 */

public class WeaponProficiencyComponent extends Component {
    @Element
    private WeaponType weapon;

    public WeaponProficiencyComponent(){}

    public WeaponType getProficient()
    {
        return weapon;
    }

    public void setProficient(WeaponType type)
    {
        weapon = type;
    }
}
