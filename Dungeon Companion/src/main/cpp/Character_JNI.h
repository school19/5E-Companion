//
// Created by Chaz on 6/13/2017.
//

#ifndef INC_5E_COMPANION_CHARACTER_JNI_H_H
#define INC_5E_COMPANION_CHARACTER_JNI_H_H
#include <jni.h>
#include "Character.h"

Character* getCharacter(_JNIEnv* env, jobject thiz);
#endif //INC_5E_COMPANION_CHARACTER_JNI_H_H
