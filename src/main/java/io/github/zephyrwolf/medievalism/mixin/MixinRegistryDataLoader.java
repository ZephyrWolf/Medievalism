package io.github.zephyrwolf.medievalism.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mojang.logging.LogUtils;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Decoder;
import io.github.zephyrwolf.medievalism.data.overhauldata.worldgen.level.OverhaulVanillaLevelStoneGeneration;
import net.minecraft.core.RegistrationInfo;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.neoforged.neoforge.common.conditions.ConditionalOps;
import net.neoforged.neoforge.common.util.NeoForgeExtraCodecs;
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
        Decoder<Optional<E>> decoder = ConditionalOps.createConditionalCodec(NeoForgeExtraCodecs.decodeOnly(pCodec));
        try (Reader reader = pResource.openAsReader()) {
            JsonElement jsonelement = JsonParser.parseReader(reader);
            DataResult<Optional<E>> dataresult = decoder.parse(pOps, jsonelement);
            Optional<E> candidate = dataresult.getOrThrow();
            //region Modify candidate
            // I tried to inject my modification here however mixin just can't seem to target this spot AND give me the local candidate AND the parameter pRouseKey
            if (pResourceKey.registry().equals(NoiseGeneratorSettings.OVERWORLD.registry())
                    && pResourceKey.location().equals(NoiseGeneratorSettings.OVERWORLD.location())) { // So Essentially pResourceKey.equals(NoiseGeneratorSettings.OVERWORLD) haha // Keep separate for now
                if (candidate.isPresent()) {
                    NoiseGeneratorSettings e = (NoiseGeneratorSettings) candidate.get();
                    candidate = OverhaulVanillaLevelStoneGeneration.modifyNoiseGeneratorSettings(e);
                }
            }
            //endregion Stop modify candidate
            candidate.ifPresentOrElse(e ->
            {
                pRegistry.register(pResourceKey, e, pRegistrationInfo);
            }, () ->
            {
                LogUtils.getLogger().debug("Skipping loading registry entry {} as its conditions were not met", pResourceKey);
            });
        }
    }

}
