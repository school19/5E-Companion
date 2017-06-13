//
// Created by Chaz on 6/12/2017.
//

#ifndef INC_5E_COMPANION_CHARACTER_H
#define INC_5E_COMPANION_CHARACTER_H

#include <string>
#include <unordered_map>
#include <lua.hpp>


class Character {
public:
    Character() = delete;
    Character(lua_State* lua_state);
    ~Character();

    int getBaseProperty(std::string key);
    int getProperty(std::string key);

private:
    std::unordered_map<std::string, int> baseProperties;
    std::unordered_multimap<std::string, int> modifierTables;

    lua_State* lua;
};


#endif //INC_5E_COMPANION_CHARACTER_H
