package com.dazo66.fasttrading;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid="fasttrading", version="1.5", guiFactory="com.dazo66.fasttrading.FastTradingConfigGuiFactory",acceptedMinecraftVersions="[1.12]")
public class FastTrading
{
  public static final String MODID = "fasttrading";
  public static final String NAME = "FastTrading";
  public static final String VERSION = "1.5";
  public ConfigLoader config;
  public static Map<String, Map> villager = new HashMap<String, Map>();
  
  public FastTrading() 
  {
      
  }
  
  @Mod.EventHandler
  public void initialize(FMLInitializationEvent evt) {
    MinecraftForge.EVENT_BUS.register(this);
    MinecraftForge.EVENT_BUS.register(config);
  }
  
  @Mod.EventHandler
  public void init(FMLInitializationEvent event)
  {
    net.minecraftforge.common.MinecraftForge.EVENT_BUS.register(FastTradingEventHandler.instance);
    new KeyLoader();
  }
  
  @EventHandler
  public void preInit(FMLPreInitializationEvent event)
  {
      config = new ConfigLoader(event);
  }
  
}
