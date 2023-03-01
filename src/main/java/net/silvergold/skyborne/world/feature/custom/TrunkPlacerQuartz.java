package net.silvergold.skyborne.world.feature.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.silvergold.skyborne.block.ModBlocks;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import static net.minecraft.world.level.levelgen.feature.TreeFeature.isAirOrLeaves;


public class TrunkPlacerQuartz extends StraightTrunkPlacer {
    public static final Codec<TrunkPlacerQuartz> CODEC = RecordCodecBuilder.create(
            (instance) -> trunkPlacerParts(instance).apply(instance, TrunkPlacerQuartz::new));

    public TrunkPlacerQuartz(int baseHeight, int heightRandA, int heightRandB) {
        super(baseHeight, heightRandA, heightRandB);
    }

    @Override
    protected boolean placeLog(LevelSimulatedReader p_226176_, BiConsumer<BlockPos, BlockState> p_226177_, RandomSource p_226178_, BlockPos p_226179_, TreeConfiguration p_226180_, Function<BlockState, BlockState> p_226181_) {
        Random random = new Random();
        int randomInt = random.nextInt(5) + 1; // Generates a random integer between 1 and 4 (inclusive)

        if (this.validTreePos(p_226176_, p_226179_)) {
            if (randomInt == 2) {
                // Generate Ore
                p_226177_.accept(p_226179_, Registry.BLOCK.get(new ResourceLocation("skyborne", "stone_log_quartz")).defaultBlockState());
            } else {
                // Else generate log from trunk provider
                p_226177_.accept(p_226179_, p_226181_.apply(p_226180_.trunkProvider.getState(p_226178_, p_226179_)));
            }
            return true;
        } else {
            return false;
        }
    }
}
