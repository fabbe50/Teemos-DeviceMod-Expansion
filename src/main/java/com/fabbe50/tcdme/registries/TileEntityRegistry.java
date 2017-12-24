package com.fabbe50.tcdme.registries;

import com.fabbe50.tcdme.common.tileentities.TEEnderPad;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by fabbe on 24/12/2017 - 2:34 PM.
 */
public class TileEntityRegistry {
    public static void init() {
        GameRegistry.registerTileEntity(TEEnderPad.class, "enderpad");
    }
}
