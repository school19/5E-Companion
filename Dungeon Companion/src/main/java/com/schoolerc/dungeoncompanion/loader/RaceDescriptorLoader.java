package com.schoolerc.dungeoncompanion.loader;

import android.content.AsyncTaskLoader;
import android.content.Context;

import com.schoolerc.dungeoncompanion.ui.RaceDescriptor;

import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.JsePlatform;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chaz on 6/13/2017.
 */

public class RaceDescriptorLoader extends AsyncTaskLoader<RaceDescriptor> {

    private String path;

    public RaceDescriptorLoader(Context ctx, String path)
    {
        super(ctx);
        this.path = path;
    }

    @Override
    public RaceDescriptor loadInBackground() {
        Globals globals = JsePlatform.standardGlobals();
        LuaValue chunk = globals.loadfile(path);
        LuaTable table = chunk.call().checktable();
        if(table == null){
            return null;
        }

        LuaValue speedValue = table.get("speed");
        LuaValue nameValue = table.get("name");

        RaceDescriptor descriptor = new RaceDescriptor();
        descriptor.setName(nameValue.checkjstring());
        descriptor.setSpeed(speedValue.checkint());


        LuaTable traitsTable = table.get("traits").checktable();
        for (LuaValue key : traitsTable.keys()) {
            LuaTable trait = traitsTable.get(key).checktable();
            LuaValue description = trait.get("description");
            descriptor.addTraitDescription(description.checkjstring());
        }

        LuaValue subracesValue = table.get("subraces");
        if(!subracesValue.isnil())
        {
            LuaTable subracesTable = subracesValue.checktable();
            for (LuaValue key : subracesTable.keys()) {
                LuaTable subrace = subracesTable.get(key).checktable();

            }
        }

        return null;
    }

}
