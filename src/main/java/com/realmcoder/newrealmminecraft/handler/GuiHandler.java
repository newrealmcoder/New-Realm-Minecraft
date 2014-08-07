package com.realmcoder.newrealmminecraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.realmcoder.newrealmminecraft.client.gui.inventory.GrindstoneGui;
import com.realmcoder.newrealmminecraft.tileentity.TileEntityGrindstone;

import cpw.mods.fml.common.network.IGuiHandler;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors:
 */
public class GuiHandler implements IGuiHandler {

    /**
     * Gets the server GUI element
     * Do things on serverside when this ID gets called
     * @param ID, player, world, x, y, z
     * @return
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(x, y, z);
        if(te instanceof TileEntityGrindstone)
            return new GrindstoneGui(player.inventory, (TileEntityGrindstone) te);
        return null;
    }

    /**
     * Gets the client GUI element
     * Do things clientside when this ID gets called
     * @param ID, player, world, x, y, z
     * @return
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity te = world.getTileEntity(x, y, z);
        if(te instanceof TileEntityGrindstone)
            return new GrindstoneGui(player.inventory, (TileEntityGrindstone) te);
        return null;
    }
}
