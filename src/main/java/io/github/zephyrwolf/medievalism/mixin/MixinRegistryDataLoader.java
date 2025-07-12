package io.github.zephyrwolf.medievalism.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import io.github.zephyrwolf.medievalism.registration.block.BlockRegistration;
import io.github.zephyrwolf.medievalism.tools.SurfaceRulesTools;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

@Mixin(RegistryDataLoader.class)
public class MixinRegistryDataLoader
{

    @Inject(
            method = "loadElementFromResource",
            at = @At("HEAD"),
            cancellable = true
    )
    private static <E> void modifyCandidateBeforeUse(
            WritableRegistry<E> pRegistry,
            Decoder<E> pCodec,
            RegistryOps<JsonElement> pOps,
            ResourceKey<E> pResourceKey,
            Resource pResource,
            RegistrationInfo pRegistrationInfo,
            CallbackInfo ci
    ) throws IOException
    {
        ci.cancel();
        Decoder<Optional<E>> decoder = net.neoforged.neoforge.common.conditions.ConditionalOps.createConditionalCodec(net.neoforged.neoforge.common.util.NeoForgeExtraCodecs.decodeOnly(pCodec));
        try (Reader reader = pResource.openAsReader()) {
            JsonElement jsonelement = JsonParser.parseReader(reader);
            DataResult<Optional<E>> dataresult = decoder.parse(pOps, jsonelement);
            Optional<E> candidate = dataresult.getOrThrow();
            //region Modify candidate
            // I tried to inject my modification here however mixin just can't seem to target this spot AND give me the local candidate AND the parameter pRouseKey
            if (pResourceKey.registry().equals(NoiseGeneratorSettings.OVERWORLD.registry())
                    && pResourceKey.location().equals(NoiseGeneratorSettings.OVERWORLD.location()))
            { // So Essentially pResourceKey.equals(NoiseGeneratorSettings.OVERWORLD) haha // Keep separate for now
                if (candidate.isPresent())
                {
                    NoiseGeneratorSettings e = (NoiseGeneratorSettings) candidate.get();
                    candidate = modifyNoiseGeneratorSettings(e);
                }
            }
            //endregion Stop modify candidate
            candidate.ifPresentOrElse(e -> {
                pRegistry.register(pResourceKey, e, pRegistrationInfo);
            }, () -> {
                LogUtils.getLogger().debug("Skipping loading registry entry {} as its conditions were not met", pResourceKey);
            });
        }
    }

    private static <E> @NotNull Optional<E> modifyNoiseGeneratorSettings(NoiseGeneratorSettings e)
    {
        SurfaceRules.RuleSource modifiedSurfaceRule = SurfaceRules.sequence(
                e.surfaceRule(),
                SurfaceRules.ifTrue(
                        SurfaceRulesTools.yBlockRangeCheck(VerticalAnchor.absolute(60), VerticalAnchor.absolute(60)),
                        SurfaceRules.state(BlockRegistration.LIMESTONE.get().defaultBlockState())
                )
        );

        // Whats the dif between yBlockCheck and yStartCheck

        @SuppressWarnings("deprecation")
        NoiseGeneratorSettings modified = new NoiseGeneratorSettings(
                e.noiseSettings(),
                e.defaultBlock(),
                e.defaultFluid(),
                e.noiseRouter(),
                modifiedSurfaceRule,
                e.spawnTarget(),
                e.seaLevel(),
                e.disableMobGeneration(),
                e.aquifersEnabled(),
                e.oreVeinsEnabled(),
                e.useLegacyRandomSource()
        );

        @SuppressWarnings("unchecked")
        Optional<E> newCandidate = Optional.of((E) modified);
        return newCandidate;
    }
}
