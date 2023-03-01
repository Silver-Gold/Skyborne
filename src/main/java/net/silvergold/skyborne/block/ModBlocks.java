package net.silvergold.skyborne.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.silvergold.skyborne.Skyborne;
import net.silvergold.skyborne.block.custom.ModFlammableRotatedPillarBlock;
import net.silvergold.skyborne.item.ModCreativeModeTab;
import net.silvergold.skyborne.item.ModItems;
import net.silvergold.skyborne.world.feature.tree.PinkStoneTreeGrower;
import net.silvergold.skyborne.world.feature.tree.YellowStoneTreeGrower;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Skyborne.MOD_ID);

    //Add new Blocks here. Ores should be made with "DropExperienceBlock" instead of "Block"
    public static final RegistryObject<Block> SKY_STONE = registerBlock("sky_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).requiresCorrectToolForDrops()), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> COBBLED_SKY_STONE = registerBlock("cobbled_sky_stone", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STONE_PLANKS = registerBlock("stone_planks", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STONE_LOG = registerBlock("stone_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STRIPPED_STONE_LOG = registerBlock("stripped_stone_log", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STONE_WOOD = registerBlock("stone_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STRIPPED_STONE_WOOD = registerBlock("stripped_stone_wood", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STONE_LOG_ANDESITE = registerBlock("stone_log_andesite", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> STONE_LOG_QUARTZ = registerBlock("stone_log_quartz", () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(2f).sound(SoundType.NETHER_BRICKS)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> YELLOW_ELYSIAN_FOLIAGE = registerBlock("yellow_elysian_foliage", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.AZALEA_LEAVES)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> PINK_ELYSIAN_FOLIAGE = registerBlock("pink_elysian_foliage", () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.AZALEA_LEAVES)), ModCreativeModeTab.SKYBORNE_TAB);

    public static final RegistryObject<Block> YELLOW_STONE_ACORN = registerBlock("yellow_stone_acorn", () -> new SaplingBlock(new YellowStoneTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.STONE)), ModCreativeModeTab.SKYBORNE_TAB);
    public static final RegistryObject<Block> PINK_STONE_ACORN = registerBlock("pink_stone_acorn", () -> new SaplingBlock(new PinkStoneTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING).sound(SoundType.STONE)), ModCreativeModeTab.SKYBORNE_TAB);


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);

        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {

        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
