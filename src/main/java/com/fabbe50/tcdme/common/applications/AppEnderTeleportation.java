package com.fabbe50.tcdme.common.applications;

import com.fabbe50.tcdme.TCDME;
import com.fabbe50.tcdme.common.data.EnderPadStorage;
import com.fabbe50.tcdme.common.data.Waypoint;
import com.fabbe50.tcdme.common.tileentities.TEEnderPad;
import com.mrcrayfish.device.api.app.Application;
import com.mrcrayfish.device.api.app.Layout;
import com.mrcrayfish.device.api.app.component.*;
import com.mrcrayfish.device.api.app.component.Button;
import com.mrcrayfish.device.api.app.listener.ClickListener;
import com.mrcrayfish.device.api.app.renderer.ListItemRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.nbt.NBTTagCompound;

import java.awt.*;

/**
 * Created by fabbe on 24/12/2017 - 1:17 PM.
 */
public class AppEnderTeleportation extends Application {
    private static final Color ITEM_BACKGROUND = new Color(170, 176, 194);
    private static final Color ITEM_SELECTED = new Color(200, 176, 174);

    private Layout mainWindow;
    private ItemList<Waypoint> cordList;
    private Button tpBtn;

    @Override
    public void init() {
        mainWindow = new Layout(300, 200);
        cordList = new ItemList<>(5, 5, 150, 7);

        TCDME.getLogger().info(EnderPadStorage.enderPads);

        for (TEEnderPad b : EnderPadStorage.enderPads) {
            if (b != null) {
                NBTTagCompound tag = b.getUpdateTag();
                TCDME.getLogger().info(tag);
                if (tag.hasKey("owner")) {
                    TCDME.getLogger().info(tag.getString("owner") + "    " + Minecraft.getMinecraft().player.getDisplayNameString());

                    if (tag.getString("owner").equals(Minecraft.getMinecraft().player.getDisplayNameString())) {
                        cordList.addItem(b.getWaypointData());
                    }
                }
            }
        }

        cordList.setListItemRenderer(new ListItemRenderer<Waypoint>(20) {
            @Override
            public void render(Waypoint waypoint, Gui gui, Minecraft minecraft, int x, int y, int width, int height, boolean selected) {
                Gui.drawRect(x, y, x + width, y + height, selected ? ITEM_SELECTED.getRGB() : ITEM_BACKGROUND.getRGB());
                minecraft.fontRenderer.drawString(waypoint.getName(), x + 2, y + 2, Color.WHITE.getRGB(), false);
                minecraft.fontRenderer.drawString(waypoint.getFormattedPos(), x + 2, y + 12, Color.DARK_GRAY.getRGB(), false);
            }
        });

        mainWindow.addComponent(cordList);

        tpBtn = new Button(160, 5, 50, 20, "Teleport");
        tpBtn.setClickListener((x, y, mouseBtn) -> {
            if (mouseBtn == 0 && cordList.getSelectedItem() != null) {
                Minecraft.getMinecraft().player.closeScreen();
                Minecraft.getMinecraft().player.attemptTeleport(cordList.getSelectedItem().getPos().getX() + 0.5, cordList.getSelectedItem().getPos().getY(), cordList.getSelectedItem().getPos().getZ() + 0.5);
            }
        });

        mainWindow.addComponent(tpBtn);

        setCurrentLayout(mainWindow);
    }

    @Override
    public void load(NBTTagCompound nbtTagCompound) {

    }

    @Override
    public void save(NBTTagCompound nbtTagCompound) {

    }
}
