package com.schoolerc.fiftheditioncompanion.entity.data;

import com.schoolerc.fiftheditioncompanion.entity.Component;
import com.schoolerc.fiftheditioncompanion.util.OnErrorListener;
import com.schoolerc.fiftheditioncompanion.util.Pair;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by Chaz Schooler on 3/31/2017.
 */

public class XmlTokenizer extends DefaultHandler implements TokenParser.Lexer {
    private static final String TAG = "XmlTokenizer";

    private Component parsedComponent;

    //XML tag name regexes that are direct components
    private final Pattern characterPattern = Pattern.compile("character", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
    private final Pattern abilityScoresPattern = Pattern.compile("ability-scores", Pattern.CASE_INSENSITIVE | Pattern.LITERAL);
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
    private final Pattern numberPattern = Pattern.compile("-?\\p{Digit}+");
    private final Pattern contentPattern = Pattern.compile(".*", Pattern.DOTALL);

    public XmlTokenizer(InputStream input, OnErrorListener listener)
    {
        this.listener = listener;
        tokenStream = new ArrayList<>();
        inputStream = input;
    }

    public void yyerror(String error)
    {
        listener.onError(new Exception(), error);
    }

    public Object getLVal()
    {
        return lval;
    }

    public int yylex()
    {
        if(!parsed)
        {
            parsed = true;
            SAXParserFactory factory = SAXParserFactory.newInstance();
            try {
                SAXParser parser = factory.newSAXParser();
                parser.parse(inputStream, this);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }

        if(index == tokenStream.size())
        {
            return EOF;
        }
        Pair<Integer, Object> token = tokenStream.get(index);
        index++;

        lval = token.second;
        return token.first;
    }

    private OnErrorListener listener;
    private List<Pair<Integer, Object>> tokenStream;
    private InputStream inputStream;
    private boolean parsed = false;
    private Object lval = null;
    private int index = 0;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        Matcher matcher = characterPattern.matcher(qName);
        int token = -1;

        if(matcher.matches())
        {
            token = CHARACTER_BEGIN_TOKEN;
        }

        matcher.usePattern(abilityScoresPattern);
        if(matcher.matches())
        {
            token = ABILITY_SCORES_BEGIN_TOKEN;
        }

        tokenStream.add(new Pair<>(token, new Object()));
        
        tokenizeAttributes(attributes);
    }

    private void tokenizeAttributes(Attributes attributes) {
        int length = attributes.getLength();
        Matcher matcher;
        int token = 0;
        Object lval;
        for (int i = 0; i < length; i++)
        {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);

            lval = value;

            matcher = namePattern.matcher(name);
            if(matcher.matches())
            {
                token = NAME_TOKEN;
            }

            matcher.usePattern(strengthPattern);
            if(matcher.matches())
            {
                token = STRENGTH_TOKEN;
                lval = Integer.parseInt(value);
            }

            matcher.usePattern(dexterityPattern);
            if(matcher.matches())
            {
                token = DEXTERITY_TOKEN;
                lval = Integer.parseInt(value);
            }

            matcher.usePattern(constitutionPattern);
            if(matcher.matches())
            {
                token = CONSTITUTION_TOKEN;
                lval = Integer.parseInt(value);
            }

            matcher.usePattern(intelligencePattern);
            if(matcher.matches())
            {
                token = INTELLIGENCE_TOKEN;
                lval = Integer.parseInt(value);
            }

            matcher.usePattern(wisdomPattern);
            if(matcher.matches())
            {
                token = WISDOM_TOKEN;
                lval = Integer.parseInt(value);
            }

            matcher.usePattern(charismaPattern);
            if(matcher.matches())
            {
                token = CHARISMA_TOKEN;
                lval = Integer.parseInt(value);
            }

            tokenStream.add(new Pair<>(token, lval));
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        Matcher matcher = characterPattern.matcher(qName);
        int token = 0;

        if(matcher.matches())
        {
            token = CHARACTER_END_TOKEN;
        }

        matcher.usePattern(abilityScoresPattern);
        if(matcher.matches())
        {
            token = ABILITY_SCORES_END_TOKEN;
        }

        tokenStream.add(new Pair<>(token, new Object()));
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String testString = new String(ch, start, length);
        //Go from less specific to more specific to properly handle priority and overwriting token and lval values

    }
}
