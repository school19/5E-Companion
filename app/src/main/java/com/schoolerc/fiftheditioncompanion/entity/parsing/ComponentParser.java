package com.schoolerc.fiftheditioncompanion.entity.parsing;

import com.schoolerc.fiftheditioncompanion.entity.Component;

import java.io.InputStream;


public interface ComponentParser {
    Component parse(InputStream inputStream);
}
