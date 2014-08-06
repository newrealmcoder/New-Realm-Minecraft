package com.realmcoder.newrealmminecraft.client.gui;

import com.realmcoder.newrealmminecraft.handler.ConfigurationHandler;
import com.realmcoder.newrealmminecraft.reference.Reference;
import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class ModGuiConfig extends GuiConfig {

    public ModGuiConfig(GuiScreen guiScreen)
    {
        //GuiScreen passing, Elements that the config loads, MOD_ID, WorldRestart on config change?, MinecraftRestart on config change?, Name
        super(guiScreen, new ConfigElement(ConfigurationHandler.configuration.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_ID,
                false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));

    }

}
