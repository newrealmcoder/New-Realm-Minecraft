package com.realmcoder.nrm.Block;

import com.realmcoder.nrm.reference.Names;
import net.minecraft.block.material.Material;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class BlockRubyPedastol extends BlockNRM{

    public BlockRubyPedastol()
    {
        super(Material.iron);
        this.setBlockName(Names.Blocks.RUBY_PEDASTOL);
        this.setBlockTextureName(Names.Blocks.RUBY_PEDASTOL);
        this.setHardness(.5f);
        this.setResistance(32f);
        this.setLightLevel(8);
    }

}
