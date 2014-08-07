package com.realmcoder.newrealmminecraft.Init;

import net.minecraft.block.BlockContainer;

import com.realmcoder.newrealmminecraft.Block.BlockNRM;
import com.realmcoder.newrealmminecraft.Block.BlockGemPedestal;
import com.realmcoder.newrealmminecraft.Block.BlockTileEntities;
import com.realmcoder.newrealmminecraft.reference.Names;
import com.realmcoder.newrealmminecraft.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

    public static final BlockNRM GEM_PEDESTAL = new BlockGemPedestal();
    public static final BlockContainer tileEntityBlocks = new BlockTileEntities();

    public static void init()
    {
        GameRegistry.registerBlock(GEM_PEDESTAL, Names.Blocks.GEM_PEDESTAL);
        GameRegistry.registerBlock(tileEntityBlocks, Names.Blocks.TILE_ENTITY_BLOCK);
    }
}
