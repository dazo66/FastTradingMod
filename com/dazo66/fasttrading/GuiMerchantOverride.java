package com.dazo66.fasttrading;

import java.io.IOException;
import net.minecraft.client.gui.GuiMerchant;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.Slot;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.world.World;

public class GuiMerchantOverride extends GuiMerchant {

    private MerchantRecipeList merchantRecipeList;
    private IMerchant iMerchant;
    private boolean flag = false;

    public GuiMerchantOverride(InventoryPlayer p_i45500_1_, IMerchant p_i45500_2_, World worldIn) {
	super(p_i45500_1_, p_i45500_2_, worldIn);
	iMerchant = p_i45500_2_;

    }

    @Override
    public void updateScreen() {
	super.updateScreen();

	if (!flag) {
	    try {
		run();
	    } catch (IOException e) {
		// TODO ���������� catch ��
		e.printStackTrace();
	    }

	    flag = true;
	}
    }

    public void run() throws IOException {
	
	if (FastTradingEventHandler.isOpen) {
	    if (ConfigLoader.config.hasChanged()) {
		ConfigLoader.config.save();
		ConfigLoader.load();
	    }

	    merchantRecipeList = iMerchant.getRecipes(FastTradingEventHandler.playerIn);
	    String name = getVillagerType(merchantRecipeList);
	    if (name.equals("")) {
		return;
	    }
	    if (FastTrading.villager.containsKey(name)) {
		for (int i = 0; i < merchantRecipeList.size(); i++) {
		    if (FastTrading.villager.get(name).containsKey(i)) {
			if ((boolean) FastTrading.villager.get(name).get(i)) {
			    for (int i1 = 3; i1 < inventorySlots.inventorySlots.size(); i1++) {
				if (merchantRecipeList.get(i).isRecipeDisabled())
				    break;
				if (inventorySlots.getSlot(i1).getStack().isItemEqual(merchantRecipeList.get(i).getItemToBuy()) && inventorySlots.getSlot(i1).getStack().getCount() >= merchantRecipeList.get(i).getItemToBuy().getCount()) {
				    Slot tempslot = inventorySlots.getSlot(i1);
				    Slot buyslot = inventorySlots.getSlot(0);
				    Slot sellslot = inventorySlots.getSlot(2);
				    handleMouseClick(tempslot, i1, 0, ClickType.PICKUP);
				    handleMouseClick(buyslot, 0, 0, ClickType.PICKUP);
				    handleMouseClick(sellslot, 2, 0, ClickType.QUICK_MOVE);
				    handleMouseClick(buyslot, 0, 0, ClickType.QUICK_MOVE);
				    i1 = 3;
				}
			    }
			}

		    }
		    mouseClicked((width - xSize) / 2 + 120 + 27, (height - ySize) / 2 + 24 - 1, 0);
		}
	    }
	    for (int i = 0; i < merchantRecipeList.size(); i++) {
		super.updateScreen();
		mouseClicked((width - xSize) / 2 + 36 - 19, (height - ySize) / 2 + 24 - 1, 0);
	    }

	}
    }

    public String getVillagerType(MerchantRecipeList list) {
	if (list == null) {
	    System.out.println("list == null");
	    return "";
	}
	if (list.size() == 1) {
	    return "entity.Villager.cartographer";
	} else {
	    return VillagerType.getVillagerType(list.get(0), list.get(1));
	}

    }

}
