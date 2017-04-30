package com.schoolerc.fiftheditioncompanion.rules.visitors;

import com.schoolerc.fiftheditioncompanion.rules.Character;
import com.schoolerc.fiftheditioncompanion.rules.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.rules.Class;
import com.schoolerc.fiftheditioncompanion.rules.Component;
import com.schoolerc.fiftheditioncompanion.rules.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.rules.ProficiencyComponent;
import com.schoolerc.fiftheditioncompanion.rules.Race;
import com.schoolerc.fiftheditioncompanion.rules.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.rules.TraitComponent;
import com.schoolerc.fiftheditioncompanion.rules.VisionComponent;

import java.io.PrintStream;

/**
 * Created by Chaz on 4/25/2017.
 */

public class PrettyPrinter implements ComponentVisitor {

    PrintStream stream;
    int indentLevel = 0;

    public PrettyPrinter(PrintStream stream)
    {
        this.stream = stream;
    }

    private void printTabs()
    {
        for(int i = 0; i < indentLevel; i++)
        {
            stream.print('\t');
        }
    }

    @Override
    public void visitCharacter(Character c) {
        printTabs();
        stream.println("Character");

        indentLevel++;

        printTabs();
        stream.println("Name: " + c.getName());

        for (Component component : c) {
            c.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visitChooseComponent(ChooseComponent chooseComponent)
    {
        printTabs();
        stream.println("ChooseComponent");

        indentLevel++;

        printTabs();
        stream.println("Quantity: " + chooseComponent.getQuantity());

        printTabs();
        stream.println("Options:");

        indentLevel++;
        for (Component component : chooseComponent) {
            component.accept(this);
        }
        indentLevel--;
        indentLevel--;
    }

    @Override
    public void visitClassComponent(Class aClass) {
        printTabs();
        stream.println("Class");

        indentLevel++;

        printTabs();
        stream.println("Name: " + aClass.getName());

        indentLevel--;
    }

    @Override
    public void visitLanguageComponent(LanguageComponent languageComponent) {
        printTabs();
        stream.println("LanguageComponent: " + languageComponent.getLanguage());
    }

    @Override
    public void visitProficiencyComponent(ProficiencyComponent proficiencyComponent) {
        printTabs();
        stream.println("ProficiencyComponent: " + proficiencyComponent.getProficiency().toString());
    }

    @Override
    public void visitRaceComponent(Race race) {
        printTabs();
        stream.println("Race");

        indentLevel++;

        printTabs();
        stream.println("Name: " + race.getName());

        for (Component component : race) {
            component.accept(this);
        }

        indentLevel--;
    }

    @Override
    public void visitSubraceComponent(SubraceComponent subraceComponent) {
        printTabs();
        stream.println("SubraceComponent");

        indentLevel++;
        stream.println("Name: " + subraceComponent.getName());

        for (Component component : subraceComponent) {
            component.accept(this);
        }
        indentLevel--;
    }

    @Override
    public void visitTraitComponent(TraitComponent traitComponent) {
        printTabs();
        stream.println("TraitComponent");

        indentLevel++;

        printTabs();
        stream.println("Name: " + traitComponent.getName());

        printTabs();
        stream.println("Description: " + traitComponent.getDescription());

        for (Component component : traitComponent) {
            component.accept(this);
        }
        indentLevel--;

    }

    @Override
    public void visitVisionComponent(VisionComponent visionComponent) {
        printTabs();
        stream.println("VisionComponent");

        indentLevel++;

        printTabs();
        stream.println("Type: " + visionComponent.getType());

        printTabs();
        stream.println("Range: " + visionComponent.getRange());

        indentLevel--;
    }
}
