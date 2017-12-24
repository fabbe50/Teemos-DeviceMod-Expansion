package com.fabbe50.tcdme.client.render.tileentities;

import com.fabbe50.tcdme.common.tileentities.TEEnderPad;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

/**
 * Created by fabbe on 24/12/2017 - 2:29 PM.
 */
public class RenderTEEnderPad extends TileEntitySpecialRenderer<TEEnderPad> {
    @Override
    public void render(TEEnderPad te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        GlStateManager.pushMatrix();
        {
            super.render(te, x, y, z, partialTicks, destroyStage, alpha);
        }
        GlStateManager.popMatrix();
    }
}
