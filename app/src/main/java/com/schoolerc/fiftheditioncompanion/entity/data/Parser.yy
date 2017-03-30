%language "Java"
%name-prefix ""
%define public
%define api.push-pull push

%code imports{
package com.schoolerc.fiftheditioncompanion.entity.data;
import com.schoolerc.fiftheditioncompanion.entity.*;
}

//Primary Components
%token CHARACTER_BEGIN CHARACTER_END
%token ABILITY_SCORE_BEGIN ABILITY_SCORE_END
%token ABILITY_SCORE_INCREASE_BEGIN ABILITY_SCORE_INCREASE_END
%token ADVANTAGE_BEGIN ADVANTAGE_END
%token CHOOSE_BEGIN CHOOSE_END
%token CLASS_BEGIN CLASS_END
%token CONDITION_BEGIN CONDITION_END
%token DAMAGE_BEGIN DAMAGE_END
%token DISADVANTAGE_BEGIN DISADVANTAGE_END
%token IMMUNITY_BEGIN IMMUNITY_END
%token LANGUAGE_BEGIN LANGUAGE_END
%token RACE_BEGIN RACE_END
%token RESISTANCE_BEGIN RESISTANCE_END
%token SKILL_BEGIN SKILL_END
%token SPEED_BEGIN SPEED_END
%token SUBRACE_BEGIN SUBRACE_END
%token TRAIT_BEGIN TRAIT_END
%token VISION_BEGIN VISION_END


//Attribute Components
%token NAME_BEGIN NAME_END

//Typed tokens
%type <Character.Builder> CHARACTER_ATTRIBUTES
%token <Integer> NUMBER

%%

input: NUMBER {System.out.println($1);}

