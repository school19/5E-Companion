package com.schoolerc.fiftheditioncompanion.rules;

import android.os.Parcel;
import android.os.Parcelable;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;

import java.io.Serializable;

import com.schoolerc.fiftheditioncompanion.rules.visitors.AbilityScoreCalculator;
import com.schoolerc.fiftheditioncompanion.rules.visitors.ProficiencyChecker;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Transient;


/**
 * Created by Chaz Schooler on 12/30/2016.
 */
public class Character extends Component implements Parcelable{

    @Transient
    private AbilityScoreCalculator abilityScoreCalculator = new AbilityScoreCalculator();

    @Transient
    private ProficiencyChecker proficiencyChecker = new ProficiencyChecker();

    @Element
    private String name;

    @Element(name="strength")
    private int baseStrength;
    @Element(name="dexterity")
    private int baseDexterity;
    @Element(name="constitution")
    private int baseConstitution;
    @Element(name="intelligence")
    private int baseIntelligence;
    @Element(name="wisdom")
    private int baseWisdom;
    @Element(name="charisma")
    private int baseCharisma;

    @Element
    private Race race;
    @Element(name="class")
    private Class characterClass;

    public Character() {
    }

    @Override
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public void accept(ComponentVisitor visitor)
    {
        visitor.visitCharacter(this);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags)
    {
        super.writeToParcel(out, flags);

        out.writeString(name);

        out.writeInt(baseStrength);
        out.writeInt(baseDexterity);
        out.writeInt(baseIntelligence);
        out.writeInt(baseWisdom);
        out.writeInt(baseCharisma);

        out.writeParcelable(race, flags);
        out.writeParcelable(characterClass, flags);
    }

}
