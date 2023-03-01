package net.silvergold.skyborne.world.feature;

import net.minecraft.util.valueproviders.ConstantFloat;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.SpruceFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.silvergold.skyborne.Skyborne;
import net.silvergold.skyborne.block.ModBlocks;
import net.silvergold.skyborne.world.feature.custom.TrunkPlacerAndesite;
import net.silvergold.skyborne.world.feature.custom.TrunkPlacerQuartz;


public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?, ?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, Skyborne.MOD_ID);

    public static final RegistryObject<ConfiguredFeature<?, ?>> YELLOW_STONE_TREE =
            CONFIGURED_FEATURES.register("yellow_stone_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.STONE_LOG.get()),
                            new TrunkPlacerAndesite(4, 2, 0),
                            BlockStateProvider.simple(ModBlocks.YELLOW_ELYSIAN_FOLIAGE.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static final RegistryObject<ConfiguredFeature<?, ?>> PINK_STONE_TREE =
            CONFIGURED_FEATURES.register("pink_stone_tree", () ->
                    new ConfiguredFeature<>(Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                            BlockStateProvider.simple(ModBlocks.STONE_LOG.get()),
                            new TrunkPlacerQuartz(4, 2, 0),
                            BlockStateProvider.simple(ModBlocks.PINK_ELYSIAN_FOLIAGE.get()),
                            new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 3),
                            new TwoLayersFeatureSize(1, 0, 1)).build()));

    public static void register(IEventBus eventBus) { CONFIGURED_FEATURES.register(eventBus); }
}
