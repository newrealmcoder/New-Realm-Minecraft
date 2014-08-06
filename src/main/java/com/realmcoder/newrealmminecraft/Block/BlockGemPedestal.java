package com.realmcoder.newrealmminecraft.Block;

import com.realmcoder.newrealmminecraft.reference.Names;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class BlockGemPedestal extends BlockNRM{

    public BlockGemPedestal()
    {
        super(Names.Blocks.GEM_PEDESTAL);
        this.setHardness(.5f);
        this.setResistance(32f);
        this.setLightLevel(8);
    }

}
