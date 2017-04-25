package com.schoolerc.fiftheditioncompanion.components.operators;

import com.schoolerc.fiftheditioncompanion.components.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.components.AbilityScoreIncreaseComponent;
import com.schoolerc.fiftheditioncompanion.components.AbilityScoreModifierComponent;
import com.schoolerc.fiftheditioncompanion.components.Character;
import com.schoolerc.fiftheditioncompanion.components.ChooseComponent;
import com.schoolerc.fiftheditioncompanion.components.ClassComponent;
import com.schoolerc.fiftheditioncompanion.components.Component;
import com.schoolerc.fiftheditioncompanion.components.LanguageComponent;
import com.schoolerc.fiftheditioncompanion.components.RaceComponent;
import com.schoolerc.fiftheditioncompanion.components.ResistanceComponent;
import com.schoolerc.fiftheditioncompanion.components.SpeedComponent;
import com.schoolerc.fiftheditioncompanion.components.SpellcastingComponent;
import com.schoolerc.fiftheditioncompanion.components.SubraceComponent;
import com.schoolerc.fiftheditioncompanion.components.TraitComponent;
import com.schoolerc.fiftheditioncompanion.components.VisionComponent;

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
    public void visitAbilityScoreComponent(AbilityScoreComponent abilityScoreComponent) {
        printTabs();
        stream.println("AbilityScoreComponent");

        indentLevel++;

        printTabs();
        stream.println("Strength: " + abilityScoreComponent.getStrengthScore());

        printTabs();
        stream.println("Dexterity: " + abilityScoreComponent.getDexterityScore());

        printTabs();
        stream.println("Constitution: " + abilityScoreComponent.getConstitutionScore());

        printTabs();
        stream.println("Intelligence: " + abilityScoreComponent.getIntelligenceScore());

        printTabs();
        stream.println("Wisdom: " + abilityScoreComponent.getWisdomScore());

        printTabs();
        stream.println("Strength: " + abilityScoreComponent.getCharismaScore());

        indentLevel--;
    }

    @Override
    public void visitAbilityScoreIncreaseComponent(AbilityScoreIncreaseComponent abilityScoreIncreaseComponent) {
        printTabs();
        stream.println("AbilityScoreIncreaseComponent");

        indentLevel++;

        printTabs();
        stream.println("AbilityScore: " + abilityScoreIncreaseComponent.getAbilityScore());

        printTabs();
        stream.println("Modifier: " + abilityScoreIncreaseComponent.getModifier());

        indentLevel--;
    }

    @Override
    public void visitAbilitiyScoreModifierComponent(AbilityScoreModifierComponent abilityScoreModifierComponent) {
        printTabs();
        stream.println("AbilityScoreModifierComponent");

        indentLevel++;

        printTabs();
        stream.println("AbilityScore: " + abilityScoreModifierComponent.getTarget());

        printTabs();
        stream.println("Value: " + abilityScoreModifierComponent.getValue());

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
    public void visitClassComponent(ClassComponent classComponent) {
        printTabs();
        stream.println("ClassComponent");

        indentLevel++;

        printTabs();
        stream.println("Name: " + classComponent.getName());

        indentLevel--;
    }

    @Override
    public void visitLanguageComponent(LanguageComponent languageComponent) {
        printTabs();
        stream.println("LanguageComponent: " + languageComponent.getLanguage());
    }

    @Override
    public void visitRaceComponent(RaceComponent raceComponent) {
        printTabs();
        stream.println("RaceComponent");

        indentLevel++;

        printTabs();
        stream.println("Name: " + raceComponent.getName());

        for (Component component : raceComponent) {
            component.accept(this);
        }

        indentLevel--;
    }

    @Override
    public void visitResistanceComponent(ResistanceComponent resistanceComponent) {
        printTabs();
        stream.println("ResistanceComponent: " + resistanceComponent.getResistance().toString());
    }

    @Override
    public void visitSpeedComponent(SpeedComponent speedComponent) {
        printTabs();
        stream.println("SpeedComponent: " + speedComponent.getSpeed());
    }

    @Override
    public void visitSpellcastingComponent(SpellcastingComponent spellcastingComponent) {
        //Uhhhhhhhhhhhh
        printTabs();
        stream.println("SpellcastingComponent");
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
