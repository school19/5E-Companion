//
// Created by Chaz on 6/13/2017.
//

#ifndef INC_5E_COMPANION_LUA_JNI_H
#define INC_5E_COMPANION_LUA_JNI_H

#include <lua.hpp>
#include <jni.h>
lua_State* getLuaState(_JNIEnv* env, jobject thiz);
#endif //INC_5E_COMPANION_LUA_JNI_H
