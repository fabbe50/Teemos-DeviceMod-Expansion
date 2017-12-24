package com.fabbe50.tcdme.proxies;

import com.fabbe50.tcdme.registries.ApplicationRegistry;
import com.fabbe50.tcdme.registries.BlockRegistry;
import com.fabbe50.tcdme.registries.TileEntityRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * Created by fabbe on 24/12/2017 - 11:52 AM.
 */
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
        BlockRegistry.init();

    }

    public void init(FMLInitializationEvent event) {
        TileEntityRegistry.init();
        ApplicationRegistry.init();
    }

    public void postInit(FMLPostInitializationEvent event) {

    }
}
