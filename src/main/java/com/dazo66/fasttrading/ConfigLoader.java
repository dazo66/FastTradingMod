package com.dazo66.fasttrading;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.DummyModContainer;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.Logger;

import com.google.common.eventbus.Subscribe;

@Config(modid = FastTrading.MODID)
public class ConfigLoader extends DummyModContainer {
    protected static Configuration config;

    private static Logger logger;

    public ConfigLoader(FMLPreInitializationEvent event) {

	config = new Configuration(event.getSuggestedConfigurationFile());
	config.load();
	load();
    }

    public static void load() {

	FastTrading.villager.clear();

	config.load();
	
	Map farmer = new HashMap();
	farmer.put(0, config.get("farmer", "Wheat->Emerald", true, "农民:小麦->绿宝石").getBoolean());
	farmer.put(1, config.get("farmer", "Potato->Emerald", true, "农民:土豆->绿宝石").getBoolean());
	farmer.put(2, config.get("farmer", "Carrot->Emerald", true, "农民:胡萝卜->绿宝石").getBoolean());
	farmer.put(4, config.get("farmer", "Pumpkin->Emerald", true, "农民:南瓜->绿宝石").getBoolean());
	farmer.put(6, config.get("farmer", "Melon->Emerald", true, "农民:西瓜->绿宝石 ").getBoolean());
	FastTrading.villager.put("entity.Villager.farmer", farmer);

	Map fisherman = new HashMap();
	fisherman.put(0, config.get("fisherman", "String->Emerald", true, "渔夫:线->绿宝石").getBoolean());
	fisherman.put(1, config.get("fisherman", "Coal->Emerald", true, "渔夫:煤->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.fisherman", fisherman);

	Map fletcher = new HashMap();
	fletcher.put(0, config.get("fletcher", "String->Emerald", true, "制箭师:线->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.fletcher", fletcher);

	Map shepherd = new HashMap();
	shepherd.put(0, config.get("shepherd", "Wool->Emerald", true, "牧羊人:白色羊毛->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.shepherd", shepherd);

	Map tool = new HashMap();
	tool.put(0, config.get("tool", "Coal->Emerald", false, "工具商:煤->绿宝石").getBoolean());
	tool.put(2, config.get("tool", "Iron->Emerald", true, "工具商:铁->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.tool", tool);

	Map weapon = new HashMap();
	weapon.put(0, config.get("weapon", "Coal->Emerald", false, "武器商:煤->绿宝石").getBoolean());
	weapon.put(2, config.get("weapon", "Iron->Emerald", true, "武器商:铁->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.weapon", weapon);

	Map armor = new HashMap();
	armor.put(0, config.get("armor", "Coal->Emerald", false, "防具商:煤->绿宝石").getBoolean());
	armor.put(2, config.get("armor", "Iron->Emerald", true, "防具商:铁->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.armor", armor);

	Map cleric = new HashMap();
	cleric.put(0, config.get("cleric", "RottenFlesh->Emerald", true, "牧师:腐肉->绿宝石").getBoolean());
	cleric.put(1, config.get("cleric", "GoldIngot->Emerald", true, "牧师:金锭->绿宝石").getBoolean());
	cleric.put(2, config.get("cleric", "Emerald->Redstone", false, "牧师:绿宝石->红石").getBoolean());
	cleric.put(3, config.get("cleric", "Emerald->LapisLazuli", false, "牧师:绿宝石->青金石").getBoolean());
	FastTrading.villager.put("entity.Villager.cleric", cleric);

	Map librarian = new HashMap();
	librarian.put(0, config.get("librarian", "Paper->Emerald", false, "图书管理员:纸->绿宝石").getBoolean());
	librarian.put(2, config.get("librarian", "Book->Emerald", false, "图书管理员:书->绿宝石").getBoolean());
	librarian.put(7, config.get("librarian", "Emerald->Glass", false, "图书管理员:绿宝石->玻璃").getBoolean());
	FastTrading.villager.put("entity.Villager.librarian", librarian);

	Map cartographer = new HashMap();
	cartographer.put(0, config.get("cartographer", "Book->Emerald", true, "制图师:纸->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.cartographer", cartographer);

	Map leather = new HashMap();
	leather.put(0, config.get("leather", "Leather->Emerald", true, "皮匠:皮革->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.leather", leather);

	Map butcher = new HashMap();
	butcher.put(0, config.get("butcher", "RawPorkchop->Emerald", true, "屠夫:生猪肉->绿宝石 ").getBoolean());
	butcher.put(1, config.get("butcher", "RawChicken->Emerald", true, "屠夫:生鸡肉->绿宝石").getBoolean());
	butcher.put(2, config.get("butcher", "Coal->Emerald", true, "屠夫:煤->绿宝石").getBoolean());
	FastTrading.villager.put("entity.Villager.butcher", butcher);

	config.save();

    }

    public static Logger logger() {
	return logger;
    }

    @Override
    public String getGuiClassName() {
	return "com.dazo66.fasttrading.FastTradingConfigGuiFactory";
    }

    @Subscribe
    public void preInit(FMLPreInitializationEvent evt) {
	MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = FastTrading.MODID)
    private static class EventHandler {


    }
}