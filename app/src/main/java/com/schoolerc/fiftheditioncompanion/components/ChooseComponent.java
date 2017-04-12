package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import java.util.List;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class ChooseComponent extends Component {

    private int quantity;
    private List<Component> components;

    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitChooseComponent(this);
    }
}
