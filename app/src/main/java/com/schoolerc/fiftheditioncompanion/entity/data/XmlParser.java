package com.schoolerc.fiftheditioncompanion.entity.data;

import android.util.Log;

import com.schoolerc.fiftheditioncompanion.entity.Component;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.regex.Pattern;

/**
 * Created by Chaz Schooler on 3/31/2017.
 */

public class XmlParser extends DefaultHandler implements TokenParser.Lexer, ComponentParser, ParserCallbacks {
    private static final String TAG = "XmlParser";

    private Component parsedComponent;

    //XML tag name regexes that are direct components
    private final Pattern characterPattern = Pattern.compile("character", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern abilityScorePattern = Pattern.compile("ability-score", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern abilityScoreImprovementPattern = Pattern.compile("ability-score-improvement", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern advantagePattern = Pattern.compile("advantage", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern choosePattern = Pattern.compile("choose", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern classPattern = Pattern.compile("class", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern conditionPattern = Pattern.compile("condition", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern damagePattern = Pattern.compile("damage", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern disadvantagePattern = Pattern.compile("disadvantage", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern immunityPattern = Pattern.compile("immunity", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern languagePattern = Pattern.compile("language", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern racePattern = Pattern.compile("race", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern resistancePattern = Pattern.compile("resistance", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern skillPattern = Pattern.compile("skill", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern speedPattern = Pattern.compile("speed", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern subracePattern = Pattern.compile("subrace", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern traitPattern = Pattern.compile("trait", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern visionPattern = Pattern.compile("vision", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);

    //XML tag name regexes that are attributes
    private final Pattern namePattern = Pattern.compile("name", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern quantityPattern = Pattern.compile("quantity", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern optionsPattern = Pattern.compile("options", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern targetPattern = Pattern.compile("target", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern valuePattern = Pattern.compile("value", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);

    //Ability score constants
    private final Pattern strengthPattern = Pattern.compile("strength", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern dexterityPattern = Pattern.compile("dexterity", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern constitutionPattern = Pattern.compile("constitution", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern intelligencePattern = Pattern.compile("intelligence", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern wisdomPattern = Pattern.compile("wisdom", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern charismaPattern = Pattern.compile("charisma", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);

    //Skill constants
    private final Pattern acrobaticsPattern = Pattern.compile("acrobatics", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern animalHandlingPattern = Pattern.compile("animal handling", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern arcanaPattern = Pattern.compile("arcana", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern athleticsPattern = Pattern.compile("athletics", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern deceptionPattern = Pattern.compile("deception", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern historyPattern = Pattern.compile("history", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern insightPattern = Pattern.compile("insight", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern intimidationPattern = Pattern.compile("intimidation", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern investigationPattern = Pattern.compile("investigation", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern medicinePattern = Pattern.compile("medicine", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern naturePattern = Pattern.compile("nature", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern perceptionPattern = Pattern.compile("perception", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern performancePattern = Pattern.compile("performance", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern persuasionPattern = Pattern.compile("persuasion", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern religionPattern = Pattern.compile("religion", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern sleightOfHandPattern = Pattern.compile("sleight of hand", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern stealthPattern = Pattern.compile("stealth", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern survivalPattern = Pattern.compile("survival", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);

    //General regexes
    private final Pattern numberPattern = Pattern.compile("\\p{Digit}+");
    private final Pattern contentPattern = Pattern.compile(".");

    public void yyerror(String error)
    {
        Log.e(TAG, error);
    }

    public Object getLVal()
    {
        return null;
    }

    public int yylex()
    {
        return TokenParser.YYERROR;
    }

    public Component parse(InputStream input)
    {
        TokenParser parser = new TokenParser(this, this);
        return parsedComponent;
    }

    public void doneParsing(Component component)
    {
        parsedComponent = component;
    }
}
