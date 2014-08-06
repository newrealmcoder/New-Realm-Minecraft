package com.realmcoder.newrealmminecraft.creativetabs;

import com.realmcoder.newrealmminecraft.Init.ModBlocks;
import com.realmcoder.newrealmminecraft.Init.ModItems;
import com.realmcoder.newrealmminecraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class CreativeTabsNRM {

    public static final CreativeTabs NRM_BLOCK_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()+"block") {

        @Override
        public Item getTabIconItem()
        {
            return ModBlocks.rubyPedastol.getItemDropped(1, new Random(), 1);
        }
    };

    public static final CreativeTabs NRM_ITEM_TAB = new CreativeTabs(Reference.MOD_ID.toLowerCase()+"item") {

        @Override
        public Item getTabIconItem()
        {
            return ModItems.throwingRock;
        }
    };
}
