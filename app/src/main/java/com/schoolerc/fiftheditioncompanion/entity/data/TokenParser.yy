%language "Java"
%name-prefix "Token"
%define public
%define api.push-pull push

%parse-param {ParserCallbacks callbacks}

%code imports{
package com.schoolerc.fiftheditioncompanion.entity.data;
import com.schoolerc.fiftheditioncompanion.entity.*;
import android.util.Pair;
import java.util.List;
import java.util.ArrayList;
}

//Primary Components
%token CHARACTER_BEGIN_TOKEN CHARACTER_END_TOKEN
%token NAME_BEGIN_TOKEN NAME_END_TOKEN
%token <String> STRING
%type <Component> component
%type <Character> character_component
%type <ArrayList<Pair<String, Object>>> character_property_list
%type <Pair<String, Object>> character_property
%type <Pair<String, Object>> name_property
%%

root: component {callbacks.doneParsing($1);}
component: character_component

character_component: CHARACTER_BEGIN_TOKEN character_property_list CHARACTER_END_TOKEN {$$ = new com.schoolerc.fiftheditioncompanion.entity.Character();}

character_property_list: character_property character_property_list { $2.add($1); $$ = $2;} |
        character_property {ArrayList<Pair<String,Object>> tmp = new ArrayList<Pair<String, Object>>(); tmp.add($1); $$ = tmp;}

character_property: name_property

name_property: NAME_BEGIN_TOKEN STRING NAME_END_TOKEN { $$ = new Pair<String, Object>("name", $2);}