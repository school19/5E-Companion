package com.schoolerc.ddcompanion.character;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/**
 * Created by Chaz Schooler on 2/7/2017.
 */

public class AbilityScoreIncreaseComponent extends Component {
    private final static String STR_STRENGTH = "strength";
    private final static String STR_DEXTERITY = "dexterity";
    private final static String STR_CONSTITUTION = "constitution";
    private final static String STR_INTELLIGENCE = "intelligence";
    private final static String STR_WISDOM = "wisdom";
    private final static String STR_CHARISMA = "charisma";

    private final static String ATTR_SCORE = "score";

    private AbilityScore abilityScore;
    private int bonus;

    @Override
    public void load(XmlPullParser element) throws XmlPullParserException {
        super.load(element);
    }
}
