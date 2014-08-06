package com.newrealm.nrm.Init;

import com.newrealm.nrm.Item.ItemNRM;
import com.newrealm.nrm.Item.ItemThrowingRock;
import com.newrealm.nrm.reference.Names;
import com.newrealm.nrm.reference.Reference;
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
