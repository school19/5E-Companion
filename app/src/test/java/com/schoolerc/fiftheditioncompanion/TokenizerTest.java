package com.schoolerc.fiftheditioncompanion;

import org.junit.Test;

import java.io.IOException;
import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Created by Chaz on 4/27/2017.
 */

public class TokenizerTest {

    @Test
    public void specialCharsTest() throws IOException {
        String testString = "if(param==2){doSomething(paramA, paramB);}";
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader(testString));

        int token = tokenizer.nextToken();
        while(token != StreamTokenizer.TT_EOF)
        {
            switch (token)
            {
                case StreamTokenizer.TT_NUMBER:
                    System.out.println(tokenizer.nval);
                    break;
                case StreamTokenizer.TT_WORD:
                    System.out.println(tokenizer.sval);
                    break;
                default:
                    System.out.println((char)token);
                    break;
            }
            token = tokenizer.nextToken();
        }
    }
}
