package com.realmcoder.newrealmminecraft.Block;

import com.realmcoder.newrealmminecraft.reference.Names;
import net.minecraft.block.material.Material;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class BlockRubyPedastol extends BlockNRM{

    public BlockRubyPedastol()
    {
        super(Material.iron);
        this.setBlockName(Names.Blocks.RUBY_PEDESTAL);
        this.setBlockTextureName(Names.Blocks.RUBY_PEDESTAL);
        this.setHardness(.5f);
        this.setResistance(32f);
        this.setLightLevel(8);
    }

}
