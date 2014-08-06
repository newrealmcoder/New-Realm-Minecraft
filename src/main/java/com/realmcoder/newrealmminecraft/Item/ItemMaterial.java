package com.realmcoder.newrealmminecraft.Item;

import com.realmcoder.newrealmminecraft.reference.Names;
import com.realmcoder.newrealmminecraft.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import javax.xml.soap.Text;
import java.util.List;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class ItemMaterial extends ItemNRM{

    @SideOnly(Side.CLIENT)
    IIcon[] icons;

    public ItemMaterial()
    {
        super();
        this.setUnlocalizedName(Names.Items.MATERIAL);
        this.setHasSubtypes(true);
    }

    @Override
    public void registerIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[Names.Items.MATERIAL_SUBTYPES.length];
        for(int i = 0; i < Names.Items.MATERIAL_SUBTYPES.length; i ++)
        {
            icons[i] = iconRegister.registerIcon(Textures.RESOURCE_PREFIX + Names.Items.MATERIAL + "." + Names.Items.MATERIAL_SUBTYPES[i]);
        }
    }


    @Override
    public String getUnlocalizedName(ItemStack itemStack)
    {
        return String.format("item.%s%s.%s", Textures.RESOURCE_PREFIX, Names.Items.MATERIAL, Names.Items.MATERIAL_SUBTYPES[MathHelper.clamp_int(itemStack.getItemDamage(), 0, Names.Items.MATERIAL_SUBTYPES.length - 1)]);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTab, List list)
    {
        for (int meta = 0; meta < Names.Items.MATERIAL_SUBTYPES.length; ++meta)
        {
            list.add(new ItemStack(this, 1, meta));
        }
    }
}
