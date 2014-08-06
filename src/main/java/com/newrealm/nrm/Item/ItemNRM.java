package com.newrealm.nrm.Item;

import com.newrealm.nrm.reference.Reference;
import com.newrealm.nrm.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * A wrapper class that has common functions, only need to specify little bits on subclasses
 *
 * Created by RealmCoder on 8/5/14.
 * Contributors: Pahimar (unknowingly)
 */
public class ItemNRM extends Item {

    public ItemNRM()
    {
        super();
        this.maxStackSize = 1;
        this.setNoRepair();

    }

    /**
     * Converts from item.MOD_ID:itemName.name --> Item Name
     *      i.e. how minecraft expects it
     * @return
     */
    @Override
    public String getUnlocalizedName()
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }

}
