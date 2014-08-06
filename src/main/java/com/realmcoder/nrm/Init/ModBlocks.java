package com.realmcoder.nrm.Init;

import com.realmcoder.nrm.Block.BlockNRM;
import com.realmcoder.nrm.Block.BlockRubyPedastol;
import com.realmcoder.nrm.reference.Names;
import com.realmcoder.nrm.reference.Reference;
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
