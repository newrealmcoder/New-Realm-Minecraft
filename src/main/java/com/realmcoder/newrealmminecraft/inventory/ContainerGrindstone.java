package com.realmcoder.newrealmminecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;

import com.realmcoder.newrealmminecraft.tileentity.TileEntityGrindstone;


public class ContainerGrindstone extends Container {
    
    private TileEntityGrindstone tile;
    
    public ContainerGrindstone(InventoryPlayer inventoryPlayer, TileEntityGrindstone tileGrindstone)
    {
        this.tile = tileGrindstone;
        bindPlayerInventory(inventoryPlayer);
    }
    
    private void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        int id = 0; //Slot ID in player's inventory
        
        for(int i = 0; i < 9; i++)
        {
            addSlotToContainer(new Slot(inventoryPlayer, id, i * 18 + 8, 189)); //Adds player hotbar
            id++;
        }
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                addSlotToContainer(new Slot(inventoryPlayer, id ,j * 18 + 8, i * 18 + 131 )); //Adds player inventory
                id++;
            }
        }
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer p_75145_1_)
    {
        return true;
    }
    
}
