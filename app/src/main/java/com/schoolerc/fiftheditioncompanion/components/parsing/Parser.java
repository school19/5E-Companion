package com.schoolerc.fiftheditioncompanion.components.parsing;


import android.support.annotation.NonNull;

import com.schoolerc.fiftheditioncompanion.components.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.components.AbilityScoreModifierComponent;
import com.schoolerc.fiftheditioncompanion.components.Character;
import com.schoolerc.fiftheditioncompanion.components.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.components.ClassComponent;
import com.schoolerc.fiftheditioncompanion.components.ClassComponentProxy;
import com.schoolerc.fiftheditioncompanion.components.Component;
import com.schoolerc.fiftheditioncompanion.components.RaceComponent;
import com.schoolerc.fiftheditioncompanion.components.RaceComponentProxy;
import com.schoolerc.fiftheditioncompanion.components.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.components.SubraceComponentProxy;
import com.schoolerc.fiftheditioncompanion.components.TraitComponent;
import com.schoolerc.fiftheditioncompanion.rules.AbilityScore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;


public class Parser {
    private Tokenizer tokenizer;

    public Parser(Tokenizer t) {
        tokenizer = t;
    }

    public Component parse() throws ParseException {
        //root of grammar
        //root: component
        return parseComponent();
    }

    private Component parseComponent() throws ParseException {
        /*
        component: character
            | ability_score_component
         */
        switch (tokenizer.peek()) {
            case CharacterBegin:
                return parseCharacter();
            case AbilityScoresBegin:
                return parseAbilityScoreComponent();
            case AbilityScoreModifierBegin:
                return parseAbilityScoreModifier();
            case ChooseBegin:
                return parseChooseComponent();
            case RaceBegin:
                return parseRaceComponent();
            case ClassBegin:
                return parseClassComponent();
            case SubraceBegin:
                return parseSubraceComponent();
            case RaceProxyBegin:
                return parseRaceComponentProxy();
            case ClassProxyBegin:
                return parseClassComponentProxy();
            case SubraceProxyBegin:
                return parseSubraceComponentProxy();
            case TraitBegin:
                return parseTraitComponent();
            default:
                throw new ParseException(
                        unexpectedOfList(
                                Arrays.asList(
                                        Token.CharacterBegin, Token.AbilityScoresBegin, Token.AbilityScoreModifierBegin, Token.ChooseBegin,
                                        Token.RaceBegin, Token.ClassBegin, Token.SubraceBegin, Token.RaceProxyBegin, Token.ClassProxyBegin,
                                        Token.SubraceProxyBegin, Token.TraitBegin),
                                tokenizer.peek()));
        }
    }

