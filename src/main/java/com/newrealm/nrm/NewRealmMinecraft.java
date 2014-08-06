package com.newrealm.nrm;

import com.newrealm.nrm.proxy.IProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by RealmCoder on 8/5/14.
 */

@Mod (modid = "NewRealmMinecraft", name = "New Realm Minecraft", version = "1.7.10-1.0")
public class NewRealmMinecraft {

    //You can realiably use this as an instance of your mod. No one else can or will temper with it.
    @Mod.Instance("NewRealmMinecraft")
    public static NewRealmMinecraft instance;

    //Proxies
    @SidedProxy(clientSide = "com.newrealm.nrm.proxy.ClientProxy", serverSide = "com.newrealm.nrm.proxy.ServerProxy")
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

    }

    /**
     * Initialize GUIHandler, TileEntities, Rendering, GeneralEventHandlers, Start Recipies
     * @param event
     */
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    /**
     *
     * @param event
     */
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }

}
