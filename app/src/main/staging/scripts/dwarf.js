importPackage(Packages.com.schoolerc.fiftheditioncompanion.data);

healthModifierTemplate = {
    apply: function(state){state.setMaxHitPoints(state.getMaxHitPoints()+state.getLevel());}
};

healthModifier = new Modifier(healthModifierTemplate);

raceTemplate = {
    getName: function(){return "Dwarf"},
    getModifiers: function(){return [new AbilityScoreModifier(AbilityScore.Constitution, 2), healthModifier]}
};

race = new Race(raceTemplate);