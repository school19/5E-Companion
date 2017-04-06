%language "Java"
%name-prefix "Token"
%define public

%parse-param {ParserCallbacks callbacks}

%code imports{
package com.schoolerc.fiftheditioncompanion.entity.data;
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
%token <AbilityScore> ABILITY_SCORE_TOKEN

%type <Component> component
%type <Character> character_component
%type <AbilityScoreComponent> ability_scores
%type <AbilityScoreIncreaseComponent> ability_score_increase
%type <List<Pair<PropertyKey, Object>>> character_property_list ability_scores_property_list ability_score_increase_property_list
%type <List<Component>> component_list
%type <Pair<PropertyKey, Object>> character_property ability_scores_property ability_score_increase_property
%type <Pair<PropertyKey, Object>> name_property
%type <Pair<PropertyKey, Object>> strength_property dexterity_property constitution_property intelligence_property wisdom_property charisma_property
%type <Pair<PropertyKey, Object>> ability_score_property increase_property

%%

root: component {callbacks.doneParsing($1);}

component: character_component {$$ = (Component)$1;}
        | ability_scores {$$ = (Component)$1;}
        | ability_score_increase {$$ = (Component)$1;}

component_list: component_list component { $1.add($2); $$ = $1;}
        | %empty {$$ = new ArrayList<Component>();}

character_component: CHARACTER_BEGIN_TOKEN character_property_list component_list CHARACTER_END_TOKEN
    {
        Character.Builder builder = ParserBuilderAdapter.characterBuilderFromProperties($2);
        Character tmp = builder.build();
        for(Component c : $3)
        {
            tmp.addComponent(c);
        }
        $$ = tmp;
    }

character_property_list: character_property character_property_list { $2.add($1); $$ = $2;}
        | character_property {$$ = new ArrayList<Pair<PropertyKey, Object>>(); ((ArrayList<Pair<PropertyKey, Object>>)$$).add($1);}

character_property: name_property

ability_scores: ABILITY_SCORES_BEGIN_TOKEN ability_scores_property_list ABILITY_SCORES_END_TOKEN
    {
        AbilityScoreComponent.Builder builder = ParserBuilderAdapter.abilityScoreBuilderFromProperties($2);
        $$ = builder.build();
    }

ability_scores_property_list: ability_scores_property_list ability_scores_property { $1.add($2); $$ = $1; }
        | ability_scores_property { $$ = new ArrayList<Pair<PropertyKey, Object>>(); ((ArrayList<Pair<PropertyKey, Object>>)$$).add($1);}

ability_scores_property: strength_property
        | dexterity_property
        | constitution_property
        | intelligence_property
        | wisdom_property
        | charisma_property

ability_score_increase: ABILITY_SCORE_INCREASE_BEGIN_TOKEN ability_score_increase_property_list ABILITY_SCORE_INCREASE_END_TOKEN
        {
            AbilityScoreIncreaseComponent.Builder builder = ParserBuilderAdapter.abilityScoreIncreaseBuilderFromProperties($2);
            $$ = builder.build();
        }

ability_score_increase_property_list: ability_score_increase_property_list ability_score_increase_property { $1.add($2); $$ = $1;}
        | ability_score_increase_property { List<Pair<PropertyKey, Object>> tmp = new ArrayList<>(); tmp.add($1); $$ = tmp;}

ability_score_increase_property: ability_score_property
        | increase_property

name_property: NAME_TOKEN { $$ = new Pair<>(PropertyKey.Name, $1);}

strength_property: STRENGTH_TOKEN { $$ = new Pair<>(PropertyKey.Strength, $1); }
dexterity_property: DEXTERITY_TOKEN { $$ = new Pair<>(PropertyKey.Dexterity, $1); }
constitution_property: CONSTITUTION_TOKEN { $$ = new Pair<>(PropertyKey.Constitution, $1); }
intelligence_property: INTELLIGENCE_TOKEN { $$ = new Pair<>(PropertyKey.Intelligence, $1); }
wisdom_property: WISDOM_TOKEN { $$ = new Pair<>(PropertyKey.Wisdom, $1); }
charisma_property: CHARISMA_TOKEN { $$ = new Pair<>(PropertyKey.Charisma, $1); }

ability_score_property: ABILITY_SCORE_TOKEN { $$ = new Pair<>(PropertyKey.AbilityScore, $1);}
increase_property: INCREASE_TOKEN { $$ = new Pair<>(PropertyKey.Increase, $1);}