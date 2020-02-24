package dev.mrshawn.cronus;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cronus extends JavaPlugin {

	private static Cronus instance;

	@Override
	public void onEnable() {
		instance = this;
		registerEvents();
	}

	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}

	private void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
	}

	public static Cronus getInstance() {
		return instance;
	}

}
