package com.schoolerc.fiftheditioncompanion.rules;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz Schooler on 2/15/2017.
 */

public class LanguageComponent extends Component {

    @Element
    private String language;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitLanguageComponent(this);
    }

    public LanguageComponent()
    {}

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String lang)
    {
        language = lang;
    }
}
