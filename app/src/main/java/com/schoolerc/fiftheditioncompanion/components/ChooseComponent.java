package com.schoolerc.fiftheditioncompanion.components;

import com.schoolerc.fiftheditioncompanion.components.operators.ComponentVisitor;

import org.simpleframework.xml.Element;
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
