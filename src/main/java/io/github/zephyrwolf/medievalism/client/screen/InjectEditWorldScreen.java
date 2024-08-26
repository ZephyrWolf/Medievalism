package io.github.zephyrwolf.medievalism.client.screen;


import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class InjectEditWorldScreen
{ // EditWorldScreen // EditWorldList // SelectWorldScreen
    // SelectWorldScreen > Edit is actually SelectWorldScreen.renameButton in code; they should really update that.
    // Click calls WorldSelectionList$editWorld
    // OptionsScreen
    // PackSelectionScreen
    private static final Component DATAPACK_BUTTON = Component.nullToEmpty("Choose Datapacks");

    public InjectEditWorldScreen()
    {
        // SelectWorldScreen
        /*
        this.layout.addChild(Button.builder(DATAPACK_BUTTON), button -> {

            LevelStorageSource levelstoragesource = pMinecraft.getLevelSource();
            Path path = levelstoragesource.getBackupPath();

            try {
                FileUtil.createDirectoriesSafe(path);
            } catch (IOException ioexception) {
                throw new RuntimeException(ioexception);
            }

            Util.getPlatform().openPath(path);

        }).width(200).build();


        this.layout.addChild(this.openScreenButton(
                DATAPACK_BUTTON,
                () -> new DataPackSelectionScreen(
                        this.minecraft.getResourcePackRepository(),
                        this::applyPacks,
                        this.minecraft.getResourcePackDirectory(),
                        Component.translatable("resourcePack.title")
                    )
            ));

        OptionsScreen$
        private Button openScreenButton(Component pName, Supplier<Screen> pScreenSupplier)
        {
            return Button.builder(pName, button -> this.minecraft.setScreen(pScreenSupplier.get())).build();
        }
        */

        /* // lul wut
        this.layout.visitWidgets(p_321379_ -> {
            AbstractWidget abstractwidget = this.addRenderableWidget(p_321379_);
        });
         */
    }
}
