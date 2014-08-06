package com.realmcoder.nrm.Init;

import com.realmcoder.nrm.Item.ItemNRM;
import com.realmcoder.nrm.Item.ItemThrowingRock;
import com.realmcoder.nrm.reference.Names;
import com.realmcoder.nrm.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemNRM throwingRock = new ItemThrowingRock();

    public static void init()
    {
        GameRegistry.registerItem(throwingRock, Names.Items.THROWING_ROCK);


    }

}
