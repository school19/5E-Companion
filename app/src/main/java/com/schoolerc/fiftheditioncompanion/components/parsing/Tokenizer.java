package com.schoolerc.fiftheditioncompanion.components.parsing;

/**
 * Created by Chaz Schooler on 4/12/2017.
 */

public interface Tokenizer {
    String lval();
    Token peek();
    Token next();
}