package io.github.zephyrwolf.medievalism.client;

import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.client.screen.StoneBenchScreen;
import io.github.zephyrwolf.medievalism.content.menu.MenuRegistration;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@SuppressWarnings("unused")
@EventBusSubscriber(modid = MedievalismConstants.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {

    @SubscribeEvent
    public static void init(FMLClientSetupEvent event)
    {
        //ItemBlockRenderTypes.setRenderLayer(Registration.BRANCH_BLOCK.get(), RenderType.CUTOUT);
    }

    @SubscribeEvent
    public static void registerMenuSceens(RegisterMenuScreensEvent event)
    {
        event.register(MenuRegistration.STONE_BENCH_MENU.get(), StoneBenchScreen::new);
    }

    @SubscribeEvent
    public static void initClient(EntityRenderersEvent.RegisterRenderers event)
    {
        //event.registerBlockEntityRenderer(Registration.COMPLEX_BLOCK_ENTITY.get(), ComplexBlockRenderer::new);
    }

}
