package com.realmcoder.newrealmminecraft.network.message;

import com.realmcoder.newrealmminecraft.tileentity.TileEntityNRM;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors: Pahimar (used his for general template and learning)
 */
public class MessageTileEntityNRM implements IMessage, IMessageHandler<MessageTileEntityNRM, IMessage>{

    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;
    public boolean isPrivate;

    /**
     * This is a necessary components of messages because otherwise it won't be instantiable from SimpleNetworkWrapper,
     * making it impossible to be used
     */
    public MessageTileEntityNRM()
    {
        
    }
    
    public MessageTileEntityNRM(TileEntityNRM tileNRM)
    {
        this.x = tileNRM.xCoord;
        this.y = tileNRM.yCoord;
        this.z = tileNRM.zCoord;
        this.orientation = (byte) tileNRM.getOrientation().ordinal();
        this.state = tileNRM.getState();
        this.customName = tileNRM.getCustomName();
        this.owner = tileNRM.getOwner();
        this.isPrivate = tileNRM.isPrivate();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerNameLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerNameLength).array());
        this.isPrivate = buf.readBoolean();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
        buf.writeBoolean(isPrivate);
    }

    @Override
    public IMessage onMessage(MessageTileEntityNRM message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityNRM)
        {
            ((TileEntityNRM) tileEntity).setOrientation(message.orientation);
            ((TileEntityNRM) tileEntity).setState(message.state);
            ((TileEntityNRM) tileEntity).setCustomName(message.customName);
            ((TileEntityNRM) tileEntity).setOwner(message.owner);
            ((TileEntityNRM) tileEntity).setPrivate(message.isPrivate);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityNRM - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s, isPrivate:%s", x, y, z, orientation, state, customName, owner, isPrivate);
    }
}
