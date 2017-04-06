package com.schoolerc.fiftheditioncompanion.entity.operators;

import com.schoolerc.fiftheditioncompanion.entity.AbilityScoreComponent;
import com.schoolerc.fiftheditioncompanion.entity.Character;

/**
 * Created by Chaz Schooler on 2/13/2017.
 */

public interface ComponentVisitor {
    void visitCharacter(Character c);
    void visitAbilityScoreComponent(AbilityScoreComponent abilityScoreComponent);
}
