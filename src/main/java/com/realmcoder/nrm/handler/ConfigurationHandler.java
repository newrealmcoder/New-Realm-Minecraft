package com.realmcoder.nrm.handler;

import com.realmcoder.nrm.reference.Reference;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
public class ConfigurationHandler {

    public static Configuration configuration;

    public static boolean testValue = false;

    public static void init(File configFile)
    {
        //Create config obj from the given file
        if(configuration == null)
        {
            configuration = new Configuration(configFile);
            loadConfiguration();
        }
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent event)
    {
        //loads this Mods config if a config has changed
        if(event.modID.equalsIgnoreCase(Reference.MOD_ID))
        {
            loadConfiguration();
        }
    }

    private static void loadConfiguration()
    {
        //save a test value
        testValue = configuration.getBoolean("testValue", Configuration.CATEGORY_GENERAL, true, "this is an example configValue");

        //Save the config if it has changed
        if (configuration.hasChanged())
            configuration.save();
    }


}
