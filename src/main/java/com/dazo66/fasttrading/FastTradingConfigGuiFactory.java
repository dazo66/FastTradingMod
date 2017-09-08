package com.dazo66.fasttrading;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.ForgeVersion;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.GuiConfigEntries;
import net.minecraftforge.fml.client.config.IConfigElement;
import net.minecraftforge.fml.client.config.DummyConfigElement.DummyCategoryElement;
import net.minecraftforge.fml.client.config.GuiConfigEntries.CategoryEntry;

public class FastTradingConfigGuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {
    }

    @Override
    public boolean hasConfigGui() {
	return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parent) {
	return new FastTradingConfigGui(parent);
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
	return null;
    }

    public static class FastTradingConfigGui extends GuiConfig {
	    public FastTradingConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(), ForgeVersion.MOD_ID, false, false, "TCFastTradingModConfig");
	    }

	    public static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyCategoryElement("Farmer", "Farmer", Farmer.class));
		list.add(new DummyCategoryElement("Fisherman", "Fisherman", Fisherman.class));
		list.add(new DummyCategoryElement("Fletcher", "Fletcher", Fletcher.class));
		list.add(new DummyCategoryElement("Shepherd", "Shepherd", Shepherd.class));
		list.add(new DummyCategoryElement("Tool", "Tool", Tool.class));
		list.add(new DummyCategoryElement("Weapon", "Weapon", Weapon.class));
		list.add(new DummyCategoryElement("Armor", "Armor", Armor.class));
		list.add(new DummyCategoryElement("Cleric", "Cleric", Cleric.class));
		list.add(new DummyCategoryElement("Librarian", "Librarian", Librarian.class));
		list.add(new DummyCategoryElement("Cartographer", "Cartographer", Cartographer.class));
		list.add(new DummyCategoryElement("Leather", "Leather", Leather.class));
		list.add(new DummyCategoryElement("Butcher", "Butcher", Butcher.class));
		return list;
	    }

	    public static class Farmer extends CategoryEntry {

		public Farmer(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Farmer"))).getChildElements(), this.owningScreen.modID, "Farmer", false, false, "Farmer");
		}

	    }
	    public static class Fisherman extends CategoryEntry {

		public Fisherman(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Fisherman"))).getChildElements(), this.owningScreen.modID, "Fisherman", false, false, "Fisherman");
		}

	    }
	    
	    public static class Fletcher extends CategoryEntry {

		public Fletcher(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Fletcher"))).getChildElements(), this.owningScreen.modID, "Fletcher", false, false, "Fletcher");
		}

	    }
	    
	    public static class Shepherd extends CategoryEntry {

		public Shepherd(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Shepherd"))).getChildElements(), this.owningScreen.modID, "Shepherd", false, false, "Shepherd");
		}

	    }
	    
	    public static class Tool extends CategoryEntry {

		public Tool(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Tool"))).getChildElements(), this.owningScreen.modID, "Tool", false, false, "Tool");
		}

	    }
	    
	    public static class Weapon extends CategoryEntry {

		public Weapon(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Weapon"))).getChildElements(), this.owningScreen.modID, "Weapon", false, false, "Weapon");
		}

	    }
	    
	    public static class Armor extends CategoryEntry {

		public Armor(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Armor"))).getChildElements(), this.owningScreen.modID, "Armor", false, false, "Armor");
		}

	    }
	    
	    public static class Cleric extends CategoryEntry {

		public Cleric(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Cleric"))).getChildElements(), this.owningScreen.modID, "Cleric", false, false, "Cleric");
		}

	    }
	    
	    public static class Librarian extends CategoryEntry {

		public Librarian(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Librarian"))).getChildElements(), this.owningScreen.modID, "Librarian", false, false, "Librarian");
		}

	    }
	    
	    public static class Cartographer extends CategoryEntry {

		public Cartographer(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Cartographer"))).getChildElements(), this.owningScreen.modID, "Cartographer", false, false, "Cartographer");
		}

	    }
	    
	    public static class Leather extends CategoryEntry {

		public Leather(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Leather"))).getChildElements(), this.owningScreen.modID, "Leather", false, false, "Leather");
		}

	    }
	    
	    public static class Butcher extends CategoryEntry {

		public Butcher(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
		    super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
		    return new GuiConfig(this.owningScreen, (new ConfigElement(ConfigLoader.config.getCategory("Butcher"))).getChildElements(), this.owningScreen.modID, "Butcher", false, false, "Butcher");
		}

	    }

	}
}
