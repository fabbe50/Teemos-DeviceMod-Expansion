package com.fabbe50.tcdme.registries;

import com.fabbe50.tcdme.TDMETab;
import com.fabbe50.tcdme.common.blocks.BlockEnderPad;
import com.fabbe50.tcdme.handler.RegistryHandler;
import net.minecraft.block.Block;

/**
 * Created by fabbe on 24/12/2017 - 2:34 PM.
 */
public class BlockRegistry {
    public static final Block ENDER_PAD = new BlockEnderPad("enderpad").setCreativeTab(TDMETab.tdmetab);

    public static void init() {
        RegistryHandler.registerBlock(ENDER_PAD);
    }
}
