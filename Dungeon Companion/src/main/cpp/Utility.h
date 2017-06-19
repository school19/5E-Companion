//
// Created by Chaz Schooler on 6/18/17.
//

#ifndef DUNGEONCOMPANION_DUNGEONCOMPANION_H
#define DUNGEONCOMPANION_DUNGEONCOMPANION_H

#include <string>
#include <lua.hpp>

int loadFileTable(lua_State* L, std::string& filepath);
void loadRegTable(lua_State* L, int reg_index);

long long getIntField(lua_State* L, int index, const char* field_name);
std::string getStringField(lua_State* L, int index, const char* field_name);

#endif //DUNGEONCOMPANION_DUNGEONCOMPANION_H
