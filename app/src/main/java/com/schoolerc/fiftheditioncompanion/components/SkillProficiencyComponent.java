package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.rules.Skill;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz on 4/24/2017.
 */

public class SkillProficiencyComponent extends Component {
    @Element(name="skill")
    Skill proficientIn;
}
