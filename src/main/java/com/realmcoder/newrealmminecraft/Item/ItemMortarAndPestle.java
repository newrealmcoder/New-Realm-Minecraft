package com.realmcoder.newrealmminecraft.Item;

import com.realmcoder.newrealmminecraft.reference.Names;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class ItemMortarAndPestle extends ItemNRM{

    public ItemMortarAndPestle()
    {
        super(Names.Items.MORTAR_AND_PESTLE);
        this.setMaxDamage(64);
        this.setNoRepair();
    }
}
