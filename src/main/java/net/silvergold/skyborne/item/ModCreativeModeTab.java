package net.silvergold.skyborne.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.silvergold.skyborne.block.ModBlocks;

public class ModCreativeModeTab {

    //Copy for new tab
    public static final CreativeModeTab SKYBORNE_TAB = new CreativeModeTab("skybornetab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.YELLOW_STONE_ACORN.get());
        }
    };
    //Paste here
}
