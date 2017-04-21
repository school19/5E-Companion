package com.schoolerc.fiftheditioncompanion.components.parsing;


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
import com.schoolerc.fiftheditioncompanion.rules.Skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.List;


public class Parser {
    private Tokenizer tokenizer;

    public Parser(Tokenizer t) {
        tokenizer = t;
    }

    //Parsing entry point
    public Component parse() throws ParseException {
        //root of grammar
        //root: component
        return parseComponent();
    }

    //Component parsing methods
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
        requireNext(Token.CharacterBegin);
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

        requireNext(Token.CharacterEnd);

        return builder.build();
    }

    private AbilityScoreComponent parseAbilityScoreComponent() throws ParseException {
        requireNext(Token.AbilityScoresBegin);

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

        requireNext(Token.AbilityScoresEnd);

        return builder.build();
    }

    private AbilityScoreModifierComponent parseAbilityScoreModifier() throws ParseException {
        requireNext(Token.AbilityScoreModifierBegin);

        AbilityScoreModifierComponent.Builder builder = new AbilityScoreModifierComponent.Builder();

        Token lookahead = tokenizer.peek();
        while (lookahead != Token.AbilityScoreModifierEnd) {
            switch (lookahead) {
                case AbilityScoreTargetBegin:
                    builder.target(parseAbilityScoreTarget());
                    break;
                case ValueBegin:
                    builder.value(parseValue());
                    break;
            }
            lookahead = tokenizer.peek();
        }

        requireNext(Token.AbilityScoreModifierEnd);

        return builder.build();
    }

    private AbilityScore parseAbilityScoreTarget() throws ParseException {
        requireNext(Token.AbilityScoreTargetBegin);

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

        requireNext(Token.AbilityScoreTargetEnd);

        return result;
    }

    private TraitComponent parseTraitComponent() throws ParseException {
        requireNext(Token.TraitBegin);

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

        requireNext(Token.TraitEnd);

        return builder.build();
    }

    private ChooseComponent parseChooseComponent() throws ParseException {
        requireNext(Token.ChooseBegin);

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

        requireNext(Token.ChooseEnd);

        return builder.build();
    }

    private RaceComponent parseRaceComponent() throws ParseException {
        requireNext(Token.RaceBegin);

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

        requireNext(Token.RaceEnd);

        return builder.build();
    }

    private RaceComponentProxy parseRaceComponentProxy() throws ParseException {
        return null; //TODO
    }

    private ClassComponent parseClassComponent() throws ParseException {
        return null; //TODO
    }

    private ClassComponentProxy parseClassComponentProxy() throws ParseException {
        return null; //TODO
    }

    private SubraceComponent parseSubraceComponent() throws ParseException {
        return null; //TODO
    }

    private SubraceComponentProxy parseSubraceComponentProxy() throws ParseException {
        return null; //TODO
    }

    //Generic attribute parsing methods
    private List<Component> parseComponentList(Token start, Token end) throws ParseException {
        requireNext(start);

        List<Component> list = new ArrayList<>();
        Token lookahead = tokenizer.peek();
        while (lookahead != end) {
            list.add(parseComponent());
            lookahead = tokenizer.peek();
        }

        requireNext(end);

        return list;
    }

    private String parseWrappedString(Token start, Token end) throws ParseException {
        requireNext(start);

        requireNext(Token.Text);
        String result = tokenizer.lval();

        requireNext(end);
        return result;
    }

    private int parseWrappedNumber(Token start, Token end) throws ParseException {
        requireNext(start);

        requireNext(Token.Number);
        int result = Integer.parseInt(tokenizer.lval());

        requireNext(end);

        return result;
    }

    //Specializations of generic attribute parsing methods
    private List<Component> parseOptions() throws ParseException {
        return parseComponentList(Token.OptionsBegin, Token.OptionsEnd);
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

    private int parseValue() throws ParseException {
        return parseWrappedNumber(Token.ValueBegin, Token.ValueEnd);
    }

    private int parseQuantity() throws ParseException {
        return parseWrappedNumber(Token.QuantityBegin, Token.QuantityEnd);
    }

    private String parseDescription() throws ParseException {
        return parseWrappedString(Token.DescriptionBegin, Token.DescriptionEnd);
    }

    private String parseName() throws ParseException {
        return parseWrappedString(Token.NameBegin, Token.NameEnd);
    }

    private Skill parseSkill() throws ParseException {
        requireNext(Token.SkillBegin);

        Skill result;
        Token skillToken = tokenizer.next();
        switch (skillToken) {
            case Acrobatics:
                result = Skill.Acrobatics;
                break;
            case AnimalHandling:
                result = Skill.AnimalHandling;
                break;
            case Arcana:
                result = Skill.Arcana;
                break;
            case Athletics:
                result = Skill.Athletics;
                break;
            case Deception:
                result = Skill.Deception;
                break;
            case History:
                result = Skill.History;
                break;
            case Insight:
                result = Skill.Insight;
                break;
            case Intimidation:
                result = Skill.Intimidation;
                break;
            case Investigation:
                result = Skill.Investigation;
                break;
            case Medicine:
                result = Skill.Medicine;
                break;
            case Nature:
                result = Skill.Nature;
                break;
            case Perception:
                result = Skill.Perception;
                break;
            case Performance:
                result = Skill.Performance;
                break;
            case Persuasion:
                result = Skill.Persuasion;
                break;
            case Religion:
                result = Skill.Religion;
                break;
            case SleightOfHand:
                result = Skill.SleightOfHand;
                break;
            case Stealth:
                result = Skill.Stealth;
                break;
            case Survival:
                result = Skill.Survival;
                break;
            default:
                throw new ParseException(unexpectedOfList(
                        Arrays.asList(Token.Acrobatics, Token.AnimalHandling, Token.Arcana,
                                Token.Athletics, Token.Deception, Token.History, Token.Insight,
                                Token.Intimidation, Token.Investigation, Token.Medicine, Token.Nature,
                                Token.Perception, Token.Performance, Token.Persuasion, Token.Religion,
                                Token.SleightOfHand, Token.Stealth, Token.Survival),
                        skillToken));
        }

        requireNext(Token.SkillEnd);
        return result;
    }

    //Helper methods
    private void requireNext(Token required) throws ParseException {
        Token token = tokenizer.next();
        if (token != required) {
            throw new ParseException(unexpectedTokenStringFormat(required, token));
        }
    }

    //Error string methods
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
