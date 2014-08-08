package com.realmcoder.newrealmminecraft.client.gui.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.realmcoder.newrealmminecraft.inventory.ContainerGrindstone;
import com.realmcoder.newrealmminecraft.reference.Reference;
import com.realmcoder.newrealmminecraft.tileentity.TileEntityGrindstone;


public class GrindstoneGui extends GuiContainer {
    
    /**
     * Needs to be 256*256
     */
    private static final ResourceLocation backgroundimage = new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/grindstoneGui.png");
    
    
    public GrindstoneGui(InventoryPlayer inventoryPlayer, TileEntityGrindstone tileGrindstone)
    {
        super(new ContainerGrindstone(inventoryPlayer, tileGrindstone));
        xSize = 176;
        ySize = 166;
    }
    
    /**
     * GuiElement locations
     * Progress Bar: x = 25 --> 157 (133)       Progress Bar Complete: x = 0   --> 132 (133)
     *               y = 38 --> 43  (6)                                y = 166 --> 171 (6)
     * Kinetic Energy Bar: x = 3  --> 7  (5)    Kinetic Energy Bar Full: x = 176 --> 180 (5)
     *                     y = 64 --> 81 (18)                            y = 0   --> 17  (18)
     * Heat Energy Bar: x = 168 --> 172  (5)    Heat Energy Bar Full: x = 181 --> 185 (5)
     *                  y = 64  --> 81   (18)                         y = 0   --> 17  (18)
     * Speed And Efficiency Texture Full: x = 186 --> 245 (60)
     *                                    y = 0   --> 17  (18)
     * Efficiency Texture Area: x = 27 --> 86 (60)  Speed Texture Area: x = 89 --> 150 (60)
     *                          y = 5  --> 22 (18)                      y = 5  --> 22  (18)
     * Will Not Work: x = 5 --> 13 (9)  Will Work: x = 246 --> 254 (9)
     *                y = 5 --> 13 (9)             y = 0   --> 8   (9)
     */
    @Override
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        //Bind the background to be able to draw it
        this.mc.renderEngine.bindTexture(backgroundimage);
        
        //Draw the basic GUI
        
        // set the x for the texture, Total width - textureSize / 2
        par2 = (this.width - xSize) / 2;
        // set the y for the texture, Total height - textureSize - 30 (up) / 2,
        int j = (this.height - ySize) / 2;
        // draw the texture
        drawTexturedModalRect(par2, j, 0, 0, xSize,  ySize);
        
    }
    
}
