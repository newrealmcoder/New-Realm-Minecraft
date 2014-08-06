package com.realmcoder.newrealmminecraft.Init;

import com.realmcoder.newrealmminecraft.Item.ItemMaterial;
import com.realmcoder.newrealmminecraft.Item.ItemMortarAndPestle;
import com.realmcoder.newrealmminecraft.Item.ItemNRM;
import com.realmcoder.newrealmminecraft.Item.ItemThrowingRock;
import com.realmcoder.newrealmminecraft.reference.Names;
import com.realmcoder.newrealmminecraft.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

    public static final ItemNRM throwingRock    = new ItemThrowingRock();
    public static final ItemNRM material        = new ItemMaterial();
    public static final ItemNRM mortarAndPestal = new ItemMortarAndPestle();

    public static void init()
    {
        GameRegistry.registerItem(throwingRock, Names.Items.THROWING_ROCK);
        GameRegistry.registerItem(material, Names.Items.MATERIAL);

        GameRegistry.registerItem(mortarAndPestal, Names.Items.MORTAR_AND_PESTLE);

        for(int i = 0; i < Names.Items.MATERIAL_IN_OREDICT_LIMIT; i++)
        {
            OreDictionary.registerOre(Names.Items.MATERIAL_SUBTYPES[i], new ItemStack(ModItems.material, 1, i));
        }
    }

}
