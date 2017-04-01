%language "Java"
%name-prefix ""
%define parser_class_name "TokenParser"
%define public
%define api.push-pull push

%code imports{
package com.schoolerc.fiftheditioncompanion.entity.data;
import com.schoolerc.fiftheditioncompanion.entity.*;
}

//Primary Components
%token CHARACTER_TOKEN
%token ABILITY_SCORE_TOKEN
%token ABILITY_SCORE_IMPROVEMENT_TOKEN
%token ADVANTAGE_TOKEN
%token CHOOSE_TOKEN
%token CLASS_TOKEN
%token CONDITION_TOKEN
%token DAMAGE_TOKEN
%token DISADVANTAGE_TOKEN
%token IMMUNITY_TOKEN
%token LANGUAGE_TOKEN
%token RACE_TOKEN
%token RESISTANCE_TOKEN
%token SKILL_TOKEN
%token SPEED_TOKEN
%token SUBRACE_TOKEN
%token TRAIT_TOKEN
%token VISION_TOKEN


//Attribute Components
%token ATTR_NAME

//Typed tokens
%type <Component> component
%type <com.schoolerc.fiftheditioncompanion.entity.Character> character
%type <AbilityScoreComponent> ability_score_component
%type <AbilityScoreImprovementComponent> ability_score_improvement_component
%type <AdvantageComponent> advantage_component
%type <ChooseComponent> choose_component
%type <ClassComponent> class_component
%type <ConditionComponent> condition_component
%type <DamageComponent> damage_component
%type <DisadvantageComponent> disadvantage_component
%type <ImmunityComponent> immunity_component
%type <LanguageComponent> language_component
%type <RaceComponent> race_component
%type <ResistanceComponent> resistance_component
%type <SkillComponent> skill_component
%type <SpeedComponent> speed_component
%type <SubraceComponent> subrace_component
%type <TraitComponent> trait_component
%type <VisionComponent> vision_component

%type <List<Component>> component_list

%%

start:  component

component: character { $$ = (Component) $1; } |
        ability_score_component { $$ = (Component) $1; } |
        ability_score_improvement_component { $$ = (Component) $1; } |
        advantage_component { $$ = (Component) $1; } |
        choose_component { $$ = (Component) $1; } |
        class_component { $$ = (Component) $1; } |
        condition_component { $$ = (Component) $1; } |
        damage_component { $$ = (Component) $1; } |
        disadvantage_component { $$ = (Component) $1; } |
        immunity_component { $$ = (Component) $1; } |
        language_component { $$ = (Component) $1; } |
        race_component{ $$ = (Component) $1; } |
        resistance_component { $$ = (Component) $1; } |
        skill_component { $$ = (Component) $1; } |
        speed_component { $$ = (Component) $1; } |
        subrace_component { $$ = (Component) $1; } |
        trait_component { $$ = (Component) $1; } |
        vision_component { $$ = (Component) $1; }

component_list: component component_list
                {
                    List<Component> lst = $2;
                    $2.append($1);
                    $$ = $2;
                }   |
        component { List<Component> lst = (List<Component>) $$;
                    lst.append($1);
                  }

character: component_list {}

ability_score_component: ABILITY_SCORE_TOKEN {}
ability_score_improvement_component: ABILITY_SCORE_IMPROVEMENT_TOKEN {}
advantage_component: ADVANTAGE_TOKEN {}
choose_component: CHOOSE_TOKEN {}
class_component: CLASS_TOKEN {}
condition_component: CONDITION_TOKEN {}
damage_component: DAMAGE_TOKEN {}
disadvantage_component: DISADVANTAGE_TOKEN {}
immunity_component: IMMUNITY_TOKEN {}
language_component: LANGUAGE_TOKEN {}
race_component: RACE_TOKEN {}
resistance_component: RESISTANCE_TOKEN {}
skill_component: SKILL_TOKEN {}
speed_component: SPEED_TOKEN {}
subrace_component: SUBRACE_TOKEN {}
trait_component: TRAIT_TOKEN {}
vision_component: VISION_TOKEN {}
