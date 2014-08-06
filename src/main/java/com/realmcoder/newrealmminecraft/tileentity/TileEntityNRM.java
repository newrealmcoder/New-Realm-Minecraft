package com.realmcoder.newrealmminecraft.tileentity;

import com.realmcoder.newrealmminecraft.network.PacketHandler;
import com.realmcoder.newrealmminecraft.network.message.MessageTileEntityNRM;
import com.realmcoder.newrealmminecraft.reference.Names;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Created by RealmCoder on 8/6/14.
 * Contributors: Pahimar (used his for general template and learning)
 */
public class TileEntityNRM extends TileEntity{

    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    protected String owner;
    protected boolean isPrivate;

    public TileEntityNRM()
    {
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
        owner = "";
        isPrivate = false;
    }

    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(Byte orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public byte getState()
    {
        return state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }

    public String getCustomName()
    {
        return customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    public boolean isPrivate()
    {
        return hasOwner() && isPrivate;
    }

    public void setPrivate(boolean isPrivate)
    {
        this.isPrivate = isPrivate;
    }

    public boolean hasOwner()
    {
        return owner != null && owner.length() > 0;
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound)
    {
        super.writeToNBT(tagCompound);

        tagCompound.setByte(Names.NBT.ORIENTATION, (byte) orientation.ordinal());
        tagCompound.setByte(Names.NBT.STATE, state);
        tagCompound.setBoolean(Names.NBT.IS_PRIVATE, isPrivate);

        if(this.hasCustomName())
        {
            tagCompound.setString(Names.NBT.CUSTOM_NAME, customName);
        }
        if(this.hasOwner())
        {
            tagCompound.setString(Names.NBT.OWNER, owner);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound)
    {
        super.readFromNBT(tagCompound);

        if(tagCompound.hasKey(Names.NBT.ORIENTATION))
        {
            this.orientation = ForgeDirection.getOrientation(tagCompound.getByte(Names.NBT.ORIENTATION));
        }

        if(tagCompound.hasKey(Names.NBT.STATE))
        {
            this.state = tagCompound.getByte(Names.NBT.STATE);
        }

        if(tagCompound.hasKey(Names.NBT.IS_PRIVATE))
        {
            this.isPrivate = tagCompound.getBoolean(Names.NBT.IS_PRIVATE);
        }

        if(tagCompound.hasKey(Names.NBT.CUSTOM_NAME))
        {
            this.customName = tagCompound.getString(Names.NBT.CUSTOM_NAME);
        }

        if(tagCompound.hasKey(Names.NBT.OWNER))
        {
            this.owner = tagCompound.getString(Names.NBT.OWNER);
        }
    }

    @Override
    public Packet getDescriptionPacket()
    {
        return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityNRM(this));
    }
}
