package io.github.zephyrwolf.medievalism.tools;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.jetbrains.annotations.NotNull;

public final class SurfaceRulesTools
{
    record YRangeConditionSource(VerticalAnchor anchorLower, VerticalAnchor anchorHigher) implements SurfaceRules.ConditionSource {
        static final KeyDispatchDataCodec<SurfaceRulesTools.YRangeConditionSource> CODEC = KeyDispatchDataCodec.of(
                RecordCodecBuilder.mapCodec(
                        p_189455_ -> p_189455_.group(
                                        VerticalAnchor.CODEC.fieldOf("anchor").forGetter(SurfaceRulesTools.YRangeConditionSource::anchorLower),
                                        VerticalAnchor.CODEC.fieldOf("anchor").forGetter(SurfaceRulesTools.YRangeConditionSource::anchorHigher)
                                        )
                                .apply(p_189455_, SurfaceRulesTools.YRangeConditionSource::new)
                )
        );

        @Override
        public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.ConditionSource> codec() {
            return CODEC;
        }

        public SurfaceRules.Condition apply(final SurfaceRules.Context pContext) {
            class YCondition extends SurfaceRules.LazyYCondition {
                YCondition() {
                    super(pContext);
                }

                @Override
                protected boolean compute() {
                    return this.context.blockY >= SurfaceRulesTools.YRangeConditionSource.this.anchorLower.resolveY(this.context.context)
                            && this.context.blockY <= SurfaceRulesTools.YRangeConditionSource.this.anchorHigher.resolveY(this.context.context);
                }
            }

            return new YCondition();
        }
    }

    public static SurfaceRules.ConditionSource yBlockRangeCheck(VerticalAnchor pAnchorLower, VerticalAnchor pAnchorHigher) {
        return new YRangeConditionSource(pAnchorLower, pAnchorHigher);
    }

    public record LazyDefaultBlockRule(DeferredBlock<? extends Block> block) implements SurfaceRules.SurfaceRule {
        @Override
        public BlockState tryApply(int x, int y, int z) {
            return this.block.get().defaultBlockState(); // You should make this a supplier, but then you may have issues with the CODEC
        }
    }
}
