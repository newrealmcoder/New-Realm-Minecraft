package com.realmcoder.newrealmminecraft.proxy;

import com.realmcoder.newrealmminecraft.tileentity.TileEntityGrindstone;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by RealmCoder on 8/5/14.
 */
public abstract class CommonProxy implements IProxy {

    @Override
    public void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityGrindstone.class, "Grindstone");
    }

}
