# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add.library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

add_library( # Specifies the name of the library.
             native-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/Character
             src/main/cpp/Character_JNI
             src/main/cpp/Character_Lua)

add_library(lua-lib

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

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )


target_link_libraries( # Specifies the target library.
                       native-lib

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib}
                       ${lua-lib})

include_directories(native-lib src/main/cpp/lua/src)