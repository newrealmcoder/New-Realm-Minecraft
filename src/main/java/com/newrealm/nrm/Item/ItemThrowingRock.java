package com.newrealm.nrm.Item;

import com.newrealm.nrm.reference.Names;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class ItemThrowingRock extends ItemNRM {

    public ItemThrowingRock()
    {
        super();
        this.setUnlocalizedName(Names.Items.THROWING_ROCK);
        this.setMaxStackSize(64);
    }

}