//
// Created by Chaz on 6/12/2017.
//

#include "Character.h"

#include <algorithm>

Character::Character(lua_State* lua_state) {
    lua = lua_state;
}

Character::~Character() {

}

int Character::getBaseProperty(std::string key) {
    auto position = baseProperties.find(key);
    if(position != baseProperties.end())
    {
        return position->second;
    } else{
        throw std::runtime_error("Unknown property error");
    }
}

int Character::getProperty(std::string key)
{
    int base  = getBaseProperty(key);

    auto range = modifierTables.equal_range(key);
    std::for_each(range.first, range.second, [&base](int table)
    {

    });
}