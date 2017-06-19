//
// Created by Chaz Schooler on 6/18/17.
//

#include <string>
#include <boost/exception/exception.hpp>
#include "Race.h"
#include "Utility.h"
#include "Error.h"

const char* RACE_FIELD_SPEED = "speed";
const char* RACE_FIELD_NAME = "name";

const char* RACE_TABLE_REP = "race";

long long raceGetSpeed(lua_State *L, int race)
{
    long long result;
    try {
        loadRegTable(L, race); // top of stack is now the race table
        result = getIntField(L, -1, RACE_FIELD_SPEED);
    }
    catch(boost::exception& ex)
    {
        lua_pop(L, 1); //pop table (or non table value) loaded from loadRegTable
        ex << errinfo_table_rep(RACE_TABLE_REP);
        throw;
    }
    lua_pop(L, 1); //pop table loaded from loadRegTable
    return result;
}

std::string raceGetName(lua_State*L, int race)
{
    std::string result;
    try{
        loadRegTable(L, race);
        result = getStringField(L, -1, RACE_FIELD_NAME);
    }
    catch(boost::exception& ex)
    {
        lua_pop(L, 1);
        ex << errinfo_table_rep(RACE_TABLE_REP);
        throw;
    }
    lua_pop(L, 1);
    return result;
}