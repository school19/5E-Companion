/**
 * Created by Chaz on 4/2/2017.
 */

package com.schoolerc.fiftheditioncompanion;

import com.schoolerc.fiftheditioncompanion.entity.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.entity.Character;
import com.schoolerc.fiftheditioncompanion.entity.Component;
import com.schoolerc.fiftheditioncompanion.entity.parsing.ParserCallbacks;
import com.schoolerc.fiftheditioncompanion.entity.parsing.TokenParser;
import com.schoolerc.fiftheditioncompanion.entity.parsing.XmlTokenizer;
import com.schoolerc.fiftheditioncompanion.util.OnErrorListener;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlParsingTest implements OnErrorListener, ParserCallbacks{

    private static final String characterNameTestString = "<character><name>Aelar</name></character>";
    private static final String abilityScoresTestString = "<ability-scores><strength>10</strength><dexterity>11</dexterity><constitution>12</constitution><intelligence>13</intelligence><wisdom>14</wisdom><charisma>15</charisma></ability-scores>";
    private static final String abilityScoreImprovementTestString = "<ability-score-improvement><";


    private Component parseResult;

    @Test
    public void characterNameParseTest()
    {
        Character.Builder testBuilder = new Character.Builder();
        Character testCharacter = testBuilder.name("Aelar").build();

        parseString(characterNameTestString);
        int i = 0;
        Assert.assertEquals(testCharacter.getName(), parseResult.getName());
    }

    @Test
    public void characterAbilityScoresParseTest()
    {
        AbilityScoreComponent.Builder abilityBuilder = new AbilityScoreComponent.Builder();
        AbilityScoreComponent component = abilityBuilder.strength(10)
                .dexterity(11)
                .constitution(12)
                .intelligence(13)
                .wisdom(14)
                .charisma(15)
                .build();

        parseString(abilityScoresTestString);

        Assert.assertEquals(component.getStrengthScore(), parseResult.getStrengthScore());
        Assert.assertEquals(component.getDexterityScore(), parseResult.getDexterityScore());
        Assert.assertEquals(component.getConstitutionScore(), parseResult.getConstitutionScore());
        Assert.assertEquals(component.getIntelligenceScore(), parseResult.getIntelligenceScore());
        Assert.assertEquals(component.getWisdomScore(), parseResult.getWisdomScore());
        Assert.assertEquals(component.getCharismaScore(), parseResult.getCharismaScore());

    }

    private void parseString(String src)
    {
        InputStream stream = new ByteArrayInputStream(src.getBytes());
        XmlTokenizer tokenizer = new XmlTokenizer(stream, this);
        TokenParser parser = new TokenParser(tokenizer, this);

        parser.setDebugLevel(4);
        parser.setDebugStream(System.out);

        try {
            if(!parser.parse())
            {
                Assert.fail();
            }
        } catch (IOException e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void onError(Exception ex, Object data)
    {
        //System.out.println((String)data);
    }

    public void doneParsing(Component component)
    {
        parseResult = component;
    }
}
