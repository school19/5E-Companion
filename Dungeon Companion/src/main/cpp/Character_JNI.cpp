//
// Created by Chaz on 6/12/2017.
//

#include "Character_JNI.h"
#include "Lua_JNI.h"

long Java_com_schoolerc_dungeoncompanion_Character_createHandle(_JNIEnv* env, jobject thiz, jobject lua)
{
    lua_State* ptr = getLuaState(env, lua);
    return static_cast<long>(new Character(ptr));
}

void Java_com_schoolerc_dungeoncompanion_Character_destroyHandle()
{

}