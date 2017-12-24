package com.fabbe50.tcdme.common.tileentities;

import com.fabbe50.tcdme.common.data.Waypoint;
import com.mrcrayfish.device.tileentity.TileEntityDevice;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.util.Constants;

import javax.annotation.Nullable;

/**
 * Created by fabbe on 24/12/2017 - 2:10 PM.
 */
public class TEEnderPad extends TileEntity implements ITickable {
    private String name = "Ender Pad";
    private String owner = "";
    NBTTagCompound bufferTag = new NBTTagCompound();

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        compound.setString("name", name);
        compound.setString("owner", owner);

        return compound;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("name", Constants.NBT.TAG_STRING)) {
            name = compound.getString("name");
        }
        if (compound.hasKey("owner", Constants.NBT.TAG_STRING)) {
            owner = compound.getString("owner");
        }
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
        NBTTagCompound tag = pkt.getNbtCompound();
        this.readFromNBT(tag);
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        if (!bufferTag.hasNoTags()) {
            NBTTagCompound updateTag = super.writeToNBT(bufferTag);
            bufferTag = new NBTTagCompound();
            return updateTag;
        }
        return this.writeToNBT(new NBTTagCompound());
    }

    @Nullable
    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(pos, 3, getUpdateTag());
    }

    @Override
    public void update() {

    }

    public Waypoint getWaypointData() {
        return new Waypoint(name, pos.add(0, 1, 0));
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Nullable
    @Override
    public ITextComponent getDisplayName() {
        return new TextComponentString(name);
    }
}
