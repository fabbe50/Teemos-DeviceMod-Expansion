package com.fabbe50.tcdme;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

/**
 * Created by fabbe on 24/12/2017 - 3:03 PM.
 */
public class TDMETab {
    public static CreativeTabs tdmetab = new CreativeTabs(Reference.MODID) {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Items.STICK);
        }
    };
}
