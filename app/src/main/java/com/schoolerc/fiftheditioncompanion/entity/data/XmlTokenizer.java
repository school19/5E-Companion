package com.schoolerc.fiftheditioncompanion.entity.data;

import android.media.session.MediaSession;

import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Chaz Schooler on 3/31/2017.
 */

public class XmlTokenizer extends DefaultHandler implements TokenParser.Lexer {
    public void yyerror(String error)
    {

    }

    public Object getLVal()
    {
        return null;
    }

    public int yylex()
    {
        return TokenParser.YYERROR;
    }
}
