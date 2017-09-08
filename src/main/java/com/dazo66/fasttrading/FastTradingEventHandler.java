package com.dazo66.fasttrading;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerMerchant;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FastTradingEventHandler {
    public FastTradingEventHandler() {
    }

    public static FastTradingEventHandler instance = new FastTradingEventHandler();
    public static EntityPlayerSP playerIn;
    public static boolean isOpen = true;
    public static ContainerMerchant container;
    public static GuiMerchant guiMerchant;
    private InventoryPlayer inventory;
    private IMerchant iMerchant;
    private GuiMerchantOverride guiMerchantOverride;

    @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
    public void guiOpenEvent(GuiOpenEvent event0) {
	if ((event0.getGui() instanceof net.minecraft.client.gui.GuiMerchant)) {
	    playerIn = Minecraft.getMinecraft().player;
	    inventory = playerIn.inventory;
	    IMerchant iMerchant = ((GuiMerchant) event0.getGui()).getMerchant();
	    this.guiMerchantOverride = new GuiMerchantOverride(inventory, iMerchant, playerIn.world);
	    guiMerchant = (GuiMerchant) event0.getGui();
	    event0.setGui(this.guiMerchantOverride);
	}

    }

    @net.minecraftforge.fml.common.eventhandler.SubscribeEvent
    public void containerOpenEvent(PlayerContainerEvent event) {
	if ((event.getContainer() instanceof net.minecraft.inventory.ContainerMerchant)) {
	    FastTradingEventHandler.container = (ContainerMerchant) event.getContainer();
	}

    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void onKeyInput(KeyInputEvent event) {
	if (KeyLoader.key_F4.isPressed()) {
	    if (isOpen) {
		isOpen = false;
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString("FastTradingMod-OFF"));

	    } else {
		isOpen = true;
		Minecraft.getMinecraft().player.sendMessage(new TextComponentString("FastTradingMod-ON"));
	    }
	}
    }

}
