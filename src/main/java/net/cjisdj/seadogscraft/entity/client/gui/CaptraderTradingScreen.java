package net.cjisdj.seadogscraft.entity.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.cjisdj.seadogscraft.SeaDogsCraft;
import net.cjisdj.seadogscraft.entity.network.CaptraderTradingButtonMessage;
import net.cjisdj.seadogscraft.entity.world.inventory.CaptraderTradingMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.HashMap;

public class CaptraderTradingScreen extends AbstractContainerScreen<CaptraderTradingMenu> {
	private final static HashMap<String, Object> guistate = CaptraderTradingMenu.guistate;
	private static final ResourceLocation texture = new ResourceLocation("seadogscraft:textures/screens/captrader_trading.png");
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_next;
	Button button_previous;

	public CaptraderTradingScreen(CaptraderTradingMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.seadogscraft.captrader_trading.label_emerald"), 15, 39, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.seadogscraft.captrader_trading.label_trades"), 123, 39, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_next = Button.builder(Component.translatable("gui.seadogscraft.captrader_trading.button_next"), e -> {
			if (true) {
				SeaDogsCraft.PACKET_HANDLER.sendToServer(new CaptraderTradingButtonMessage(0, x, y, z));
				CaptraderTradingButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 114, this.topPos + 57, 54, 20).build();
		guistate.put("button:button_next", button_next);
		this.addRenderableWidget(button_next);
		button_previous = Button.builder(Component.translatable("gui.seadogscraft.captrader_trading.button_previous"), e -> {
			if (true) {
				SeaDogsCraft.PACKET_HANDLER.sendToServer(new CaptraderTradingButtonMessage(1, x, y, z));
				CaptraderTradingButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 57, 54, 20).build();
		guistate.put("button:button_previous", button_previous);
		this.addRenderableWidget(button_previous);
	}
}
