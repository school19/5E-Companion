//
// Created by Chaz Schooler on 6/18/17.
//

#include "Error.h"

const char* typeInfo(int type)
{
    switch(type){
        default:
        case LUA_TNIL:
            return "nil";
        case LUA_TBOOLEAN:
            return "boolean";
        case LUA_TLIGHTUSERDATA:
            return "light user data";
        case LUA_TNUMBER:
            return "number";
        case LUA_TSTRING:
            return "string";
        case LUA_TTABLE:
            return "table";
        case LUA_TFUNCTION:
            return "function";
        case LUA_TUSERDATA:
            return "user data";
        case LUA_TTHREAD:
            return "thread";
    }
}