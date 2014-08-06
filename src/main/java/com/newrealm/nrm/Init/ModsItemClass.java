package com.newrealm.nrm.Init;

import com.newrealm.nrm.Item.ItemNRM;
import com.newrealm.nrm.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class ModsItemClass {

    public static final ItemNRM throwingRock = new com.newrealm.nrm.Item.ItemThrowingRock();

    public static void init()
    {
        GameRegistry.registerItem(throwingRock, Names.Items.THROWING_ROCK);


    }

}
