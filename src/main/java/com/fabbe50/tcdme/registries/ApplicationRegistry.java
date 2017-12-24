package com.fabbe50.tcdme.registries;

import com.fabbe50.tcdme.Reference;
import com.fabbe50.tcdme.common.applications.AppEnderTeleportation;
import com.mrcrayfish.device.api.ApplicationManager;
import net.minecraft.util.ResourceLocation;

/**
 * Created by fabbe on 24/12/2017 - 1:06 PM.
 */
public class ApplicationRegistry {
    public static void init() {
        ApplicationManager.registerApplication(new ResourceLocation(Reference.MODID, "endertransport"), AppEnderTeleportation.class);
    }
}
