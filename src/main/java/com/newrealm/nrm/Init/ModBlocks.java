package com.newrealm.nrm.Init;

import com.newrealm.nrm.Block.BlockNRM;
import com.newrealm.nrm.Block.BlockRubyPedastol;
import com.newrealm.nrm.reference.Names;
import com.newrealm.nrm.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

    public static final BlockNRM rubyPedastol = new BlockRubyPedastol();

    public static void init()
    {
        GameRegistry.registerBlock(rubyPedastol, Names.Blocks.RUBY_PEDASTOL);
    }
}
