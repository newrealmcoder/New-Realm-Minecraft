package com.realmcoder.newrealmminecraft.Block;

import com.realmcoder.newrealmminecraft.reference.Names;
import com.realmcoder.newrealmminecraft.tileentity.TileEntityGrindStone;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class BlockTileEntities extends BlockNRM {

    @SideOnly(Side.CLIENT)
    IIcon[][] icons;

    public BlockTileEntities()
    {
        super(Names.Blocks.TILE_ENTITY_BLOCK);
    }

    /**
     * This method parses the Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES String[][] into an actual icon grid
     * @param iconRegister
     * @return
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        icons = new IIcon[Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES.length][];

        int origStringLength;

        for(int i = 0; i < Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES.length; i++)
        {
            if(Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[i].length == 1)
            {
                icons[i] = new IIcon[]{iconRegister.registerIcon(this.getUnlocalizedName() + "." + Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[i][0])};
            }
            else
            {
                icons[i] = new IIcon[6];
                origStringLength = Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[i][0].length();
                for(int n = 1; n < Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[i].length; n++)
                {
                    int sidesToPutOn = Integer.parseInt(Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[i][n].substring(origStringLength));
                    recursivelyPlaceIcons(i, sidesToPutOn, iconRegister.registerIcon(this.getUnlocalizedName() + "." + Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[i][n]));
                }
            }
        }
    }

    private void recursivelyPlaceIcons(int curIconLayer, int arrayLocs, IIcon icon)
    {
        icons[curIconLayer][(arrayLocs%10)-1] = icon;
        arrayLocs /= 10;
        if(arrayLocs>0)
            recursivelyPlaceIcons(curIconLayer, arrayLocs, icon);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int metaData)
    {
        metaData = MathHelper.clamp_int(metaData, 0, Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES.length - 1);

        if(Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES[metaData].length == 1)
            return icons[metaData][0];
        else
            return icons[metaData][side];
    }

    @Override
    public int damageDropped(int metaData)
    {
        return metaData;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs creativeTabs, List list)
    {
        for (int meta = 0; meta < Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES.length; meta++)
        {
            list.add(new ItemStack(item, 1, meta));
        }
    }

    @Override
    public boolean hasTileEntity(int meta)
    {
        return meta < Names.Blocks.TILE_ENTITY_BLOCK_SUBTYPES.length;
    }

    @Override
    public TileEntity createTileEntity(World world, int meta)
    {
        switch (meta)
        {
            case 0:
                return new TileEntityGrindStone();
        }
        return null;
    }

}
