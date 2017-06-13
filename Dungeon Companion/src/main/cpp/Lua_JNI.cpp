//
// Created by Chaz on 6/13/2017.
//

#include "Lua_JNI.h"

long Java_com_schoolerc_dungeoncompanion_Lua_createHandle(_JNIEnv* env, jobject thiz)
{
    lua_State* state = luaL_newstate();
    luaL_openlibs(state);
    return static_cast<long>(state);
}

void Java_com_schoolerc_dungeoncompanion_Lua_destroyHandle(_JNIEnv* env, jobject thiz)
{
    lua_close(getLuaState(env, thiz));
}

lua_State* getLuaState(_JNIEnv* env, jobject thiz)
{
    jfieldID fieldID = env->GetFieldID(env->GetObjectClass(thiz), "handle", "J");
    long handle = env->GetLongField(thiz, fieldID);

    return static_cast<lua_State*>(handle);
}