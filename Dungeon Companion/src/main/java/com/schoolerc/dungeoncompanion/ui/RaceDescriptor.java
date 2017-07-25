package com.schoolerc.dungeoncompanion.ui;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz on 6/13/2017.
 */

public class RaceDescriptor {
    private String scriptPath;
    private List<String> traitDescriptions;
    private int speed;
    private String name;
    private List<SubraceDescriptor> subraces;

    public RaceDescriptor() {
        subraces = new ArrayList<>();
        traitDescriptions = new ArrayList<>();
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScriptPath(String scriptPath) {
        this.scriptPath = scriptPath;
    }

    public String getScriptPath() {

        return scriptPath;
    }

    public List<String> getTraitDescriptions() {
        return traitDescriptions;
    }

    public List<SubraceDescriptor> getSubraces() {
        return subraces;
    }

    public void addSubrace(SubraceDescriptor descriptor)
    {
        subraces.add(descriptor);

    }

    public void addTraitDescription(String description)
    {
        traitDescriptions.add(description);
    }
}
