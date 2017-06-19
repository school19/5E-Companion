//
// Created by Chaz Schooler on 6/18/17.
//

#ifndef DUNGEONCOMPANION_RACE_H
#define DUNGEONCOMPANION_RACE_H
#include <lua.hpp>

long long raceGetSpeed(lua_State *L, int race);

std::string raceGetName(lua_State* L, int race);


#endif //DUNGEONCOMPANION_RACE_H
