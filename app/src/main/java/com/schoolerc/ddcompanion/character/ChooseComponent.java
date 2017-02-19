package com.schoolerc.ddcompanion.character;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz Schooler on 2/11/2017.
 */

public class ChooseComponent extends Component {
    private static final String KEY_QUANTITY = "quantity";

    private int quantity;
    private List<Component> components;

    @Override
    public void load(Element element) {
        try {
            quantity = Integer.parseInt(element.getAttribute(KEY_QUANTITY));
        } catch (NumberFormatException ex) {
            throw new RuntimeException("Malformed choose component");
        }

        ComponentFactory factory = new ComponentFactory();
        components = new ArrayList<>(element.getChildNodes().getLength());
        for (int i = 0; i < element.getChildNodes().getLength(); i++)
        {
            if(element.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE)
            {
                components.add(factory.componentFromElement((Element)element.getChildNodes().item(i)));
            }
        }
    }
}
