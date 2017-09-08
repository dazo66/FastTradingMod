package com.dazo66.fasttrading;

import net.minecraft.village.MerchantRecipe;

public class VillagerType {
    public static String getVillagerType(MerchantRecipe recipe1,MerchantRecipe recipe2){
	String buy1 = recipe1.getItemToBuy().getUnlocalizedName();
	String buy2 = recipe2.getItemToBuy().getUnlocalizedName();
	String sell2 = recipe2.getItemToSell().getUnlocalizedName();
	if(buy1.equals("item.wheat")){
	    return "entity.Villager.farmer";
	}else if(buy2.equals("item.coal")){
	    return "entity.Villager.fisherman";
	}else if(buy1.equals("item.string")){
	    return "entity.Villager.fletcher";
	}else if(buy1.equals("tile.cloth.white")){
	    return "entity.Villager.shepherd";
	}else if(sell2.equals("item.shovelIron")){
	    return "entity.Villager.tool";
	}else if(sell2.equals("item.hatchetIron")){
	    return "entity.Villager.weapon";
	}else if(sell2.equals("item.helmetIron")){
	    return "entity.Villager.armor";
	}else if(buy1.equals("item.rottenFlesh")){
	    return "entity.Villager.cleric";
	}else if(buy1.equals("item.leather")){
	    return "entity.Villager.leather";
	}else if(buy2.equals("item.compass")){
	    return "entity.Villager.cartographer";
	}else if(buy2.equals("item.book")){
	    return "entity.Villager.librarian";
	}else{
	    return "entity.Villager.butcher";
	}
    }
}
