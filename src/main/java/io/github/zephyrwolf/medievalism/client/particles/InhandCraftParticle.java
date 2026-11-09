package io.github.zephyrwolf.medievalism.client.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class InhandCraftParticle extends TextureSheetParticle
{
    private final SpriteSet spriteSet;

    public InhandCraftParticle(ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed, SpriteSet spriteSet)
    {
        super(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
        this.spriteSet = spriteSet;
        this.setSpriteFromAge(spriteSet);
    }

    @Override
    public @NotNull ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_LIT; // or Opaque
    }

    @Override
    public void tick()
    {
        this.setSpriteFromAge(spriteSet);
        setParticleSpeed(xd, yd - 0.1, zd);
        super.tick();
    }

    public static class InhandCraftParticleProvider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet spriteSet;

        public InhandCraftParticleProvider(SpriteSet spriteSet)
        {
            this.spriteSet = spriteSet;
        }

        @Override
        public @Nullable Particle createParticle(
                @NotNull SimpleParticleType pType,
                @NotNull ClientLevel pLevel,
                double pX, double pY, double pZ,
                double pXSpeed, double pYSpeed, double pZSpeed)
        {
            // return new KnapDebrisParticle(pLevel, pX, pY, pZ, spriteSet);
            return new InhandCraftParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, spriteSet);
        }
    }
}
