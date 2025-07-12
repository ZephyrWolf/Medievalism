package io.github.zephyrwolf.medievalism.tools;

import io.github.zephyrwolf.medievalism.client.particles.KnapDebrisParticle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.protocol.game.ClientboundLevelParticlesPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public final class ParticleTools
{
    // Will spawn a particle from Client Side to only this Client
    public static <T extends ParticleOptions> void addParticleClient(
            ClientLevel pClientLevel, Player player, T pType, double pPosX, double pPosY, double pPosZ, double pXOffset, double pYOffset, double pZOffset)
    {
        Minecraft.getInstance().particleEngine.createParticle(pType, pPosX, pPosY, pPosZ, pXOffset, pYOffset, pZOffset);
    }

    // Will spawn a particle from Server Side to all clients. if player is not null, will NOT send to that player
    public static <T extends ParticleOptions> int sendParticlesServer(
            ServerLevel pServerLevel, @Nullable Player player, T pType, double pPosX, double pPosY, double pPosZ, int pParticleCount, double pXOffset, double pYOffset, double pZOffset, double pSpeed
    ) {
        ClientboundLevelParticlesPacket clientboundlevelparticlespacket = new ClientboundLevelParticlesPacket(
                pType, false, pPosX, pPosY, pPosZ, (float)pXOffset, (float)pYOffset, (float)pZOffset, (float)pSpeed, pParticleCount
        );
        int i = 0;

        for (int j = 0; j < pServerLevel.players().size(); j++)
        {
            ServerPlayer serverplayer = pServerLevel.players().get(j);
            if (player != null && serverplayer == player) continue;
            if (pServerLevel.sendParticles(serverplayer, false, pPosX, pPosY, pPosZ, clientboundlevelparticlespacket)) {
                i++;
            }
        }
        return i;
    }
}
