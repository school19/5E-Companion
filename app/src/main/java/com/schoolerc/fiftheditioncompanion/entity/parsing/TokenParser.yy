%language "Java"
%name-prefix "Token"
%define public

%parse-param {ParserCallbacks callbacks}

%code imports{
package com.schoolerc.fiftheditioncompanion.entity.parsing;
import com.schoolerc.fiftheditioncompanion.entity.Character;
import com.schoolerc.fiftheditioncompanion.entity.*;
import com.schoolerc.fiftheditioncompanion.util.Pair;
import java.util.List;
import java.util.ArrayList;
}

//Components
%token CHARACTER_BEGIN_TOKEN CHARACTER_END_TOKEN
%token ABILITY_SCORES_BEGIN_TOKEN ABILITY_SCORES_END_TOKEN
%token ABILITY_SCORE_INCREASE_BEGIN_TOKEN ABILITY_SCORE_INCREASE_END_TOKEN

//Attributes
%token STRENGTH_BEGIN_TOKEN DEXTERITY_BEGIN_TOKEN CONSTITUTION_BEGIN_TOKEN INTELLIGENCE_BEGIN_TOKEN WISDOM_BEGIN_TOKEN CHARISMA_BEGIN_TOKEN MODIFIER_BEGIN_TOKEN
%token STRENGTH_END_TOKEN DEXTERITY_END_TOKEN CONSTITUTION_END_TOKEN INTELLIGENCE_END_TOKEN WISDOM_END_TOKEN CHARISMA_END_TOKEN MODIFIER_END_TOKEN
%token NAME_BEGIN_TOKEN NAME_END_TOKEN
%token ABILITY_SCORE_TARGET_BEGIN_TOKEN ABILITY_SCORE_TARGET_END_TOKEN

%type <Component> component
%type <Character> character_component
%type <AbilityScoreComponent> ability_scores
%type <AbilityScoreIncreaseComponent> ability_score_increase
%type <Pair<PropertyKey, Object>> name_property
%type <Pair<PropertyKey, Object>> strength_property dexterity_property constitution_property intelligence_property wisdom_property charisma_property
%type <Pair<PropertyKey, Object>> ability_score_target_property modifier_property//
%type <Pair<PropertyKey, Object>> child
%type <List<Pair<PropertyKey, Object>>> children

%token <Integer> NUMBER
%token <String> CONTENT
%token <AbilityScore> ABILITY_SCORE

%%

root: component {callbacks.doneParsing($1);}

component: character_component {$$ = (Component)$1;}
        | ability_scores {$$ = (Component)$1;}
        | ability_score_increase {$$ = (Component)$1;}

character_component: CHARACTER_BEGIN_TOKEN children CHARACTER_END_TOKEN
    {
        Character.Builder builder = ParserBuilderAdapter.characterBuilderFromProperties($2);
        $$ = builder.build();
    }

ability_scores: ABILITY_SCORES_BEGIN_TOKEN children ABILITY_SCORES_END_TOKEN
    {
        AbilityScoreComponent.Builder builder = ParserBuilderAdapter.abilityScoreBuilderFromProperties($2);
        $$ = builder.build();
    }

ability_score_increase: ABILITY_SCORE_INCREASE_BEGIN_TOKEN children ABILITY_SCORE_INCREASE_END_TOKEN
        {
            AbilityScoreIncreaseComponent.Builder builder = ParserBuilderAdapter.abilityScoreIncreaseBuilderFromProperties($2);
            $$ = builder.build();
        }

children: children child { $1.add($2); $$ = $1;}
        | %empty { $$ = new ArrayList<Pair<PropertyKey, Object>>(); }

child: component { $$ = new Pair<PropertyKey, Object>(PropertyKey.Child, $1);}
        | name_property
        | strength_property
        | dexterity_property
        | constitution_property
        | intelligence_property
        | wisdom_property
        | charisma_property
        | ability_score_target_property
        | modifier_property

name_property: NAME_BEGIN_TOKEN CONTENT NAME_END_TOKEN { $$ = new Pair<>(PropertyKey.Name, $2);}

strength_property: STRENGTH_BEGIN_TOKEN NUMBER STRENGTH_END_TOKEN { $$ = new Pair<>(PropertyKey.Strength, $2); }
dexterity_property: DEXTERITY_BEGIN_TOKEN NUMBER DEXTERITY_END_TOKEN { $$ = new Pair<>(PropertyKey.Dexterity, $2); }
constitution_property: CONSTITUTION_BEGIN_TOKEN NUMBER CONSTITUTION_END_TOKEN { $$ = new Pair<>(PropertyKey.Constitution, $2); }
intelligence_property: INTELLIGENCE_BEGIN_TOKEN NUMBER INTELLIGENCE_END_TOKEN { $$ = new Pair<>(PropertyKey.Intelligence, $2); }
wisdom_property: WISDOM_BEGIN_TOKEN NUMBER WISDOM_END_TOKEN { $$ = new Pair<>(PropertyKey.Wisdom, $2); }
charisma_property: CHARISMA_BEGIN_TOKEN NUMBER CHARISMA_END_TOKEN { $$ = new Pair<>(PropertyKey.Charisma, $2); }

ability_score_target_property: ABILITY_SCORE_TARGET_BEGIN_TOKEN ABILITY_SCORE ABILITY_SCORE_TARGET_END_TOKEN { $$ = new Pair<>(PropertyKey.AbilityScore, $2);}
modifier_property: MODIFIER_BEGIN_TOKEN NUMBER MODIFIER_END_TOKEN { $$ = new Pair<>(PropertyKey.Increase, $2);}