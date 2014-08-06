package com.realmcoder.newrealmminecraft.Init;

import com.realmcoder.newrealmminecraft.reference.Names;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class Recipies {

    public static void init()
    {
        GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(ModItems.material, 3, Names.Items.MATERIAL_END_OF_DUSTS), "s s", " s ", 's', "stone"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.ITEM_MORTAR_AND_PESTLE), "bowlStone", "stickWood"));

        for(int i = 0; i < Names.Items.MATERIAL_CRUSHABLE_LIMIT; i++)
        {
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.material, 1, i+11), new ItemStack(ModItems.ITEM_MORTAR_AND_PESTLE), Names.Items.MATERIAL_SUBTYPES[i]));
        }
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.material, 1, Names.Items.MATERIAL_END_OF_DUSTS-4), new ItemStack(ModItems.ITEM_MORTAR_AND_PESTLE), "ingotIron"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.material, 1, Names.Items.MATERIAL_END_OF_DUSTS-3), new ItemStack(ModItems.ITEM_MORTAR_AND_PESTLE), "ingotGold"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.material, 1, Names.Items.MATERIAL_END_OF_DUSTS-2), new ItemStack(ModItems.ITEM_MORTAR_AND_PESTLE), "gemDiamond"));
        GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(ModItems.material, 1, Names.Items.MATERIAL_END_OF_DUSTS-1), new ItemStack(ModItems.ITEM_MORTAR_AND_PESTLE), "gemEmerald"));
    }

}