    private Character parseCharacter() throws ParseException {
        /*
        character: CHARACTER_BEGIN_TOKEN character_children CHARACTER_END_TOKEN
         */
        Token start = tokenizer.next();
        if (start != Token.CharacterBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.CharacterBegin, start));
        }
        Character.Builder builder = new Character.Builder();

        Token lookAhead = tokenizer.peek();
        while (lookAhead != Token.CharacterEnd) {
            switch (lookAhead) {
                case AbilityScoresBegin:
                case AbilityScoreModifierBegin:
                case ClassBegin:
                case RaceBegin:
                case SubraceBegin:
                case ClassProxyBegin:
                case SubraceProxyBegin:
                case RaceProxyBegin:
                    builder.child(parseComponent());
                    break;
                case NameBegin:
                    builder.name(parseName());
                    break;
                default:
                    throw new ParseException(
                            unexpectedOfList(
                                    Arrays.asList(
                                            Token.AbilityScoreModifierBegin, Token.AbilityScoresBegin, Token.NameBegin,
                                            Token.ClassBegin, Token.ClassProxyBegin, Token.RaceBegin, Token.RaceProxyBegin,
                                            Token.SubraceBegin, Token.SubraceProxyBegin),
                                    lookAhead));
            }
            lookAhead = tokenizer.peek();
        }

        Token end = tokenizer.next();
        if (end != Token.CharacterEnd) {
            throw new ParseException(unexpectedTokenStringFormat(Token.CharacterEnd, end));
        }

        return builder.build();
    }

    private String parseName() throws ParseException {
        Token t = tokenizer.next();
        if (t != Token.NameBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.NameBegin, t));
        }

        String result;
        t = tokenizer.next();
        if (t != Token.Text) {
            throw new ParseException(unexpectedTokenStringFormat(Token.Text, t));
        }

        result = tokenizer.lval();

        t = tokenizer.next();
        if (t != Token.NameEnd) {
            throw new ParseException(unexpectedTokenStringFormat(Token.NameEnd, t));
        }

        return result;
    }

    private int parseWrappedNumber(Token begin, Token end) throws ParseException {
        Token t = tokenizer.next();
        if (t != begin) {
            throw new ParseException(unexpectedTokenStringFormat(begin, t));
        }

        t = tokenizer.next();
        if (t != Token.Number) {
            throw new ParseException(unexpectedTokenStringFormat(Token.Number, t));
        }

        int result = Integer.parseInt(tokenizer.lval());

        t = tokenizer.next();
        if (t != end) {
            throw new ParseException(unexpectedTokenStringFormat(end, t));
        }

        return result;
    }

    private int parseStrength() throws ParseException {
        return parseWrappedNumber(Token.StrengthBegin, Token.StrengthEnd);
    }

    private int parseDexterity() throws ParseException {
        return parseWrappedNumber(Token.DexterityBegin, Token.DexterityEnd);
    }

    private int parseConstitution() throws ParseException {
        return parseWrappedNumber(Token.ConstitutionBegin, Token.ConstitutionEnd);
    }

    private int parseIntelligence() throws ParseException {
        return parseWrappedNumber(Token.IntelligenceBegin, Token.IntelligenceEnd);
    }

    private int parseWisdom() throws ParseException {
        return parseWrappedNumber(Token.WisdomBegin, Token.WisdomEnd);
    }

    private int parseCharisma() throws ParseException {
        return parseWrappedNumber(Token.CharacterBegin, Token.CharismaEnd);
    }

    private AbilityScoreComponent parseAbilityScoreComponent() throws ParseException {
        Token start = tokenizer.next();
        if (start != Token.AbilityScoresBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.AbilityScoresBegin, start));
        }

        AbilityScoreComponent.Builder builder = new AbilityScoreComponent.Builder();

        Token lookahead = tokenizer.peek();
        while (lookahead != Token.AbilityScoresEnd) {
            switch (lookahead) {
                case StrengthBegin:
                    builder.strength(parseStrength());
                    break;
                case DexterityBegin:
                    builder.dexterity(parseDexterity());
                    break;
                case ConstitutionBegin:
                    builder.constitution(parseConstitution());
                    break;
                case IntelligenceBegin:
                    builder.intelligence(parseIntelligence());
                    break;
                case WisdomBegin:
                    builder.wisdom(parseWisdom());
                    break;
                case CharismaBegin:
                    builder.charisma(parseCharisma());
                    break;
                default:
                    throw new ParseException(unexpectedChildStringFormat("AbilityScoreComponent", lookahead));
            }
            lookahead = tokenizer.peek();
        }

        return builder.build();
    }

    private AbilityScoreModifierComponent parseAbilityScoreModifier() throws ParseException {
        Token start = tokenizer.next();
        if (start != Token.AbilityScoreModifierBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.AbilityScoreModifierBegin, start));
        }

        AbilityScoreModifierComponent.Builder builder = new AbilityScoreModifierComponent.Builder();

        Token lookahead = tokenizer.peek();
        while (lookahead != Token.AbilityScoreModifierEnd) {
            switch (lookahead) {
                case AbilityScoreTargetBegin:
                    builder.target(parseAbiltiyScoreTarget());
                    break;
                case ValueBegin:
                    builder.value(parseValue());
                    break;
            }
            lookahead = tokenizer.peek();
        }

        return builder.build();
    }

    private int parseValue() throws ParseException {
        return parseWrappedNumber(Token.ValueBegin, Token.ValueEnd);
    }

    private AbilityScore parseAbiltiyScoreTarget() throws ParseException {
        Token start = tokenizer.next();
        if (start != Token.AbilityScoreTargetBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.AbilityScoreTargetBegin, start));
        }

        AbilityScore result;
        Token target = tokenizer.next();
        switch (target) {
            case Strength:
                result = AbilityScore.Strength;
                break;
            case Dexterity:
                result = AbilityScore.Dexterity;
                break;
            case Constitution:
                result = AbilityScore.Constitution;
                break;
            case Intelligence:
                result = AbilityScore.Intelligence;
                break;
            case Wisdom:
                result = AbilityScore.Wisdom;
                break;
            case Charisma:
                result = AbilityScore.Charisma;
                break;
            default:
                throw new ParseException(unexpectedOfList(Arrays.asList(Token.Strength, Token.Dexterity, Token.Constitution, Token.Intelligence, Token.Wisdom, Token.Charisma), target));
        }

        Token end = tokenizer.next();
        if (end != Token.AbilityScoreTargetEnd) {
            throw new ParseException(unexpectedTokenStringFormat(Token.AbilityScoreTargetEnd, end));
        }

        return result;
    }

    private TraitComponent parseTraitComponent() throws ParseException {
        Token start = tokenizer.next();
        if (start != Token.TraitBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.TraitBegin, start));
        }

        TraitComponent.Builder builder = new TraitComponent.Builder();

        Token lookahead = tokenizer.peek();
        while (lookahead != Token.TraitEnd) {
            switch (lookahead) {
                case NameBegin:
                    builder.name(parseName());
                    break;
                case ComponentListBegin:
                    builder.children(parseComponentList(Token.ComponentListBegin, Token.ComponentListEnd));
                    break;
                case DescriptionBegin:
                    builder.description(parseDescription());
                    break;
                default:
                    throw new ParseException(unexpectedOfList(Arrays.asList(Token.NameBegin, Token.ComponentListBegin, Token.DescriptionBegin), lookahead));
            }
            lookahead = tokenizer.peek();
        }

        return builder.build();
    }

    private ChooseComponent parseChooseComponent() throws ParseException {
        Token start = tokenizer.next();
        if (start != Token.ChooseBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.ChooseBegin, start));
        }

        ChooseComponent.Builder builder = new ChooseComponent.Builder();

        Token lookahead = tokenizer.peek();
        while (lookahead != Token.ChooseEnd) {
            switch (lookahead) {
                case QuantityBegin:
                    builder.quantity(parseQuantity());
                    break;
                case OptionsBegin:
                    builder.options(parseOptions());
                    break;
            }
            lookahead = tokenizer.peek();
        }

        Token end = tokenizer.next();
        if (end != Token.ChooseEnd) {
            throw new ParseException(unexpectedTokenStringFormat(Token.ChooseEnd, end));
        }

        return builder.build();
    }

    private RaceComponent parseRaceComponent() throws ParseException {
        Token start = tokenizer.next();
        if (start != Token.RaceBegin) {
            throw new ParseException(unexpectedTokenStringFormat(Token.RaceBegin, start));
        }

        RaceComponent.Builder builder = new RaceComponent.Builder();

        Token lookahead = tokenizer.peek();
        while (lookahead != Token.RaceEnd) {
            switch (lookahead) {
                case SubraceBegin:
                case SubraceProxyBegin:
                case AbilityScoreModifierBegin:
                case TraitBegin:
                    builder.child(parseComponent());
                    break;
                case NameBegin:
                    builder.name(parseName());
                    break;
                default:
                    throw new ParseException(unexpectedOfList(Arrays.asList(Token.SubraceBegin, Token.SubraceProxyBegin, Token.AbilityScoreModifierBegin, Token.TraitBegin), lookahead));
            }
            lookahead = tokenizer.peek();
        }

        Token end = tokenizer.next();
        if (end != Token.RaceEnd) {
            throw new ParseException(unexpectedTokenStringFormat(Token.RaceEnd, end));
        }

        return builder.build();
    }

    private RaceComponentProxy parseRaceComponentProxy() throws ParseException {
        return null;
    }

    private ClassComponent parseClassComponent() throws ParseException {
        return null;
    }

    private ClassComponentProxy parseClassComponentProxy() throws ParseException {
        return null;
    }

    private SubraceComponent parseSubraceComponent() throws ParseException {
        return null;
    }

    private SubraceComponentProxy parseSubraceComponentProxy() throws ParseException {
        return null;
    }

    private int parseQuantity() throws ParseException {
        return parseWrappedNumber(Token.QuantityBegin, Token.QuantityEnd);
    }

    private List<Component> parseOptions() throws ParseException {
        return parseComponentList(Token.OptionsBegin, Token.OptionsEnd);
    }

    private List<Component> parseComponentList(Token start, Token end) throws ParseException {
        Token t = tokenizer.next();
        if (t != start) {
            throw new ParseException(unexpectedTokenStringFormat(start, t));
        }

        List<Component> list = new ArrayList<>();
        Token lookahead = tokenizer.peek();
        while (lookahead != end) {
            list.add(parseComponent());
            lookahead = tokenizer.peek();
        }

        t = tokenizer.next();
        if (t != end) {
            throw new ParseException(unexpectedTokenStringFormat(end, t));
        }

        return list;
    }

    private String parseWrappedString(Token start, Token end) throws ParseException {
        Token t = tokenizer.next();
        if (t != start) {
            throw new ParseException(unexpectedTokenStringFormat(start, t));
        }

        t = tokenizer.next();
        if (t != Token.Text) {
            throw new ParseException(unexpectedTokenStringFormat(Token.Text, t));
        }
        String result = tokenizer.lval();

        t = tokenizer.next();
        if (t != end) {
            throw new ParseException(unexpectedTokenStringFormat(end, t));
        }

        return result;
    }

    private String parseDescription() throws ParseException {
        return parseWrappedString(Token.DescriptionBegin, Token.DescriptionEnd);
    }

    private String unexpectedOfList(List<Token> expected, Token unexpected) {
        StringBuilder builder = new StringBuilder();
        builder.append("Parse Error: Expected one of (");
        for (Token token : expected) {
            builder.append(token.toString())
                    .append(", ");
        }
        builder.deleteCharAt(builder.length() - 1);
        builder.deleteCharAt(builder.length() - 1);

        builder.append("), got ")
                .append(unexpected.toString())
                .append(" instead");

        return builder.toString();
    }

    private String unexpectedTokenStringFormat(Token expected, Token unexpected) {
        Formatter formatter = new Formatter();
        formatter.format("Parse Error: Expected %s token, got %s token instead", expected.toString(), unexpected.toString());

        return formatter.toString();
    }

    private String unexpectedChildStringFormat(String parent, Token unexpected) {
        Formatter formatter = new Formatter();
        formatter.format("Parse Error: parent %s has no rule for child token %s", parent, unexpected.toString());

        return formatter.toString();
    }
}
