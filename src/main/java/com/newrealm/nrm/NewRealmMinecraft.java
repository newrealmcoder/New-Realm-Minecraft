package com.newrealm.nrm;

import com.newrealm.nrm.handler.ConfigurationHandler;
import com.newrealm.nrm.proxy.IProxy;
import com.newrealm.nrm.reference.Reference;
import com.newrealm.nrm.utility.LogHelper;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by RealmCoder on 8/5/14.
 * Contributors:
 */
@Mod (modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class NewRealmMinecraft {

    //You can realiably use this as an instance of your mod. No one else can or will temper with it.
    @Mod.Instance(Reference.MOD_ID)
    public static NewRealmMinecraft instance;

    //Proxies
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;

    //Item Declarations

    //Block Declarations

    //

    /**
     * Initialize Blocks, Items, Configs, NetworkHandling, Keybinding, etc.
     * @param event
     */
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        //Init configHandler using file that MCForge suggests to use
        ConfigurationHandler.init(event.getSuggestedConfigurationFile());
        FMLCommonHandler.instance().bus().register(new ConfigurationHandler());

        LogHelper.info("Pre Initialization Completed");
    }

    /**
     * Initialize GUIHandler, TileEntities, Rendering, GeneralEventHandlers, Start Recipies
     * @param event
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        LogHelper.info("Initialization Completed");
    }

    /**
     *
     * @param event
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        LogHelper.info("Post Initialization Completed");
    }

}
