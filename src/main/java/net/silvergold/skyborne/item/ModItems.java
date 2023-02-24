package net.silvergold.skyborne.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silvergold.skyborne.Skyborne;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Skyborne.MOD_ID);

    //Add new items here
    public static final RegistryObject<Item> ANDESITE_DEPOSIT = ITEMS.register("andesite_deposit",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SKYBORNE_TAB)));
    public static final RegistryObject<Item> YELLOW_STONE_ACORN = ITEMS.register("yellow_stone_acorn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SKYBORNE_TAB)));
    public static final RegistryObject<Item> PINK_STONE_ACORN = ITEMS.register("pink_stone_acorn",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.SKYBORNE_TAB)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}