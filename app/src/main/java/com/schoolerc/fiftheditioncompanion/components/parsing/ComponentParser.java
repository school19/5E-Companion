package com.schoolerc.fiftheditioncompanion.components.parsing;

import com.schoolerc.fiftheditioncompanion.components.Component;

import java.io.InputStream;


public interface ComponentParser {
    Component parse(InputStream inputStream);
}
