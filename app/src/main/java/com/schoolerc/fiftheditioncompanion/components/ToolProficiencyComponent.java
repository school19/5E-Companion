package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.rules.Tool;

import org.simpleframework.xml.Element;

/**
 * Created by Chaz on 4/25/2017.
 */

public class ToolProficiencyComponent extends Component {
    @Element
    private Tool tool;

    public ToolProficiencyComponent(){}

    public Tool getTool()
    {
        return tool;
    }

    public void setTool(Tool tool)
    {
        this.tool = tool;
    }
}
