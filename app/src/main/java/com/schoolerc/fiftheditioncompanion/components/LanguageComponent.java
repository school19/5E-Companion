package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

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
