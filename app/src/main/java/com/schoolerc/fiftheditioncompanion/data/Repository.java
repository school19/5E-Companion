package com.schoolerc.fiftheditioncompanion.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz on 5/4/2017.
 */

public class Repository {
    public interface Listener{
        void onRaceRegistered();
        void onClassRegistered();
    }

    public Repository()
    {
        listeners = new ArrayList<>();
        races = new ArrayList<>();
        classes = new ArrayList<>();
    }

    private List<Listener> listeners;

    public void addListener(Listener listener)
    {
        listeners.add(listener);
    }

    public void removeListener(Listener listener)
    {
        listeners.remove(listener);
    }

    private List<Race> races;
    private List<CharacterClass> classes;

    public void registerClass(CharacterClass characterClass)
    {
        classes.add(characterClass);
        for (Listener listener : listeners) {
            listener.onClassRegistered();
        }
    }

    public void registerRace(Race race)
    {
        races.add(race);
        for (Listener listener : listeners) {
            listener.onRaceRegistered();
        }
    }

    public List<Race> getRaces()
    {
        return races;
    }

    public List<CharacterClass> getClasses()
    {
        return classes;
    }
}
