package com.schoolerc.fiftheditioncompanion.rules;

import com.schoolerc.fiftheditioncompanion.rules.visitors.ComponentVisitor;

import org.simpleframework.xml.Element;

import java.util.List;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class ChooseComponent extends Component {

    @Element
    private int quantity;


    @Override
    public void accept(ComponentVisitor visitor) {
        visitor.visitChooseComponent(this);
    }

    public ChooseComponent() {
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
