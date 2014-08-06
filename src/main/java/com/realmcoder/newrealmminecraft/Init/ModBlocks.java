package com.realmcoder.newrealmminecraft.Init;

import com.realmcoder.newrealmminecraft.Block.BlockNRM;
import com.realmcoder.newrealmminecraft.Block.BlockRubyPedastol;
import com.realmcoder.newrealmminecraft.reference.Names;
import com.realmcoder.newrealmminecraft.reference.Reference;
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
        GameRegistry.registerBlock(rubyPedastol, Names.Blocks.RUBY_PEDESTAL);
    }
}
