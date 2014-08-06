package com.realmcoder.newrealmminecraft.network;

import com.realmcoder.newrealmminecraft.network.message.MessageTileEntityNRM;
import com.realmcoder.newrealmminecraft.reference.Reference;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors: Pahimar (used his for general template and learning)
 */
public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

    public static void init()
    {
        INSTANCE.registerMessage(MessageTileEntityNRM.class, MessageTileEntityNRM.class, 0, Side.CLIENT);
    }
}
