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

//Primary Components
%token CHARACTER_BEGIN_TOKEN CHARACTER_END_TOKEN
%token ABILITY_SCORES_BEGIN_TOKEN ABILITY_SCORES_END_TOKEN
%token ABILITY_SCORE_INCREASE_BEGIN_TOKEN ABILITY_SCORE_INCREASE_END_TOKEN

//Attributes
%token <Integer> STRENGTH_TOKEN DEXTERITY_TOKEN CONSTITUTION_TOKEN INTELLIGENCE_TOKEN WISDOM_TOKEN CHARISMA_TOKEN INCREASE_TOKEN
%token <String> NAME_TOKEN
%token <AbilityScore> ABILITY_SCORE_TARGET_TOKEN

%type <Component> component
%type <Character> character_component
%type <AbilityScoreComponent> ability_scores
%type <AbilityScoreIncreaseComponent> ability_score_increase
%type <Pair<PropertyKey, Object>> name_property
%type <Pair<PropertyKey, Object>> strength_property dexterity_property constitution_property intelligence_property wisdom_property charisma_property
%type <Pair<PropertyKey, Object>> ability_score_target_property increase_property
%type <Pair<PropertyKey, Object>> child
%type <List<Pair<PropertyKey, Object>>> children

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
        | increase_property

name_property: NAME_TOKEN { $$ = new Pair<>(PropertyKey.Name, $1);}

strength_property: STRENGTH_TOKEN { $$ = new Pair<>(PropertyKey.Strength, $1); }
dexterity_property: DEXTERITY_TOKEN { $$ = new Pair<>(PropertyKey.Dexterity, $1); }
constitution_property: CONSTITUTION_TOKEN { $$ = new Pair<>(PropertyKey.Constitution, $1); }
intelligence_property: INTELLIGENCE_TOKEN { $$ = new Pair<>(PropertyKey.Intelligence, $1); }
wisdom_property: WISDOM_TOKEN { $$ = new Pair<>(PropertyKey.Wisdom, $1); }
charisma_property: CHARISMA_TOKEN { $$ = new Pair<>(PropertyKey.Charisma, $1); }

ability_score_target_property: ABILITY_SCORE_TARGET_TOKEN { $$ = new Pair<>(PropertyKey.AbilityScore, $1);}
increase_property: INCREASE_TOKEN { $$ = new Pair<>(PropertyKey.Increase, $1);}