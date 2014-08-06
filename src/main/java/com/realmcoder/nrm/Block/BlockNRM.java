package com.realmcoder.nrm.Block;

import com.realmcoder.nrm.reference.Textures;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class BlockNRM extends Block{

    public BlockNRM(Material material)
    {
        super(material);
    }

    public BlockNRM()
    {
        super(Material.rock);
    }

    /**
     * Converts from tile.MOD_ID:blockName.name --> Item Name
     *      i.e. how minecraft expects it
     * @return
     */
    @Override
    public String getUnlocalizedName()
    {
        return String.format("tile.%s%s", Textures.RESOURCE_PREFIX, getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".")+1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        blockIcon = iconRegister.registerIcon(getUnwrappedUnlocalizedName(this.getUnlocalizedName()));
    }
}
