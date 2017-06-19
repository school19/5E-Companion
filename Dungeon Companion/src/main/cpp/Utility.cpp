//
// Created by Chaz Schooler on 6/18/17.
//

#include "Utility.h"
#include "Error.h"

int loadFileTable(lua_State *L, std::string &filepath) {
    luaL_loadfile(L, filepath.c_str());
    lua_pcall(L, 0, 1, 0);

    auto type = lua_type(L, -1);
    if (type != LUA_TTABLE) {
        BOOST_THROW_EXCEPTION(runtime_exception()
                                      << errinfo_index(-1)
                                      << boost::errinfo_file_name(filepath.c_str())
                                      << errinfo_expected_type(typeInfo(LUA_TTABLE))
                                      << errinfo_found_type(typeInfo(type)));
    }

    return luaL_ref(L, LUA_REGISTRYINDEX);
}

void loadRegTable(lua_State *L, int reg_index) {
    auto type = lua_rawgeti(L, LUA_REGISTRYINDEX, reg_index);
    if (type != LUA_TTABLE) {
        BOOST_THROW_EXCEPTION(runtime_exception()
                                      << errinfo_index(reg_index)
                                      << errinfo_expected_type(typeInfo(LUA_TTABLE))
                                      << errinfo_found_type(typeInfo(type)));
    }
}

long long getIntField(lua_State *L, int index, const char *name) {
    auto type = lua_getfield(L, index, name);
    if (type != LUA_TNUMBER) {
        lua_pop(L, 1);
        BOOST_THROW_EXCEPTION(runtime_exception()
                                      << errinfo_index(index)
                                      << errinfo_field(name)
                                      << errinfo_expected_type(typeInfo(LUA_TNUMBER))
                                      << errinfo_found_type(typeInfo(type)));
    }

    auto result = lua_tointeger(L, -1);
    lua_pop(L, 1);
    return result;
}

std::string getStringField(lua_State *L, int index, const char *name) {
    auto type = lua_getfield(L, index, name);
    if (type != LUA_TSTRING) {
        lua_pop(L, 1);
        BOOST_THROW_EXCEPTION(runtime_exception()
                                      << errinfo_index(index)
                                      << errinfo_field(name)
                                      << errinfo_expected_type(typeInfo(LUA_TSTRING))
                                      << errinfo_found_type(typeInfo(type)));
    }

    std::string result(lua_tostring(L, -1)); //Copy to string object to ensure that the value doesn't go away when lua_pop is called
    lua_pop(L, 1);
    return result;
}