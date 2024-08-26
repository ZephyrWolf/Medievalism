package io.github.zephyrwolf.medievalism.client.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.zephyrwolf.medievalism.MedievalismConstants;
import io.github.zephyrwolf.medievalism.common.menu.StoneBenchMenu;
import io.github.zephyrwolf.medievalism.common.network.MalleableMaterialCellClicked;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.neoforged.neoforge.network.PacketDistributor;

import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@MethodsReturnNonnullByDefault
public class StoneBenchScreen extends AbstractContainerScreen<StoneBenchMenu>
{
    private static final ResourceLocation TEXTURE =
            MedievalismConstants.resource("textures/gui/stone_bench.png");

    public StoneBenchScreen(StoneBenchMenu pMenu, Inventory pPlayerInventory, Component pTitle)
    {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init()
    {
        imageWidth = 176;
        imageHeight = 200;
        super.init();
        inventoryLabelY = imageHeight - 94;
    }

    @Override
    public boolean mouseClicked(double pMouseX, double pMouseY, int pButton)
    {
        if (menu.blockEntity.getMaterial().isPresent())
        {
            var material = menu.blockEntity.getMaterial().get();
            int x = (width - imageWidth) / 2+48;
            int y = (height - imageHeight) / 2+20;
            int numRows = material.rows();
            int numCols = material.cols();
            int numDiv = Math.max(Math.max(numRows, numCols), 5);
            int matrixPxSize = 80;
            int squarePxSize = matrixPxSize / numDiv;

            x += (matrixPxSize - squarePxSize * numCols) / 2;
            y += (matrixPxSize - squarePxSize * numRows) / 2;

            if (pMouseX >= x && pMouseX < x + numCols * squarePxSize && pMouseY >= y && pMouseY < y + numRows * squarePxSize)
            {
                int mouseCol = (int) (pMouseX - x) / squarePxSize;
                int mouseRow = (int) (pMouseY - y) / squarePxSize;
                //menu.blockEntity.material.get().pattern().set(mouseRow * numCols + mouseCol, false);
                PacketDistributor.sendToServer(new MalleableMaterialCellClicked(mouseRow * numCols + mouseCol));
            }
        }
        return super.mouseClicked(pMouseX, pMouseY, pButton);
    }

    @Override
    protected void renderBg(GuiGraphics pGuiGraphics, float pPartialTick, int pMouseX, int pMouseY)
    {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        pGuiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick)
    {
        renderBackground(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        renderTooltip(pGuiGraphics, pMouseX, pMouseY);

        if (menu.blockEntity.getMaterial().isPresent())
        {
            var material = menu.blockEntity.getMaterial().get();
            int x = (width - imageWidth) / 2+48;
            int y = (height - imageHeight) / 2+20;
            int numRows = material.rows();
            int numCols = material.cols();
            int numDiv = Math.max(Math.max(numRows, numCols), 5);
            int matrixPxSize = 80;
            int squarePxSize = matrixPxSize / numDiv;

            x += (matrixPxSize - squarePxSize * numCols) / 2;
            y += (matrixPxSize - squarePxSize * numRows) / 2;
            for (int row = 0; row < numRows; row++)
            {
                for (int col = 0; col < numCols; col++)
                {
                    boolean positive = material.pattern().get(row * numCols + col);
                    int colour = positive ? material.material().getPositiveColour() : material.material().getNegativeColour();
                    int dx = col * squarePxSize; // 0xFFAFB9D6 positive
                    int dy = row * squarePxSize; // 0xFF373944 negative
                    pGuiGraphics.fill(x + dx, y + dy, x + dx + squarePxSize, y + dy + squarePxSize, colour); // ARGB
                }
            }
        }
    }
}
