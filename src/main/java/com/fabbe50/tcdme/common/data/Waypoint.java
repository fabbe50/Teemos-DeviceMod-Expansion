package com.fabbe50.tcdme.common.data;

import com.mojang.realmsclient.gui.ChatFormatting;
import net.minecraft.util.math.BlockPos;

/**
 * Created by fabbe on 24/12/2017 - 1:44 PM.
 */
public class Waypoint {
    private String name;
    private BlockPos pos;

    public Waypoint(String name, BlockPos pos) {
        this.name = name;
        this.pos = pos;
    }

    public String getName() {
        return name;
    }

    public BlockPos getPos() {
        return pos;
    }

    public String getFormattedPos() {
        return ChatFormatting.DARK_GREEN.toString() + "X: " + ChatFormatting.RESET.toString() + pos.getX() + ", " +
                ChatFormatting.DARK_GREEN.toString() + "Y: " + ChatFormatting.RESET.toString() + pos.getY() + ", " +
                ChatFormatting.DARK_GREEN.toString() + "Z: " + ChatFormatting.RESET.toString() + pos.getZ();
    }
}
