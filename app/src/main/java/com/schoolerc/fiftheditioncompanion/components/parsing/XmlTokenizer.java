package com.schoolerc.fiftheditioncompanion.components.parsing;

import android.util.Xml;

import com.schoolerc.fiftheditioncompanion.util.Pair;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Chaz on 4/13/2017.
 */

public class XmlTokenizer implements Tokenizer {
    private Map<String, Token> startTagMap = new HashMap<>();
    {
        startTagMap.put("character", Token.CharacterBegin);
        startTagMap.put("ability-scores", Token.AbilityScoresBegin);
        startTagMap.put("strength", Token.StrengthBegin);
        startTagMap.put("dexterity", Token.DexterityBegin);
        startTagMap.put("constitution", Token.ConstitutionBegin);
        startTagMap.put("intelligence", Token.IntelligenceBegin);
        startTagMap.put("wisdom", Token.WisdomBegin);
        startTagMap.put("charisma", Token.CharismaBegin);
        startTagMap.put("ability-score-modifier", Token.AbilityScoreModifierBegin);
        startTagMap.put("ability-score-target", Token.AbilityScoreTargetBegin);
        startTagMap.put("value", Token.ValueBegin);
        startTagMap.put("choose", Token.ChooseBegin);
        startTagMap.put("quantity", Token.QuantityBegin);
        startTagMap.put("options", Token.OptionsBegin);
    }

    private Map<String, Token> endTagMap = new HashMap<>();
    {
        endTagMap.put("character", Token.CharacterEnd);
        endTagMap.put("ability-scores", Token.AbilityScoresEnd);
        endTagMap.put("strength", Token.StrengthEnd);
        endTagMap.put("dexterity", Token.DexterityEnd);
        endTagMap.put("constitution", Token.ConstitutionEnd);
        endTagMap.put("intelligence", Token.IntelligenceEnd);
        endTagMap.put("wisdom", Token.WisdomEnd);
        endTagMap.put("charisma", Token.CharismaEnd);
        endTagMap.put("ability-score-modifier", Token.AbilityScoreModifierEnd);
        endTagMap.put("ability-score-target", Token.AbilityScoreTargetEnd);
        endTagMap.put("value", Token.ValueEnd);
        endTagMap.put("choose", Token.ChooseEnd);
        endTagMap.put("quantity", Token.QuantityEnd);
        endTagMap.put("options", Token.OptionsEnd);
    }

    private List<Pair<Pattern, Token>> contentPatterns = new ArrayList<>();
    {
        //Order Matters!!!!!
        //Go from less specific to more specific
        contentPatterns.add(new Pair<>(Pattern.compile(".", Pattern.DOTALL), Token.Text));
        contentPatterns.add(new Pair<>(Pattern.compile("-?\\p{Digit}+"), Token.Number));
        contentPatterns.add(new Pair<>(Pattern.compile("strength", Pattern.CASE_INSENSITIVE | Pattern.LITERAL), Token.Strength));
        contentPatterns.add(new Pair<>(Pattern.compile("dexterity", Pattern.CASE_INSENSITIVE | Pattern.LITERAL), Token.Dexterity));
        contentPatterns.add(new Pair<>(Pattern.compile("constitution", Pattern.CASE_INSENSITIVE | Pattern.LITERAL), Token.Constitution));
        contentPatterns.add(new Pair<>(Pattern.compile("intelligence", Pattern.CASE_INSENSITIVE | Pattern.LITERAL), Token.Intelligence));
        contentPatterns.add(new Pair<>(Pattern.compile("wisdom", Pattern.CASE_INSENSITIVE | Pattern.LITERAL), Token.Wisdom));
        contentPatterns.add(new Pair<>(Pattern.compile("charisma", Pattern.CASE_INSENSITIVE | Pattern.LITERAL), Token.Charisma));
    }


    private boolean parsed = false;
    private int index = 0;
    private List<Pair<Token, String>> tokenStream;
    private XmlPullParser pullParser;
    public XmlTokenizer(InputStream inputStream)
    {
        pullParser = Xml.newPullParser();
        try {
            pullParser.setInput(inputStream, null);
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        tokenStream = new ArrayList<>();
    }

    private Token stringMapToToken(String str, Map<String, Token> map)
    {
        String tmp = str.toLowerCase();
        return map.get(tmp);
    }

    private void processStartTag()
    {
        Token token = stringMapToToken(pullParser.getName(), startTagMap);
        tokenStream.add(new Pair<>(token, pullParser.getName()));
    }

    private void processEndTag()
    {
        Token token = stringMapToToken(pullParser.getName(), endTagMap);
        tokenStream.add(new Pair<>(token, pullParser.getName()));
    }

    private void processText()
    {
        Matcher m = Pattern.compile("").matcher("");
        Token t = Token.EOF;
        for (Pair<Pattern, Token> pair : contentPatterns) {
            m.usePattern(pair.first);
            if(m.matches())
            {
                t = pair.second;
            }
        }

        tokenStream.add(new Pair<>(t, pullParser.getText()));
    }

    private void parse()
    {
        try
        {
            int event = pullParser.next();
            while(event != XmlPullParser.END_DOCUMENT)
            {
                switch(event)
                {
                    case XmlPullParser.TEXT:
                        processText();
                        break;
                    case XmlPullParser.END_TAG:
                        processEndTag();
                        break;
                    case XmlPullParser.START_TAG:
                        processStartTag();
                        break;
                    default:
                        break;
                }
                event = pullParser.next();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally
        {
            tokenStream.add(new Pair<>(Token.EOF, ""));
            parsed = true;
        }
    }

    @Override
    public String lval()
    {
        //go back one on the index because the lval matches the token returned from next()
        //and next() increments the index value
        return tokenStream.get(index-1).second;
    }

    @Override
    public Token peek() {
        if(!parsed)
        {
            parse();
        }
        return tokenStream.get(index).first;
    }

    @Override
    public Token next() {
        if(!parsed)
        {
            parse();
        }
        return tokenStream.get(index++).first;
    }
}
