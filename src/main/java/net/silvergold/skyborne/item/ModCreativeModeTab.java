package net.silvergold.skyborne.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {

    //Copy for new tab
    public static final CreativeModeTab SKYBORNE_TAB = new CreativeModeTab("skybornetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.YELLOW_STONE_ACORN.get());
        }
    };
    //Paste here
}
