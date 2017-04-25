package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;
import com.schoolerc.fiftheditioncompanion.rules.ArmorType;
import com.schoolerc.fiftheditioncompanion.rules.Skill;
import com.schoolerc.fiftheditioncompanion.rules.WeaponType;

import org.simpleframework.xml.ElementList;

import java.util.List;

/**
 * Created by Chaz Schooler on 2/5/2017.
 */

public class ClassComponent extends Component {

    @ElementList
    private List<AbilityScore> savingThrowProviciencies;

    @ElementList
    private List<WeaponType> weaponProficiencies;

    @ElementList
    private List<ArmorType> armorProficiencies;


    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitClassComponent(this);
    }

    public ClassComponent()
    {

    }
}
