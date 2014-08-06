package com.realmcoder.newrealmminecraft.Block;

import com.realmcoder.newrealmminecraft.creativetabs.CreativeTabsNRM;
import com.realmcoder.newrealmminecraft.reference.Textures;
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
        this.setCreativeTab(CreativeTabsNRM.NRM_BLOCK_TAB);
    }

    public BlockNRM()
    {
        this(Material.rock);
    }

    public BlockNRM(String blockName)
    {
        this(blockName, Material.rock);
    }

    public BlockNRM(String blockName, Material material)
    {
        this(material);
        this.setBlockName(blockName);
        this.setBlockTextureName(blockName);
        this.setCreativeTab(CreativeTabsNRM.NRM_BLOCK_TAB);
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
