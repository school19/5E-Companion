# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)
include(ExternalProject)

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add.library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

add_library( # Specifies the name of the library.
             native_lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/lua_JNI
             src/main/cpp/lauxlib_JNI
             src/main/cpp/Error)

add_library(lua_lib
            SHARED

            src/main/cpp/lua/src/lapi.c
            src/main/cpp/lua/src/lauxlib.c
            src/main/cpp/lua/src/lbaselib.c
            src/main/cpp/lua/src/lbitlib.c
            src/main/cpp/lua/src/lcode.c
            src/main/cpp/lua/src/lcorolib.c
            src/main/cpp/lua/src/lctype.c
            src/main/cpp/lua/src/ldblib.c
            src/main/cpp/lua/src/ldebug.c
            src/main/cpp/lua/src/ldo.c
            src/main/cpp/lua/src/ldump.c
            src/main/cpp/lua/src/lfunc.c
            src/main/cpp/lua/src/lgc.c
            src/main/cpp/lua/src/linit.c
            src/main/cpp/lua/src/liolib.c
            src/main/cpp/lua/src/llex.c
            src/main/cpp/lua/src/lmathlib.c
            src/main/cpp/lua/src/lmem.c
            src/main/cpp/lua/src/loadlib.c
            src/main/cpp/lua/src/lobject.c
            src/main/cpp/lua/src/lopcodes.c
            src/main/cpp/lua/src/loslib.c
            src/main/cpp/lua/src/lparser.c
            src/main/cpp/lua/src/lstate.c
            src/main/cpp/lua/src/lstring.c
            src/main/cpp/lua/src/lstrlib.c
            src/main/cpp/lua/src/ltable.c
            src/main/cpp/lua/src/ltablib.c
            src/main/cpp/lua/src/ltm.c
            src/main/cpp/lua/src/lundump.c
            src/main/cpp/lua/src/lutf8lib.c
            src/main/cpp/lua/src/lvm.c
            src/main/cpp/lua/src/lzio.c)

add_library(boost
            SHARED
            src/main/cpp/boost_1_64_0/libs/exception/src/clone_current_exception_non_intrusive.cpp
            src/main/cpp/boost_1_64_0/libs/system/src/error_code.cpp)

include_directories(boost src/main/cpp/boost_1_64_0)

target_link_libraries(native_lib
                      lua_lib
                      boost)

include_directories(native-lib src/main/cpp/lua/src src/main/cpp/boost_1_64_0)