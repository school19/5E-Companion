//
// Created by Chaz Schooler on 6/18/17.
//

#ifndef DUNGEONCOMPANION_ERROR_H
#define DUNGEONCOMPANION_ERROR_H

#include <boost/exception/exception.hpp>
#include <boost/throw_exception.hpp>
#include <boost/exception/error_info.hpp>
#include <boost/exception/errinfo_api_function.hpp>
#include <boost/exception/errinfo_errno.hpp>
#include <boost/exception/errinfo_file_name.hpp>
#include <stdexcept>
#include <lua.h>

struct runtime_exception: virtual std::exception, virtual boost::exception{};

typedef boost::error_info<struct tag_index, int> errinfo_index;
typedef boost::error_info<struct tag_field, const char*> errinfo_field;
typedef boost::error_info<struct tag_expected_type, const char*> errinfo_expected_type;
typedef boost::error_info<struct tag_found_type, const char*> errinfo_found_type;
typedef boost::error_info<struct tag_table_rep, const char*> errinfo_table_rep;

const char* typeInfo(int type);


#endif //DUNGEONCOMPANION_ERROR_H
