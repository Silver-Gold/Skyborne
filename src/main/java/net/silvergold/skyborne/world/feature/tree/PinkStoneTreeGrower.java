package net.silvergold.skyborne.world.feature.tree;

import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.silvergold.skyborne.world.feature.ModConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

public class PinkStoneTreeGrower extends AbstractTreeGrower {
    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource p_222910_, boolean p_222911_) {
        return ModConfiguredFeatures.PINK_STONE_TREE.getHolder().get();
    }
}
